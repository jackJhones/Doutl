package org.buka29a.obj.utils;

import org.apache.commons.lang3.reflect.FieldUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public final class ReflectionUtils {

    public static List<Field> getAllFields(Object obj) {
        return FieldUtils.getAllFieldsList(obj.getClass());
    }

    public static List<String> getAllFieldsNames(Object obj) {
        return getAllFields(obj).stream().map(Field::getName).collect(Collectors.toList());
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

    public static Object setType(Object value, Class<?> type) {
        if (value.getClass().isAssignableFrom(type)) {
            return value;
        } else if (type.equals(String.class)) {
            return String.valueOf(value);
        } else if (type.equals(Boolean.class)) {
            return Boolean.valueOf((String) value);
        } else if (type.equals(Integer.class)) {
            return Integer.parseInt((String) value);
        } else if (type.equals(Long.class)) {
            return Long.parseLong((String) value);
        } else {
            throw new ClassCastException(value.getClass().getCanonicalName() + " cannot be cast to " + type.getCanonicalName());
        }
    }

    public static Object initField(Object obj, String fieldName) {
        Object instance = getField(obj, fieldName);

        if (instance == null) {
            Field field = FieldUtils.getField(obj.getClass(), fieldName, true);
            try {
                instance = Class.forName(field.getType().getName()).newInstance();
                ReflectionUtils.setField(obj, fieldName, instance);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static <A extends Annotation> A getAnnotation(Object object, Class<A> annotation) {
        A clazz = null;
        if (object instanceof Field) {
            clazz = ((Field) object).getAnnotation(annotation);
        } else {
            clazz = object.getClass().getAnnotation(annotation);
        }
        return clazz;
    }
}
