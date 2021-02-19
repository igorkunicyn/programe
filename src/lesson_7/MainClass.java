package lesson_7;

public class MainClass {
    public static void main(String[] args) throws Exception {
        Object object = new TestClass();
        Class testClass = TestClass.class;
        TestStart.start(testClass, object);
    }

}
