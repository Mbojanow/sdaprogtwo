package pl.sdacademy.prog.refA;

public class ReflectionsMain {
    public static void main(String[] args) {
        ReflectionsUtil.isCorrectlyEncapsulated(CorrectClass.class);
        ReflectionsUtil.isCorrectlyEncapsulated(IncorrectClass.class);
    }
}
