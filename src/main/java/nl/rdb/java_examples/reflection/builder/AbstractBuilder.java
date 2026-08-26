package nl.rdb.java_examples.reflection.builder;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractBuilder<T, BC> {

    public abstract BC base();

    @SuppressWarnings("unchecked")
    public Class<BC> reflectClassType() {
        return ((Class<BC>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1]);
    }

    protected BC blank() {
        try {
            return reflectClassType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
