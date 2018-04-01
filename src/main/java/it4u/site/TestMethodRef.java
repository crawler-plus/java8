package it4u.site;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用
 * lambda体中调用方法的参数列表与返回值类型要与函数式接口中抽象方法的函数列表和返回值类型保持一致
 */
public class TestMethodRef {

    @Test
    public void test1() {
        PrintStream ps = System.out;
        Consumer<String> con = (x) -> ps.println(x);
        con.accept("abcdef");
    }

    @Test
    public void test2() {
        Employee employee = new Employee();
        Supplier<String> sup = () -> employee.getName();
        String str = sup.get();
        System.out.println(str);
        Supplier<Integer> sup2 = employee::getAge;
        Integer integer = sup2.get();
        System.out.println(integer);
    }

    @Test
    public void test3() {
        Comparator<Integer> com = Integer::compare;
    }

    /**
     * 若lambda参数列表中第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以用Classname::method
     */
    @Test
    public void test4() {
        BiPredicate<String, String> bp = String::equals;
    }

    /**
     * 构造器引用
     */
    @Test
    public void test5() {
        Supplier<Employee> sup = () -> new Employee();
        Employee employee = sup.get();
        // 构造器引用
        Supplier<Employee> supplier = Employee::new; // 调用无参构造器
        Employee employee1 = supplier.get();
        System.out.println(employee1);
    }

    /**
     * 注意：需要调用的构造器的参数列表要与函数式接口中的抽象方法的参数列表保持一致
     */
    @Test
    public void test6() {
        Function<Integer, Employee> fun = (x) -> new Employee(x);
        // 构造器引用
        Function<Integer, Employee> function = Employee::new; // 调用一个参数的构造器
        Employee apply = function.apply(101);
        System.out.println(apply);
    }

    /**
     * 数组引用
     */
    @Test
    public void test7() {
        Function<Integer, String[]> func = (x) -> new String[x];
        String[] apply = func.apply(10);
        System.out.println(apply.length);
        // 数组引用
        Function<Integer, String[]> function = String[]::new;
        String[] apply1 = function.apply(20);
        System.out.println(apply1.length);
    }
}
