package it4u.site;

import com.sun.istack.internal.NotNull;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 重复注解与类型注解
 */
public class TestAnnotation {

    private @NotNull Object obj = null;

    @Test
    public void test1() throws Exception {
        Class<TestAnnotation> clazz = TestAnnotation.class;
        Method method = clazz.getMethod("show");
        MyAnnotation[] annotationsByType = method.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println(myAnnotation.value());
        }
    }

    @MyAnnotation("HELLO")
    @MyAnnotation("WORLD")
    public void show(@MyAnnotation("abc") String str) {

    }
}
