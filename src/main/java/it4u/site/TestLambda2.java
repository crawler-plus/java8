package it4u.site;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda2 {

    /**
     * 无参数，无返回值
     */
    @Test
    public void test1() {
       Runnable r = () -> System.out.println("hello, world");
       new Thread(r).start();
    }

    /**
     * 有一个参数，无返回值
     */
    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("我的测试");
    }

    /**
     * 有一个参数，无返回值，小括号可以不写
     */
    @Test
    public void test3() {
        Consumer<String> con = x -> System.out.println(x);
        con.accept("我的测试");
    }

    /**
     * 有两个以上的参数，并且lambda体中有多条语句，有返回值
     */
    @Test
    public void test4() {
        Comparator<Integer> com = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 有两个以上的参数，并且lambda体中只有1条语句，有返回值，return和大括号都可以不写
     */
    @Test
    public void test5() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test6() {
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }

}
