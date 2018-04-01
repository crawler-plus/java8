package it4u.site;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream练习
 */
public class StreamAPI4 {

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 8888.11, Employee.Status.FREE),
            new Employee("李四", 36, 8811.11, Employee.Status.BUSY),
            new Employee("王五", 15, 8822.11, Employee.Status.VOCATION),
            new Employee("赵六", 18, 8800.11, Employee.Status.BUSY)
    );

   @Test
    public void test1() {
       Integer[] nums = new Integer[]{1,2,3,4,5};
       Stream<Integer> stream = Arrays.stream(nums);
       stream.map(x -> x * x).forEach(System.out::println);
   }

   @Test
    public void test2() {
       Optional<Integer> reduce = employeeList.stream().map(e -> 1).reduce(Integer::sum);
       System.out.println(reduce.get());
   }

    /**
     * java8并行流
     */
   @Test
    public void test3() {
       long reduce = LongStream.rangeClosed(0, 1000000000L)
               .parallel() // 转化为并行流
               .reduce(0, Long::sum);
       System.out.println(reduce);
   }


}
