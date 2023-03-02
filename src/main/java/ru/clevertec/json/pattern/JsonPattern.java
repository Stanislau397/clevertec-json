package ru.clevertec.json.pattern;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class JsonPattern {

    private JsonPattern() {

    }

    public static Pattern jsonArrayPatternWithCurrentFieldAndNextField(String currentField, String nextField) {
        return Pattern.compile("(\\\"" + currentField + "\\\"\\:\\[(.*\\]\\,)\\\"" + nextField + "\\\")");
    }

    public static Pattern jsonArrayPatternWithoutNextField(String currentField) {
        return Pattern.compile("\\\"" + currentField + "\\\"\\:\\[(.*)\\]");
    }

    public static Pattern jsonMapPatternWithNextField(String currentField, String nextField) {
        return Pattern.compile("\\\"" + currentField + "\\\"\\:\\{(.*)\\}\\,\\\"" + nextField + "\\\"");
    }

    public static Pattern jsonMapPatternWithoutNextField(String currentField) {
        return Pattern.compile("\\\"" + currentField + "\\\"\\:\\{(.*)\\}");
    }

    public static Pattern jsonObjectsPatternWithNextField(String currentField, String nextField) {
        return Pattern.compile("\\\"" + currentField + "\\\"\\:\\{(.*)\\}\\,\\\"" + nextField + "\\\"");
    }

    public static Pattern jsonObjectsPatternWithoutNextField(String currentField) {
        return Pattern.compile("\\\"" + currentField + "\\\"\\:\\{(.*)\\}");
    }

    public static Pattern jsonStringPattern(String fieldName) {
        return Pattern.compile("\\\"" + fieldName + "\\\"\\:\\\"(.*?)\\\"");
    }

    public static Pattern jsonNumbersPattern(String fieldName) {
        return Pattern.compile("\\\"" + fieldName + "\\\"\\:\\w+(?:\\.\\d+)?");
    }

    public static Pattern jsonBooleansPattern(String fieldName) {
        return Pattern.compile("\\\"" + fieldName + "\\\":(true|false)");
    }

    public static Pattern jsonArraySplitterPattern(Field[] fields) {
        String splitRegex = "";
        if (fields.length == 1) {
            splitRegex = "^(\\[|\\,|\\{\\\"" + fields[0].getName() + "\\\"\\)"
                    .concat(")(?:(?!\\,\\{\\\"" + fields[0].getName() + "\\\").)*");
            return Pattern.compile(splitRegex);
        }
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if (i == 0) {
                String beginning = "^(\\[|\\,|\\{\\\"" + fieldName + "\\\"";
                splitRegex = splitRegex.concat(beginning);
            } else if (i == fields.length - 1) {
                splitRegex = splitRegex.concat("\\\"" + fieldName + "\\\"\\:(.*?)\\,)(?:(?!\\,\\{\\\"" + fields[0].getName() + "\\\").)*");
            } else {
                splitRegex = splitRegex.concat("\\:(.*?)\\,\\\"" + fieldName + "\\\"\\:(.*?)\\,");
            }
        }
        return Pattern.compile(splitRegex);
    }
}
