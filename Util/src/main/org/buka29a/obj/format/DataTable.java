package org.buka29a.obj.format;

import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface DataTable {
    /**
     * Sets the name for the table in a data base
     */
    String name();
    /**
     * Sets the allias for the table in a data base
     */
    String allias() default "";
}
