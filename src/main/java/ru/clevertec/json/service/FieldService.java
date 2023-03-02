package ru.clevertec.json.service;

import java.lang.reflect.Field;

public class FieldService {

    public void setPrimitiveFields(Field field, Object object, String primitive) throws IllegalAccessException {
        String fieldTypeSimpleName = field.getType().getSimpleName().toLowerCase();
        switch (fieldTypeSimpleName) {
            case "long":
                field.set(object, Long.parseLong(primitive));
                break;
            case "int":
            case "integer":
                field.set(object, Integer.parseInt(primitive));
                break;
            case "double":
                field.set(object, Double.parseDouble(primitive));
                break;
            case "float":
                field.set(object, Float.parseFloat(primitive));
                break;
            case "byte":
                field.set(object, Byte.parseByte(primitive));
                break;
            case "short":
                field.set(object, Short.parseShort(primitive));
                break;
        }
    }
}
