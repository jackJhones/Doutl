package org.buka29a.obj.model;

import org.buka29a.obj.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import static org.buka29a.obj.utils.DataFieldUtils.normalizeName;
import static org.buka29a.obj.utils.DataFieldUtils.normalizeNames;

public class DataContainer<T> {

    public T initialize(Map<String, Object> data) {
        defineContainerFields(normalizeNames(data.keySet()));
        data.entrySet().stream().forEach(e -> setField(normalizeName(e.getKey()), e.getValue()));
        return (T) this;
    }

    public List<String> initializedFields() {
        return Container.initializedFields;
    }

    public List<String> notInitializedFields() {
        return Container.notInitializedFields;
    }

    public Map<String, Object> toMap(boolean ignoreNulls) {
        List<String> fieldNames = ignoreNulls ? Container.initializedFields : Container.fields;

        Map<String, Object> map = new HashMap<>();
        fieldNames.stream().forEach(e -> map.put(e, ReflectionUtils.getField(this, e)));
        return map;
    }

    protected void setField(String key, Object value) {
        Object target = this;
        List<Field> fields = ReflectionUtils.getAllFields(this);
        if (key.matches("\\w+[.]\\w+")) {
            String[] parts = key.split("\\.");

            if (fields.stream().map(Field::getName).collect(Collectors.toList()).contains(parts[0])) {
                target = ReflectionUtils.initField(target, parts[0]);
                fields = ReflectionUtils.getAllFields(target);
                key = parts[1];
            }
        }
        Object finalTarget = target;
        String finalKey = key;
        fields.stream()
                .filter(e -> e.getName().equalsIgnoreCase(finalKey))
                .forEach(e -> ReflectionUtils.setField(finalTarget, e.getName(), convertType(value, e.getType())));
    }

    protected Object convertType(Object value, Class type) {
        return ReflectionUtils.setType(value, type);
    }

    protected void defineContainerFields(Set<String> map) {
        List<String> notInitialized = new ArrayList<>();
        List<String> initialized = new ArrayList<>();
        Container.fields = ReflectionUtils.getAllFieldsNames(this);

        for (String name : Container.fields) {
            if (map.contains(name)) {
                initialized.add(name);
            } else {
                notInitialized.add(name);
            }
        }
        Container.notInitializedFields = notInitialized;
        Container.initializedFields = initialized;
    }

    static class Container {
        static List<String> fields;
        static List<String> initializedFields;
        static List<String> notInitializedFields;
    }
}
