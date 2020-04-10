package org.buka29a.obj.format;

import org.buka29a.obj.type.DataType;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface DataField {
    /**
     * Sets the name for the field in a data base
     */
    String name();
    /**
     * Sets the allias for the field in a data base
     */
    String allias() default "";
    /**
     * Sets the data type for the field in a data base
     */
    DataType type();
}
