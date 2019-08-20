package pl.sdacademy.prog.refC;

public class OurFirstSdaTest {

    @SdaExceptionTest(expectToThrow = RuntimeException.class, stacktrace = true)
    public void should_throw_runtime_exception() {
        throw new RuntimeException();
    }

    @SdaExceptionTest(expectToThrow = Exception.class, stacktrace = true)
    public void should_throw_exception() throws Exception {
        throw new RuntimeException();
    }
}
