package org.buka29a.obj.format;

import org.buka29a.obj.model.DataImage;
import org.buka29a.obj.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class DataContainerProcessor {

    public List<DataImage> evaluate(Object object) {
        List<DataImage> dataImages = new ArrayList<>();
        if (object == null) {
            return dataImages;
        }
        DataTable dataTable = ReflectionUtils.getAnnotation(object, DataTable.class);
        List<Field> fields = ReflectionUtils.getAllFields(object);
        for (Field field : fields) {
            DataImage dataImage = new DataImage();
            DataField dataField = ReflectionUtils.getAnnotation(field, DataField.class);

            if (dataField != null) {
                dataImage.setTable(dataTable.name());
                dataImage.setName(dataField.name());
                dataImage.setType(dataField.type());
                dataImage.setValue(getFieldType(object, field));
                dataImages.add(dataImage);
            } else if (field.getType().isArray()) {
                Object array = getFieldType(object, field);
                Stream.of((Object[]) array).forEach(e -> addAllTypes(dataImages, e));
            } else if (field.getType().isAssignableFrom(List.class)
                    || field.getType().isAssignableFrom(Set.class)) {
                Object collection = getFieldType(object, field);
                Stream.of(((Collection) collection).toArray()).forEach(e -> addAllTypes(dataImages, e));
            } else if (field.getType().isAnnotationPresent(DataTable.class)) {
                Object subType = getFieldType(object, field);
                addAllTypes(dataImages, subType);
            }
        }
        return dataImages;
    }

    private Object getFieldType(Object object, Field field) {
        return ReflectionUtils.getField(object, field.getName());
    }

    private boolean addAllTypes(List<DataImage> dataImages, Object e) {
        return dataImages.addAll(evaluate(e));
    }
}
