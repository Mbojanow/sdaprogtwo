package pl.sdacademy.prog.examples.reflections;

import pl.sdacademy.prog.strA.AccountData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class ReflectionsDemo {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Stream.of(AccountData.class.getMethods()).forEach(method -> System.out.println(method.getName()));

        System.out.println(AccountData.class.getSuperclass().getName()); // java.lang.Object

        final Constructor<?>[] declaredConstructors = AccountData.class.getDeclaredConstructors();
        final Constructor<?> noArgsConstructor = Stream.of(declaredConstructors)
                .filter(constructor -> constructor.getParameterCount() == 0)
                .findAny().get();
        final AccountData instance = (AccountData) declaredConstructors[0].newInstance();
        System.out.println(instance);
        // AccountData(country=null, currencyFullName=null, currencyShortName=null, amount=null)
    }
}
