package pl.sdacademy.prog.refA;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

public class ReflectionsUtil {

    public static boolean isCorrectlyEncapsulated(final Class<?> clazz) {
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
}
