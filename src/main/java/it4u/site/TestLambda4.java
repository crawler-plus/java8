package it4u.site;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 内置函数式接口
 */
public class TestLambda4 {

    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("洗澡消费:" + m));
    }

    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        numList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        String s = strHandler("  abc ", (str) -> str.trim().toUpperCase());
        System.out.println(s);
    }

    @Test
    public void test4() {
        List<String> list = Arrays.asList("Hello", "world", "welcome");
        List<String> strings = filterStr(list, (s) -> s.length() == 5);
        strings.forEach(System.out::println);
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = sup.get();
            list.add(integer);
        }
        return list;
    }

    // 处理字符串
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    // 将满足条件的字符串放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre) {
        List<String> strList = new ArrayList<>();
        for (String str : list) {
            if(pre.test(str)) {
                strList.add(str);
            }
        }
        return strList;
    }

}
