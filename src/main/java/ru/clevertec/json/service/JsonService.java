package ru.clevertec.json.service;

import ru.clevertec.json.pattern.JsonPattern;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.clevertec.json.validator.FieldValidator.isFieldABoolean;
import static ru.clevertec.json.validator.FieldValidator.isFieldAMap;
import static ru.clevertec.json.validator.FieldValidator.isFieldANumber;

public class JsonService {

    public Map<String, String> findArraysInJson(String json, Field[] fields) {
        Map<String, String> arraysMap = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            String currentName = fields[i].getName();
            if (fields.length - 1 != i) {
                String nextName = fields[i + 1].getName();
                Matcher arrayMatcher = JsonPattern.jsonArrayPatternWithCurrentFieldAndNextField(currentName, nextName).matcher(json);
                if (arrayMatcher.find()) {
                    String collectionJson = arrayMatcher.group();
                    String replaceString = ("\"").concat(nextName).concat("\"");
                    collectionJson = collectionJson.replace(replaceString, "");
                    String[] keyAndValue = collectionJson.split(":", 2);
                    arraysMap.put(keyAndValue[0], keyAndValue[1]);
                }
            } else {
                Matcher arrayMatcher = JsonPattern.jsonArrayPatternWithoutNextField(currentName).matcher(json);
                if (arrayMatcher.find()) {
                    String collectionJson = arrayMatcher.group();
                    String[] keyAndValue = collectionJson.split(":", 2);
                    arraysMap.put(keyAndValue[0], keyAndValue[1]);
                }
            }
        }
        return arraysMap;
    }

    public Map<String, String> findMapsInJson(String json, Field[] fields) {
        Map<String, String> maps = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            String currentFieldName = fields[i].getName();
            if (isFieldAMap(fields[i])) {
                if (fields.length - 1 != i) {
                    String nextField = fields[i + 1].getName();
                    Matcher mapsMatcher = JsonPattern.jsonMapPatternWithNextField(currentFieldName, nextField).matcher(json);
                    if (mapsMatcher.find()) {
                        String mapsJson = mapsMatcher.group();
                        String replaceString = ("\"").concat(nextField).concat("\"");
                        mapsJson = mapsJson.replace(replaceString, "");
                        String[] keyAndValue = mapsJson.split(":", 2);
                        maps.put(keyAndValue[0], keyAndValue[1]);
                    }
                } else {
                    Matcher mapsMatcher = JsonPattern.jsonMapPatternWithoutNextField(currentFieldName).matcher(json);
                    if (mapsMatcher.find()) {
                        String mapsJson = mapsMatcher.group();
                        String[] keyAndValue = mapsJson.split(":", 2);
                        maps.put(keyAndValue[0], keyAndValue[1]);
                    }
                }
            }
        }
        return maps;
    }

    public Map<String, String> findObjectsInJson(String json, Field[] fields) {
        Map<String, String> objectsMap = new LinkedHashMap<>();
        for (int i = 0; i < fields.length; i++) {
            String currentFieldName = fields[i].getName();
            if (fields.length - 1 != i) {
                String nextFieldName = fields[i + 1].getName();
                Matcher objectsMatcher = JsonPattern.jsonObjectsPatternWithNextField(currentFieldName, nextFieldName).matcher(json);
                if (objectsMatcher.find()) {
                    String fieldToReplace = "\"".concat(nextFieldName)
                            .concat("\"");
                    String object = objectsMatcher.group()
                            .replace(fieldToReplace, "");
                    String[] objectsArray = object.split(":", 2);
                    objectsMap.put(objectsArray[0], objectsArray[1]);
                }
            } else {
                Matcher objectsMatcher = JsonPattern.jsonObjectsPatternWithoutNextField(currentFieldName).matcher(json);
                if (objectsMatcher.find()) {
                    String object = objectsMatcher.group();
                    String[] objectsArray = object.split(":", 2);
                    objectsMap.put(objectsArray[0], objectsArray[1]);
                }
            }
        }
        return objectsMap;
    }

    public Map<String, String> findStringsAndCharsInJson(String json, Field[] fields) {
        Map<String, String> stringsAndCharsMap = new LinkedHashMap<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            Matcher stringMatcher = JsonPattern.jsonStringPattern(fieldName).matcher(json);
            if (stringMatcher.find()) {
                String[] stringsArray = stringMatcher.group().split(":", 2);
                stringsAndCharsMap.put(stringsArray[0], stringsArray[1]);
            }
        }
        return stringsAndCharsMap;
    }

    public Map<String, String> findBooleansInJson(String json, Field[] fields) {
        Map<String, String> booleansMap = new LinkedHashMap<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            Matcher booleansMatcher = JsonPattern.jsonBooleansPattern(fieldName).matcher(json);
            if (booleansMatcher.find()) {
                String[] booleansArray = booleansMatcher.group().split(":", 2);
                booleansMap.put(booleansArray[0], booleansArray[1]);
            }
        }
        return booleansMap;
    }

    public Map<String, String> findNumbersInJson(String json, Field[] fields) {
        Map<String, String> numbersMap = new LinkedHashMap<>();
        for (Field field : fields) {
            if (!isFieldABoolean(field)) {
                String fieldName = field.getName();
                Matcher numberMatcher = JsonPattern.jsonNumbersPattern(fieldName).matcher(json);
                if (numberMatcher.find()) {
                    String[] numbersArray = numberMatcher.group().split(":", 2);
                    numbersMap.put(numbersArray[0], numbersArray[1]);
                }
            }
        }
        return numbersMap;
    }

    public List<String> findObjectsInJsonArray(Field[] fields, String json) {
        List<String> objects = new ArrayList<>();
        Pattern splitPattern = JsonPattern.jsonArraySplitterPattern(fields);
        Matcher objectsMatcher = splitPattern.matcher(json);
        while (objectsMatcher.find()) {
            String matchGroup = objectsMatcher.group();
            json = json.replaceFirst(splitPattern.pattern(), "");
            objectsMatcher = splitPattern.matcher(json);
            objects.add(matchGroup);
        }
        return objects;
    }

    public String removeArraysFromJson(String json, Map<String, String> arrayMap) {
        for (Map.Entry<String, String> element : arrayMap.entrySet()) {
            String elementToReplace = element.getKey().concat(":").concat(element.getValue());
            json = json.replace(elementToReplace, "");
        }
        return json;
    }

    public String removeMapsFromJson(String json, Map<String, String> maps) {
        for (Map.Entry<String, String> element : maps.entrySet()) {
            String elementToReplace = element.getKey().concat(":").concat(element.getValue());
            json = json.replace(elementToReplace, "");
        }
        return json;
    }

    public String removeObjectsFromJson(String json, Map<String, String> objectsMap) {
        for (Map.Entry<String, String> object : objectsMap.entrySet()) {
            String elementToReplace = object.getKey().concat(":").concat(object.getValue());
            json = json.replace(elementToReplace, "");
        }
        return json;
    }

    public String removeStringValuesFromJson(String json, Map<String, String> stringsMap) {
        for (Map.Entry<String, String> element : stringsMap.entrySet()) {
            String elementToReplace = element.getKey().concat(":").concat(element.getValue());
            json = json.replace(elementToReplace, "");
        }
        return json;
    }

    public String removeBooleansFromJson(String json, Map<String, String> booleansMap) {
        for (Map.Entry<String, String> element : booleansMap.entrySet()) {
            String elementToReplace = element.getKey().concat(":").concat(element.getValue());
            json = json.replace(elementToReplace, "");
        }
        return json;
    }
}
