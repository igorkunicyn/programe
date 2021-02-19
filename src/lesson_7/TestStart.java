package lesson_7;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestStart {

    public static void start(Class testClass, Object object) throws Exception {
        int countBeforeSuite = 0;
        int countAfterSuite = 0;
        Method[] methods = testClass.getDeclaredMethods();
        Annotation annotationBeforeSuite, annotationAfterSuite, annotation;
        for (Method method: methods) {
            annotationBeforeSuite = method.getAnnotation(BeforeSuite.class);
            annotationAfterSuite = method.getAnnotation(AfterSuite.class);
            if (annotationBeforeSuite != null) countBeforeSuite++;
            if (annotationAfterSuite != null) countAfterSuite++;
        }
        if (countBeforeSuite > 1){
            throw new RuntimeException("В классе больше одного метода с аннотацией @BeforeSuite");
        }
        if (countAfterSuite >1){
            throw new RuntimeException("В классе больше одного метода с аннотацией @AfterSuite");
        }

        List<Method> list = new ArrayList<>();
        for (Method method: methods){
            annotation = method.getAnnotation(BeforeSuite.class);
            if (annotation != null) list.add(method);
        }
        List<Method> listTest = new ArrayList<>();
        for (Method method: methods){
            annotation = method.getAnnotation(Test.class);
            if (annotation !=null) {
                listTest.add(method);
            }
        }
        Method [] testArray = new Method[listTest.size()];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = listTest.get(i);
        }
        Method m;
        for (int i = 0; i <testArray.length ; i++) {
            for (int j = 0; j < testArray.length-1 ; j++) {
                if (testArray[j].getAnnotation(Test.class).value()>
                        testArray[j+1].getAnnotation(Test.class).value()){
                    m = testArray[j];
                    testArray[j] = testArray[j+1];
                    testArray [j+1] = m;
                }
            }
        }
        list.addAll(Arrays.asList(testArray));
        for (Method method: methods){
            annotation = method.getAnnotation(AfterSuite.class);
            if (annotation != null) list.add(method);
        }
        for (Method method : list) {
            method.invoke(object,  null);
        }

    }

}
