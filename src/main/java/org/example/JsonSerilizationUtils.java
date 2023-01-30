package org.example;

import java.lang.reflect.Field;

public class JsonSerilizationUtils {
    public static String serialize(Object o) throws IllegalAccessException, NoSuchFieldException {
        String result = "{\n\t";
        Class<?> clazz = o.getClass();
        for (var field :
                clazz.getFields()) {
            Field field1 = clazz.getField(field.getName());
            String value = null;
            if (field1.get(o) != null) {
                value = (String) field1.get(o);
            }
            String fieldName;
            boolean ignoreNull = false;
            for (var annotation :
                    field.getAnnotations()) {
                if (annotation.annotationType().getName().equals(JsonElement.class.getName())) {
                    fieldName = ((JsonElement) annotation).name();
                }
                if (annotation.annotationType().getName().equals(IgnoreNull.class.getName())) {
                    ignoreNull = true;
                }
            }
            if (!(ignoreNull && value == null)) {
                result += "\"" + field.getName() + "\": " + "\"" + value + "\",\n\t";
                ignoreNull = false;
            }
        }
        result = result.substring(0, result.length() - 1);
        result += "}";
        return result;
    }
}
