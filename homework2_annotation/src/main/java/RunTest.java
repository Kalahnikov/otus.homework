import annotation.AfterSuite;
import annotation.BeforeSuite;
import annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTest {
    private static int passedTest;
    private static int failedTest;

    public static void startTest(Class<Tests> testsClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Constructor<Tests> constructor = testsClass.getConstructor();
        Object inst = constructor.newInstance();

        startBeforeSuite(testsClass, inst);

        for (Method method : testsClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                if (executeMethod(method, inst)) {
                    passedTest++;
                } else {
                    failedTest++;
                }
            }
        }

        startAfterSuite(testsClass, inst);

        System.out.println("Результат : прошли " + passedTest + ";" +
                " не прошли " + failedTest + ";" +
                " всего " + (passedTest + failedTest));

    }

    private static void startAfterSuite(Class<Tests> testsClass, Object instance) {
        for (Method method : testsClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (executeMethod(method, instance)) {
                    passedTest++;
                } else {
                    failedTest++;
                }
            }
        }
    }

    private static void startBeforeSuite(Class<Tests> testsClass, Object instance) {
        for (Method method : testsClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (executeMethod(method, instance)) {
                    passedTest++;
                } else {
                    failedTest++;
                }
            }
        }
    }

    private static boolean executeMethod(Method method, Object instance) {
        boolean executeTest = true;
        try {
            method.invoke(instance);
        } catch (Exception e) {
            executeTest = false;
        }
        return executeTest;
    }

}
