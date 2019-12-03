package org.buka29a.auto.model;

import org.buka29a.auto.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

public class DataContainer<T> {

    public T initialize(Map<String, Object> data) {
        defineContainerFields(data.keySet());
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            setField(normalizeKey(entry.getKey()), entry.getValue());
        }
        return (T) this;
    }

    public List<String> initializedFields() {
        return Container.initializedFields;
    }

    public List<String> notInitializedFields() {
        return Container.notInitializedFields;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        List<Field> fields = ReflectionUtils.getAllFields(this);
        for (Field field : fields) {
            String key = field.getName();
            Object value = ReflectionUtils.getField(this, field.getName());
            map.put(key, value);
        }
        return map;
    }

    protected String normalizeKey(String name) {
        return name.replaceAll("_", "");
    }

    protected void setField(String key, Object value) {
        List<Field> fields = ReflectionUtils.getAllFields(this);
        for (Field field : fields) {
            if (field.getName().equalsIgnoreCase(key)) {
                Class type = field.getType();
                ReflectionUtils.setField(this, field.getName(), ReflectionUtils.setType(value, type));
            }
        }
    }

    protected void defineContainerFields(Set<String> map) {
        List<String> notInitialized = new ArrayList<>();
        List<String> initialized = new ArrayList<>();
        List<String> fields = ReflectionUtils.getAllFieldsNames(this);

        for (String name : fields) {
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
        static List<String> initializedFields;
        static List<String> notInitializedFields;
    }
}
