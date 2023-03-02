package ru.clevertec.json.parser;

import ru.clevertec.json.service.ArrayService;
import ru.clevertec.json.service.CollectionService;
import ru.clevertec.json.service.FieldService;
import ru.clevertec.json.service.JsonService;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static ru.clevertec.json.validator.FieldValidator.isArrayComponentAPrimitive;
import static ru.clevertec.json.validator.FieldValidator.isFieldABoolean;
import static ru.clevertec.json.validator.FieldValidator.isFieldAChar;
import static ru.clevertec.json.validator.FieldValidator.isFieldACharacter;
import static ru.clevertec.json.validator.FieldValidator.isFieldACharacterArray;
import static ru.clevertec.json.validator.FieldValidator.isFieldACollection;
import static ru.clevertec.json.validator.FieldValidator.isFieldAMap;
import static ru.clevertec.json.validator.FieldValidator.isFieldAString;
import static ru.clevertec.json.validator.FieldValidator.isFieldAnArray;
import static ru.clevertec.json.validator.FieldValidator.isFieldAnEnum;
import static ru.clevertec.json.validator.FieldValidator.isFieldAnObjectOfOtherCustomClass;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentABoolean;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAByte;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAChar;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentACharacter;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentADouble;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAFloat;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentALong;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAShort;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAnInt;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAnObjectOfOtherCustomClass;

public class JsonParser {

    private final JsonService jsonService = new JsonService();
    private final FieldService fieldService = new FieldService();
    private final CollectionService collectionService = new CollectionService();
    private final ArrayService arrayService = new ArrayService();

    public String toJson(Object object) throws IllegalAccessException {
        String json = "{";
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            json = json.concat("\"" + field.getName() + "\"")
                    .concat(":");
            if (isFieldAString(field) || isFieldAnEnum(field)) {
                json = json.concat("\"" + field.get(object) + "\"");

            } else if (isFieldAChar(field) || isFieldACharacter(field)) {
                json = json.concat("\"" + field.get(object) + "\"");

            } else if (isFieldAnObjectOfOtherCustomClass(field)) {
                Object newObject = field.get(object);
                json = json.concat(toJson(newObject));

            } else if (isFieldACollection(field)) {
                Object[] objects = ((Collection<?>) field.get(object)).toArray();
                json = json.concat(toJsonObjectsArray(objects));

            } else if (isFieldAnArray(field) || isFieldACharacterArray(field)) {
                if (isArrayComponentAPrimitive(field)) {
                    json = json.concat(toJsonPrimitivesArray(field, object));
                } else {
                    Object[] objects = (Object[]) field.get(object);
                    json = json.concat(toJsonObjectsArray(objects));
                }

            } else if (isFieldAMap(field)) {
                json = json.concat(toJsonMap(field, object));

            } else {
                json = json.concat("" + field.get(object));
            }
            json = json.concat(",");
        }
        int lastIndexOfComma = json.lastIndexOf(',');
        json = json.substring(0, lastIndexOfComma).concat("}");
        return json;
    }

    public Object fromJson(String json, Class<?> clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {

        Object resultObject = clazz.getDeclaredConstructor().newInstance();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> arrayMap = jsonService.findArraysInJson(json, fields);
        json = jsonService.removeArraysFromJson(json, arrayMap);

        Map<String, String> maps = jsonService.findMapsInJson(json, fields);
        json = jsonService.removeMapsFromJson(json, maps);

        Map<String, String> objectsMap = jsonService.findObjectsInJson(json, fields);
        json = jsonService.removeObjectsFromJson(json, objectsMap);

        Map<String, String> stringsAndCharsMap = jsonService.findStringsAndCharsInJson(json, fields);
        json = jsonService.removeStringValuesFromJson(json, stringsAndCharsMap);

        Map<String, String> booleansMap = jsonService.findBooleansInJson(json, fields);
        json = jsonService.removeBooleansFromJson(json, booleansMap);

        Map<String, String> numbersMap = jsonService.findNumbersInJson(json, fields);

        for (Field field : fields) {
            field.setAccessible(true);
            if (isFieldACollection(field)) {

                ParameterizedType collectionType = (ParameterizedType) field.getGenericType();
                Class<?> collectionClazz = (Class<?>) collectionType.getActualTypeArguments()[0];
                Field[] objectClazzFields = collectionClazz.getDeclaredFields();
                Collection<Object> collection = collectionService.createCollectionBasedOnSimpleName(field);

                for (Map.Entry<String, String> objectEntry : arrayMap.entrySet()) {
                    String key = objectEntry.getKey().replace("\"", "");
                    String fieldName = field.getName();
                    if (key.equals(fieldName)) {
                        String value = objectEntry.getValue()
                                .replaceAll("[\\[\\]\\}\"]", "");
                        String[] valuesArray = value.split(",");
                        if (collectionClazz.getTypeName().contains("java.lang")) {
                            String simpleName = collectionClazz.getSimpleName();
                            collectionService.fillCollectionBasedOnClassSimpleName(collection, valuesArray, simpleName);

                        } else if (collectionClazz.isEnum()) {
                            collectionService.fillCollectionWithEnums(collection, collectionClazz, valuesArray);
                        } else {
                            List<String> objectsArray = jsonService.findObjectsInJsonArray(objectClazzFields, objectEntry.getValue());
                            for (int k = 0; k < objectsArray.size(); k++) {
                                collection.add(fromJson(objectsArray.get(k), collectionClazz));
                            }
                        }
                    }
                }
                field.set(resultObject, collection);

            } else if (isFieldAnObjectOfOtherCustomClass(field)) {
                for (Map.Entry<String, String> objects : objectsMap.entrySet()) {
                    String key = objects.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        Class<?> clazzOfObject = field.getType();
                        String value = objects.getValue();
                        field.set(resultObject, fromJson(value, clazzOfObject));
                    }
                }

            } else if (isFieldAString(field)) {
                for (Map.Entry<String, String> strings : stringsAndCharsMap.entrySet()) {
                    String key = strings.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        String value = strings.getValue().replace("\"", "");
                        field.set(resultObject, value);
                    }
                }
            } else if (isFieldAChar(field) || isFieldACharacter(field)) {
                for (Map.Entry<String, String> strings : stringsAndCharsMap.entrySet()) {
                    String key = strings.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        if (isFieldACharacter(field)) {
                            Character[] characters = strings.getValue()
                                    .replaceAll("[\\,\\]\\[\"]", "")
                                    .chars()
                                    .mapToObj(c -> (char) c)
                                    .toArray(Character[]::new);
                            field.set(resultObject, characters[0]);
                        } else {
                            char[] characters = strings.getValue().replace("\"", "").toCharArray();
                            field.set(resultObject, characters[0]);
                        }
                    }
                }
            } else if (isFieldAnEnum(field)) {
                Class<Enum> inner = (Class<Enum>) field.getType();
                for (Map.Entry<String, String> strings : stringsAndCharsMap.entrySet()) {
                    String key = strings.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        String value = strings.getValue().replace("\"", "");
                        field.set(resultObject, Enum.valueOf(inner, value));
                    }
                }

            } else if (isFieldACharacterArray(field)) {
                for (Map.Entry<String, String> arrayEntry : arrayMap.entrySet()) {
                    String key = arrayEntry.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        if (isFieldComponentACharacter(field)) {
                            Character[] characters = arrayEntry.getValue()
                                    .replaceAll("[\\,\\]\\[\"]", "")
                                    .chars()
                                    .mapToObj(c -> (char) c)
                                    .toArray(Character[]::new);
                            field.set(resultObject, characters);
                        } else {
                            char[] chars = arrayEntry.getValue()
                                    .replaceAll("[\\,\\]\\[\"]", "")
                                    .toCharArray();
                            field.set(resultObject, chars);
                        }
                    }
                }
            } else if (isFieldAnArray(field)) {
                Class<?> innerClazz = field.getType().getComponentType();
                for (Map.Entry<String, String> arrayEntry : arrayMap.entrySet()) {
                    String key = arrayEntry.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        String jsonArray = arrayEntry.getValue();
                        if (isFieldComponentAnObjectOfOtherCustomClass(field)) {
                            Field[] innerClazzFields = innerClazz.getDeclaredFields();
                            List<String> values = jsonService.findObjectsInJsonArray(innerClazzFields, jsonArray);
                            Object objectsArray = Array.newInstance(field.getType().getComponentType(), values.size());
                            for (int j = 0; j < values.size(); j++) {
                                Array.set(objectsArray, j, fromJson(values.get(j), innerClazz));
                            }
                            field.set(resultObject, objectsArray);

                        } else {
                            jsonArray = jsonArray.replaceAll("[\\[\\]\\}\\{\"]", "");
                            Object nonObjectArray = arrayService.buildArrayBasedOnFieldType(field, jsonArray);
                            field.set(resultObject, nonObjectArray);
                        }
                    }
                }
            } else if (isFieldABoolean(field)) {
                for (Map.Entry<String, String> aBoolean : booleansMap.entrySet()) {
                    String key = aBoolean.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        field.set(resultObject, Boolean.valueOf(aBoolean.getValue()));
                    }
                }
            } else {
                for (Map.Entry<String, String> numbers : numbersMap.entrySet()) {
                    String key = numbers.getKey().replace("\"", "");
                    if (key.equals(field.getName())) {
                        String number = numbers.getValue();
                        fieldService.setPrimitiveFields(field, resultObject, number);
                    }
                }
            }
        }
        return resultObject;
    }

    public String toJsonObjectsArray(Object[] objects) throws IllegalAccessException {
        String jsonArray = "[";
        for (Object object : objects) {
            if (object instanceof Number || object instanceof Boolean) {
                jsonArray = jsonArray
                        .concat("" + object)
                        .concat(",");
            } else if (object instanceof String || object instanceof Enum || object instanceof Character) {
                jsonArray = jsonArray
                        .concat("\"" + object + "\"")
                        .concat(",");
            } else {
                jsonArray = jsonArray
                        .concat(toJson(object))
                        .concat(",");
            }
        }
        int lastIndexOfComma = jsonArray.lastIndexOf(',');
        jsonArray = jsonArray.substring(0, lastIndexOfComma)
                .concat("]");
        return jsonArray;
    }

    public String toJsonMap(Field field, Object object) throws IllegalAccessException {
        String jsonMap = "";
        Map<?, ?> map = (Map<?, ?>) field.get(object);
        int counter = 0;
        for (Map.Entry<?, ?> mapObject : map.entrySet()) {
            if (counter > 0) {
                jsonMap = jsonMap.concat("," + "\"" + mapObject.getKey() + "\"").concat(":");
            } else {
                jsonMap = jsonMap.concat("{").concat("\"" + mapObject.getKey() + "\"").concat(":");
            }
            if (mapObject.getValue() instanceof Number) {
                jsonMap = jsonMap.concat("" + mapObject.getValue());

            } else if (mapObject.getValue() instanceof String) {
                jsonMap = jsonMap.concat("\"")
                        .concat("" + mapObject.getValue())
                        .concat("\"");

            } else {
                jsonMap = jsonMap.concat(toJson(mapObject.getValue()));
            }
            counter++;
        }
        jsonMap = jsonMap.concat("}");
        return jsonMap;
    }

    public String toJsonPrimitivesArray(Field field, Object object) throws IllegalAccessException {
        String primitivesJsonArray = "[";
        if (isFieldComponentAnInt(field)) {
            int[] ints = (int[]) field.get(object);
            for (int i = 0; i < ints.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + ints[i])
                        .concat(",");
            }
        }
        if (isFieldComponentAByte(field)) {
            byte[] bytes = (byte[]) field.get(object);
            for (int i = 0; i < bytes.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + bytes[i])
                        .concat(",");
            }
        }
        if (isFieldComponentAShort(field)) {
            short[] shorts = (short[]) field.get(object);
            for (int i = 0; i < shorts.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + shorts[i])
                        .concat(",");
            }
        }
        if (isFieldComponentALong(field)) {
            long[] longs = (long[]) field.get(object);
            for (int i = 0; i < longs.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + longs[i])
                        .concat(",");
            }
        }
        if (isFieldComponentAFloat(field)) {
            float[] floats = (float[]) field.get(object);
            for (int i = 0; i < floats.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + floats[i])
                        .concat(",");
            }
        }
        if (isFieldComponentADouble(field)) {
            double[] doubles = (double[]) field.get(object);
            for (int i = 0; i < doubles.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + doubles[i])
                        .concat(",");
            }
        }
        if (isFieldComponentABoolean(field)) {
            boolean[] booleans = (boolean[]) field.get(object);
            for (int i = 0; i < booleans.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("" + booleans[i])
                        .concat(",");
            }
        }
        if (isFieldComponentAChar(field)) {
            char[] characters = (char[]) field.get(object);
            for (int i = 0; i < characters.length; i++) {
                primitivesJsonArray = primitivesJsonArray
                        .concat("\"" + characters[i] + "\"")
                        .concat(",");
            }
        }
        int lastIndexOfComma = primitivesJsonArray.lastIndexOf(',');
        primitivesJsonArray = primitivesJsonArray
                .substring(0, lastIndexOfComma)
                .concat("]");
        return primitivesJsonArray;
    }
}
