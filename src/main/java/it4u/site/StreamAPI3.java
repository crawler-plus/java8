package it4u.site;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream终止操作，规约，收集
 */
public class StreamAPI3 {

    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18, 8888.11, Employee.Status.FREE),
            new Employee("李四", 36, 8811.11, Employee.Status.BUSY),
            new Employee("王五", 15, 8822.11, Employee.Status.VOCATION),
            new Employee("赵六", 18, 8800.11, Employee.Status.BUSY)
    );

    @Test
    public void test1() {
        boolean b = employeeList.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b); // 是否匹配所有的元素
        boolean b1 = employeeList.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1); // 是否至少匹配一个元素
        boolean b2 = employeeList.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.VOCATION));
        System.out.println(b2); // 是否不匹配所有元素
        Optional<Employee> first = employeeList.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(first.get());
        Optional<Employee> any = employeeList.stream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(any.get());
    }

    @Test
    public void test2() {
        long count = employeeList.stream().count();
        System.out.println(count);
        Optional<Employee> max = employeeList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());
        Optional<Double> min = employeeList.stream().map(Employee::getSalary).min(Double::compare);
        System.out.println(min.get());
    }

    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("-------------------------");
        Optional<Double> reduce1 = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());
    }

    /**
     * 收集
     */
    @Test
    public void test4() {
        List<String> collect = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        Set<Integer> collect1 = employeeList.stream().map(Employee::getAge).collect(Collectors.toSet());
        System.out.println(collect1);
        HashSet<Integer> collect2 = employeeList.stream().map(Employee::getAge).collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);
    }

    @Test
    public void test5() {
        Long collect = employeeList.stream().collect(Collectors.counting());
        System.out.println(collect);
        // 平均值
        Double collect1 = employeeList.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect1);
        Double collect2 = employeeList.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect2);
        Optional<Employee> collect3 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println(collect3); // 工资最大值的人
    }

    /**
     * 分组
     */
    @Test
    public void test6() {
        Map<Employee.Status, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }

    @Test
    public void test7() {
        Map<Employee.Status, Map<String, List<Employee>>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect);
    }

    /**
     * 分区
     */
    @Test
    public void test8() {
        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8822));
        System.out.println(collect);
    }

    @Test
    public void test9() {
        DoubleSummaryStatistics collect = employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect.getAverage());
        System.out.println(collect.getCount());
        System.out.println(collect.getMax());
        System.out.println(collect.getMin());
        System.out.println(collect.getSum());
    }

    @Test
    public void test10() {
        String collect = employeeList.stream().map(Employee::getName).collect(Collectors.joining(",", "---", "---"));
        System.out.println(collect);
    }
}
