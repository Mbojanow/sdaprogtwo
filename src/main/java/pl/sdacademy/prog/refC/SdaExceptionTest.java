package pl.sdacademy.prog.refC;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SdaExceptionTest {

    Class<? extends Throwable> expectToThrow() default Throwable.class;
    boolean stacktrace() default false;
}
