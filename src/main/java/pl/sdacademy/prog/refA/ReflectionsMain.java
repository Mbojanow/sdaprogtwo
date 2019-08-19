package pl.sdacademy.prog.refA;

import java.lang.reflect.InvocationTargetException;

public class ReflectionsMain {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
//        ReflectionsUtil.isCorrectlyEncapsulated(CorrectClass.class);
//        ReflectionsUtil.isCorrectlyEncapsulated(IncorrectClass.class);

        final ReflectionsUtil reflectionsUtil = new ReflectionsUtil();
        final CorrectClass instanceWithNoArgs = (CorrectClass)reflectionsUtil.createInstanceWithNoArgs(CorrectClass.class);
        System.out.println(instanceWithNoArgs);
    }
}
