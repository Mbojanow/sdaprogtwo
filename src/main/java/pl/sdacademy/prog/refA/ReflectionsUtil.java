package pl.sdacademy.prog.refA;

import java.lang.reflect.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionsUtil {

    public boolean isCorrectlyEncapsulated(final Class<?> clazz) {
        final Field[] declaredFields = clazz.getDeclaredFields();
        boolean isEncapsulatedCorrectly = true;
        for (final Field field: declaredFields) {
            final int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                isEncapsulatedCorrectly = false;
                System.out.println("Found incorrect field with name " + field.getName() + " and type " + field.getType().getName());
            }
        }
        return isEncapsulatedCorrectly;
    }

    public Object createInstanceWithNoArgs(final Class clazz) {
        final Optional<Constructor<?>> noArgsConstructor = getNoArgsConstructor(clazz);
        return noArgsConstructor.map(constructor -> createInstanceWithNoArgsOrNull(constructor, clazz))
                .orElse(null);
    }

    public Optional<Constructor<?>> getNoArgsConstructor(final Class<?> clazz) {
        return Stream.of(clazz.getDeclaredConstructors())
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findFirst();
    }

    private Object createInstanceWithNoArgs(final Constructor<?> constructor, final Class<?> clazz) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        final Object instance = constructor.newInstance();
        final Field[] declaredFields = instance.getClass().getDeclaredFields();
        final List<String> fieldsNamesWithoutSetters = getFieldsNamesWithoutSetters(declaredFields, clazz);

        for (final String fieldName: fieldsNamesWithoutSetters) {
            final Optional<Constructor<?>> fieldConstructor = Stream.of(declaredFields)
                    .filter(field -> field.getName().equals(fieldName))
                    .map(Field::getType)
                    .findFirst().map(this::getNoArgsConstructor).orElseThrow();
            if (fieldConstructor.isPresent()) {
                final Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(instance, fieldConstructor.get().newInstance());
            }
        }
        return instance;
    }


    public Object createInstanceWithNoArgsOrNull(final Constructor<?> constructor, final Class<?> clazz) {
        try {
            return createInstanceWithNoArgs(constructor, clazz);
        } catch (final Exception exp) {
            return null;
        }
    }

    private List<String> getFieldsNamesWithoutSetters(final Field[] fields, final Class clazz) {
        final List<String> methodNames = getPublicMethodNames(clazz);
        return Stream.of(fields)
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .map(Field::getName)
                .filter(name -> !methodNames.contains(createSetterNameForField(name)))
                .collect(Collectors.toList());
    }

    private static List<String> getPublicMethodNames(final Class clazz) {
        final Method[] declaredMethods = clazz.getDeclaredMethods();
        return Stream.of(declaredMethods)
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .map(Method::getName)
                .collect(Collectors.toList());
    }

    private String createSetterNameForField(final String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}
