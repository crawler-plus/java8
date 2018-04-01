package it4u.site;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestLambda {

    @Test
    public void  test1() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    @Test
    public void test2() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("张三", 18, 8888.11),
                new Employee("李四", 36, 8811.11),
                new Employee("王五", 15, 8822.11)
        );
        employeeList.stream()
                .filter((e) -> e.getSalary() >= 8888)
                .limit(2)
                .forEach(System.out::println);

        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

}
