package it4u.site;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream中间操作
 */
public class StreamAPI2 {

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 8888.11),
            new Employee("李四", 36, 8811.11),
            new Employee("王五", 15, 8822.11),
            new Employee("赵六", 18, 8800.11)
    );

    /**
     * 内部迭代，迭代操作由Stream API完成
     */
   @Test
    public void test1() {

       // 中间操作不会执行任何操作，直到终止操作才会一次性执行全部内容，叫惰性求值
       Stream<Employee> employeeStream = employeeList.stream().filter(e -> e.getAge() > 35);
       employeeStream.forEach(System.out::println); // 终止操作
   }

   @Test
    public void test2() {
       employeeList.stream().filter(e -> e.getSalary() > 5000).limit(2) // 取前两个
               .forEach(System.out::println);
   }

   @Test
    public void test3() {
       employeeList.stream().filter(e -> e.getSalary() > 5000).skip(2) // 跳过前两个
               .forEach(System.out::println);
   }

   @Test
    public void test4() {
       List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
       list.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
       employeeList.stream().map(Employee::getName).forEach(System.out::println);
       employeeList.stream().map(Employee::getAge).distinct().forEach(System.out::println);
   }

   @Test
    public void test5() {
       List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
       Stream<Stream<Character>> streamStream = list.stream().map(StreamAPI2::filterCharacter);
       streamStream.forEach(s -> {
           s.forEach(System.out::println);
       });
       System.out.println("-----------------------------------");
       // flatMap
       Stream<Character> characterStream = list.stream().flatMap(StreamAPI2::filterCharacter);
       characterStream.forEach(System.out::println);
   }

   public static Stream<Character> filterCharacter(String str) {
       List<Character> list = new ArrayList<>();
       for (Character character : str.toCharArray()) {
           list.add(character);
       }
       return list.stream();
   }

   @Test
   public void test6() {
       List<String> list = Arrays.asList("bbb", "aaa", "ddd", "ccc");
       list.stream().sorted().forEach(System.out::println); // 自然排序
       System.out.println("------------------------------");
       employeeList.stream().sorted((e1, e2) -> {
           if(e1.getAge() == e2.getAge()) {
               return e1.getName().compareTo(e2.getName());
           }else {
               return Integer.compare(e1.getAge(), e2.getAge());
           }
       }).forEach(System.out::println);
   }

}
