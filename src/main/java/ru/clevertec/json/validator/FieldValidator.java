package ru.clevertec.json.validator;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FieldValidator {

    private FieldValidator() {

    }

    public static Boolean isFieldAString(Field field) {
        return String.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldAChar(Field field) {
        return char.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldACharacter(Field field) {
        return Character.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldComponentACharacter(Field field) {
        return Character.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldACharacterArray(Field field) {
        return char[].class.isAssignableFrom(field.getType())
                || Character[].class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldAnObjectOfOtherCustomClass(Field field) {
        return !field.getType().getName().contains("java.lang")
                && !field.getType().isPrimitive()
                && !Collection.class.isAssignableFrom(field.getType())
                && !field.getType().isArray()
                && !Map.class.isAssignableFrom(field.getType())
                && !field.getType().isEnum();
    }

    public static Boolean isFieldComponentAnObjectOfOtherCustomClass(Field field) {
        return !field.getType().getName().contains("java.lang")
                && !field.getType().getComponentType().isPrimitive()
                && !Collection.class.isAssignableFrom(field.getType().getComponentType())
                && !field.getType().getComponentType().isArray()
                && !Map.class.isAssignableFrom(field.getType())
                && !field.getType().getComponentType().isEnum();
    }

    public static Boolean isFieldACollection(Field field) {
        return Collection.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldAnArray(Field field) {
        return field.getType().isArray();
    }

    public static Boolean isFieldAMap(Field field) {
        return Map.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldAnEnum(Field field) {
        return Enum.class.isAssignableFrom(field.getType());
    }

    public static Boolean isArrayComponentAPrimitive(Field field) {
        return field.getType().getComponentType().isPrimitive();
    }

    public static Boolean isFieldComponentAChar(Field field) {
        return char.class.isAssignableFrom(field.getType().getComponentType())
                || Character.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentTypeAnEnum(Field field) {
        return Enum.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentAnInt(Field field) {
        return int.class.isAssignableFrom(field.getType().getComponentType())
                || Integer.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentALong(Field field) {
        return long.class.isAssignableFrom(field.getType().getComponentType())
                || Long.class.isAssignableFrom(field.getType().getComponentType());
    }


    public static Boolean isFieldComponentADouble(Field field) {
        return double.class.isAssignableFrom(field.getType().getComponentType())
                || Double.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentAFloat(Field field) {
        return float.class.isAssignableFrom(field.getType().getComponentType())
                || Float.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentAShort(Field field) {
        return short.class.isAssignableFrom(field.getType().getComponentType())
                || Short.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentAByte(Field field) {
        return byte.class.isAssignableFrom(field.getType().getComponentType())
                || Byte.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldABoolean(Field field) {
        return Boolean.class.isAssignableFrom(field.getType())
                || boolean.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldComponentABoolean(Field field) {
        return boolean.class.isAssignableFrom(field.getType().getComponentType())
                || Boolean.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldComponentAString(Field field) {
        return String.class.isAssignableFrom(field.getType().getComponentType());
    }

    public static Boolean isFieldANumber(Field field) {
        return Number.class.isAssignableFrom(field.getType())
                || double.class.isAssignableFrom(field.getType())
                || short.class.isAssignableFrom(field.getType())
                || byte.class.isAssignableFrom(field.getType())
                || int.class.isAssignableFrom(field.getType())
                || float.class.isAssignableFrom(field.getType())
                || double.class.isAssignableFrom(field.getType())
                || long.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldTypeAList(Field field) {
        return List.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldTypeASet(Field field) {
        return Set.class.isAssignableFrom(field.getType());
    }

    public static Boolean isFieldTypeAQueue(Field field) {
        return Queue.class.isAssignableFrom(field.getType());
    }
}
