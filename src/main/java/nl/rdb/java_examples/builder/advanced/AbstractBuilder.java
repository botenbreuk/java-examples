package nl.rdb.java_examples.builder.advanced;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractBuilder<T, BC extends AbstractBuildCommand<T>> {

    private static final List<Method> ABSTRACT_BUILD_COMMAND_METHODS = Arrays.asList(AbstractBuildCommand.class.getDeclaredMethods());
    private T internalObject;

    public abstract BC base();

    public BC blank() {
        initObject();

        return null;
    }

    public T build() {
        return internalObject;
    }

    private void initObject() {
        try {
            this.internalObject = ((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0])
                    .getDeclaredConstructor()
                    .newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
