package org.buka29a.auto.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class ReflectionUtils {

    public static List<Field> getAllFields(Object obj) {
        return FieldUtils.getAllFieldsList(obj.getClass());
    }

    public static List<String> getAllFieldsNames(Object obj) {
        List<String> names = new ArrayList<>();
        for (Field field : getAllFields(obj)) {
            names.add(field.getName());
        }
        return names;
    }

    public static Object getField(Object obj, String fieldName) {
        Object value = null;
        try {
            value = FieldUtils.readField(obj, fieldName, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void setField(Object obj, String fieldName, Object value) {
        try {
            FieldUtils.writeField(obj, fieldName, value, true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Object setType(Object value, Class type) {
        if (value.getClass().isAssignableFrom(type)) {
            return value;
        }
        if (type.equals(String.class)) {
            return String.valueOf(value);
        }
        if (type.equals(Boolean.class)) {
            return Boolean.valueOf((String) value);
        }
        if (type.equals(Integer.class)) {
            return Integer.parseInt((String) value);
        }
        if (type.equals(Long.class)) {
            return Long.parseLong((String) value);
        }
        return value;
    }
}
