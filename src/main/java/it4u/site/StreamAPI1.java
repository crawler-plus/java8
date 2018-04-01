package it4u.site;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI1 {

    /**
     * 创建stream
     */
    @Test
    public void test1() {
        // 1.可以通过Collection系列集合提供的stream()方法或parallelStream()方法
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2.通过Arrays中的静态方法stream()获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emps);

        // 3.通过Stream类中的静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");

        // 4.创建无限流(迭代)
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        // 5.创建无限流(生成)
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(10).forEach(System.out::println);
    }
}
