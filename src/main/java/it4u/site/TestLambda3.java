package it4u.site;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda3 {

    /**
     * 无参数，无返回值
     */
    @Test
    public void test1() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("张三", 18, 8888.11),
                new Employee("李四", 18, 8811.11),
                new Employee("王五", 15, 8822.11)
        );
        Collections.sort(employeeList, (e1, e2) -> {
            if(e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });
        employeeList.forEach(System.out::println);
    }

    @Test
    public void test2() {
        String s1 = strHandler("  abc  ", (s) -> s.trim());
        System.out.println(s1);
        String abc = strHandler("abc", (s) -> s.toUpperCase());
        System.out.println(abc);
    }

    @Test
    public void test3() {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }

    /**
     * 字符串处理
     * @param str
     * @param mf
     * @return
     */
    public String strHandler(String str, MyFunction mf) {
        return mf.getValue(str);
    }

    // 对于两个long型处理
    public void op(Long l1, long l2, MyFunction2<Long, Long> mf) {
        System.out.println(mf.getValue(l1, l2));
    }

}
