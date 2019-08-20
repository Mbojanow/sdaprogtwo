package pl.sdacademy.prog.refC;

import pl.sdacademy.prog.refA.ReflectionsUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class SdaTestRunnerMain {

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        final ReflectionsUtil reflectionsUtil = new ReflectionsUtil();
        new SdaTestRunner(reflectionsUtil).runAllTests();
    }

}
