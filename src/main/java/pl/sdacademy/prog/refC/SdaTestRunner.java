package pl.sdacademy.prog.refC;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import lombok.extern.slf4j.Slf4j;
import pl.sdacademy.prog.refA.ReflectionsUtil;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("UnstableApiUsage")
@Slf4j
public class SdaTestRunner {

    private ReflectionsUtil reflectionsUtil;

    public SdaTestRunner(final ReflectionsUtil reflectionsUtil) {
        this.reflectionsUtil = reflectionsUtil;
    }

    public int runAllTests() throws IOException, InvocationTargetException, IllegalAccessException {
        String packageName = this.getClass().getPackage().getName();
        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final ClassPath classPath = ClassPath.from(classLoader);
        final ImmutableSet<ClassPath.ClassInfo> classes = classPath.getTopLevelClasses(packageName);
        final List<Class> sdaTestClasses = classes.stream()
                .filter(classInfo -> classInfo.getSimpleName().endsWith("SdaTest"))
                .map(ClassPath.ClassInfo::load)
                .filter(clazz -> reflectionsUtil.getNoArgsConstructor(clazz).isPresent())
                .collect(Collectors.toList());

        for (final Class clazz : sdaTestClasses) {
            final List<Method> testMethods = Stream.of(clazz.getDeclaredMethods())
                    .filter(method -> method.getAnnotation(SdaExceptionTest.class) != null)
                    .filter(method -> Modifier.isPublic(method.getModifiers()))
                    .filter(method -> method.getParameterCount() == 0)
                    .collect(Collectors.toList());

            if (!testMethods.isEmpty()) {
                final Object instance = reflectionsUtil.getNoArgsConstructor(clazz).map(this::createNewInstance).orElseThrow();
                for (final Method method : testMethods) {
                    final SdaExceptionTest annotation = method.getAnnotation(SdaExceptionTest.class);
                    final Class<? extends Throwable> throwable = annotation.expectToThrow();
                    try {
                        method.invoke(instance);
                    } catch (final InvocationTargetException exp) {
                        if (!exp.getTargetException().getClass().equals(throwable)) {
                            throw new RuntimeException("Test failed: " + method.getName() + ". Exception of different type thrown");
                        }
                        if (annotation.stacktrace()) {
                            exp.getTargetException().printStackTrace();
                        }
                        continue;
                    }
                    throw new RuntimeException("Test failed: " + method.getName() + ". Test did not throw");
                }
            }

        }

        return 0;
    }

    private Object createNewInstance(final Constructor constructor) {
        try {
            return constructor.newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

