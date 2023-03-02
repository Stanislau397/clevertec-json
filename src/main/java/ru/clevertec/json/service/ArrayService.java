package ru.clevertec.json.service;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import static ru.clevertec.json.validator.FieldValidator.isFieldComponentABoolean;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAByte;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentADouble;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAFloat;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentALong;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAShort;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAString;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentAnInt;
import static ru.clevertec.json.validator.FieldValidator.isFieldComponentTypeAnEnum;

public class ArrayService {

    public Object buildEnumArrayFromJson(Field field, String json) {
        String[] enums = json.split(",");
        Class<Enum> clazz = (Class<Enum>) field.getType().getComponentType();
        Object enumsArray = Array.newInstance(field.getType().getComponentType(), enums.length);
        for (int i = 0; i < enums.length; i++) {
            String stringToSave = enums[i].replace("\"", "");
            Array.set(enumsArray, i, Enum.valueOf(clazz, stringToSave));
        }
        return enumsArray;
    }

    public Object buildBooleanArrayFromJson(Field field, String json) {
        String[] booleans = json.split(",");
        Object booleanArray = Array.newInstance(field.getType().getComponentType(), booleans.length);
        for (int i = 0; i < booleans.length; i++) {
            Array.set(booleanArray, i, Boolean.valueOf(booleans[i]));
        }
        return booleanArray;
    }

    public Object buildIntegerArrayFromJson(Field field, String json) {
        String[] ints = json.split(",");
        Object integersArray = Array.newInstance(field.getType().getComponentType(), ints.length);
        for (int i = 0; i < ints.length; i++) {
            Array.set(integersArray, i, Integer.parseInt(ints[i]));
        }
        return integersArray;
    }

    public Object buildByteArrayFromJson(Field field, String json) {
        String[] bytes = json.split(",");
        Object bytesArray = Array.newInstance(field.getType().getComponentType(), bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            Array.set(bytesArray, i, Byte.parseByte(bytes[i]));
        }
        return bytesArray;
    }

    public Object buildShortsArrayFromJson(Field field, String json) {
        String[] shorts = json.split(",");
        Object shortsArray = Array.newInstance(field.getType().getComponentType(), shorts.length);
        for (int i = 0; i < shorts.length; i++) {
            Array.set(shortsArray, i, Short.parseShort(shorts[i]));
        }
        return shortsArray;
    }

    public Object buildLongsArrayFromJson(Field field, String json) {
        String[] longs = json.split(",");
        Object longsArray = Array.newInstance(field.getType().getComponentType(), longs.length);
        for (int i = 0; i < longs.length; i++) {
            Array.set(longsArray, i, Long.parseLong(longs[i]));
        }
        return longsArray;
    }

    public Object buildFloatArrayFromJson(Field field, String json) {
        String[] floats = json.split(",");
        Object floatsArray = Array.newInstance(field.getType().getComponentType(), floats.length);
        for (int i = 0; i < floats.length; i++) {
            Array.set(floatsArray, i, Float.parseFloat(floats[i]));
        }
        return floatsArray;
    }

    public Object buildDoublesArrayFromJson(Field field, String value) {
        String[] doubles = value.split(",");
        Object doublesArray = Array.newInstance(field.getType().getComponentType(), doubles.length);
        for (int i = 0; i < doubles.length; i++) {
            Array.set(doublesArray, i, Double.parseDouble(doubles[i]));
        }
        return doublesArray;
    }

    public Object buildStringsArrayFromJson(Field field, String json) {
        System.out.println(json);
        String[] strings = json.split(",");
        Object stringsArray = Array.newInstance(field.getType().getComponentType(), strings.length);
        for (int i = 0; i < strings.length; i++) {
            Array.set(stringsArray, i, strings[i]);
        }
        return stringsArray;
    }

    public Object buildArrayBasedOnFieldType(Field field, String jsonArray) {
        Object fieldTypeBasedArray = new Object();
        if (isFieldComponentAString(field)) {
            fieldTypeBasedArray = buildStringsArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentABoolean(field)) {
            fieldTypeBasedArray = buildBooleanArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentAShort(field)) {
            fieldTypeBasedArray = buildShortsArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentAByte(field)) {
            fieldTypeBasedArray = buildByteArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentALong(field)) {
            fieldTypeBasedArray = buildLongsArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentAnInt(field)) {
            fieldTypeBasedArray = buildIntegerArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentADouble(field)) {
            fieldTypeBasedArray = buildDoublesArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentAFloat(field)) {
            fieldTypeBasedArray = buildFloatArrayFromJson(field, jsonArray);
        }
        if (isFieldComponentTypeAnEnum(field)) {
            fieldTypeBasedArray = buildEnumArrayFromJson(field, jsonArray);
        }
        return fieldTypeBasedArray;
    }
}
