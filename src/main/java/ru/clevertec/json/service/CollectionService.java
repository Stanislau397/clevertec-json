package ru.clevertec.json.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.LinkedBlockingQueue;

import static ru.clevertec.json.validator.FieldValidator.isFieldTypeAList;
import static ru.clevertec.json.validator.FieldValidator.isFieldTypeAQueue;
import static ru.clevertec.json.validator.FieldValidator.isFieldTypeASet;

public class CollectionService {

    public Collection<Object> createCollectionBasedOnSimpleName(Field field) {
        Collection<Object> collection = Collections.emptyList();
        if (isFieldTypeAList(field)) {
            collection = new ArrayList<>();
        }
        if (isFieldTypeASet(field)) {
            collection = new HashSet<>();
        }
        if (isFieldTypeAQueue(field)) {
            collection = new LinkedBlockingQueue<>();
        }
        return collection;
    }

    public Collection<Object> fillCollectionWithEnums(Collection<Object> collection, Class<?> enumClazz, String[] enumsArray) {
        for (String enumValue : enumsArray) {
            collection.add(Enum.valueOf((Class<Enum>) enumClazz, enumValue));
        }
        return collection;
    }

    public void fillCollectionBasedOnClassSimpleName(Collection<Object> collection, String[] values, String classSimpleName) {
        for (String value : values) {
            switch (classSimpleName) {
                case "Long":
                    collection.add(Long.parseLong(value));
                    break;
                case "Integer":
                    collection.add(Integer.parseInt(value));
                    break;
                case "Double":
                    collection.add(Double.parseDouble(value));
                    break;
                case "Float":
                    collection.add(Float.parseFloat(value));
                    break;
                case "Byte":
                    collection.add(Byte.parseByte(value));
                    break;
                case "Short":
                    collection.add(Short.parseShort(value));
                    break;
                case "String":
                    collection.add(value);
                    break;
                default:
                    collection.add(Boolean.valueOf(value));
                    break;
            }
        }
    }
}
