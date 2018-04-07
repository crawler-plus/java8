package it4u.site;

import org.junit.Test;

import java.util.Optional;

public class TestOptional {

    @Test
    public void test1() {
        Optional<Employee> optional = Optional.of(new Employee());
        System.out.println(optional.get());
    }

    @Test
    public void test2() {
        // 构建一个空的optional
        Optional<Employee> optional = Optional.empty();
        System.out.println(optional.get());
    }

    @Test
    public void test3() {
        Optional<Employee> optional = Optional.ofNullable(new Employee());
        // 判断是否有值
        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    @Test
    public void test4() {
        Optional<Employee> optional = Optional.ofNullable(null);
        // 如果没有值，就返回一个新的对象
        Employee employee = optional.orElse(new Employee("lisi", 18, 1555.66));
        System.out.println(employee.getAge());
    }

    @Test
    public void test5() {
        Optional<Employee> op = Optional.ofNullable(null);
        Employee employee = op.orElseGet(() -> new Employee());// 可以有功能
        System.out.println(employee);
    }

    @Test
    public void test6() {
        Optional<Employee> op = Optional.ofNullable(new Employee("lisi", 18, 1555.66));
        Optional<String> str = op.map(e -> e.getName());
        System.out.println(str.get());
    }

    @Test
    public void test7() {
        Optional<Employee> op = Optional.ofNullable(new Employee("lisi", 18, 1555.66));
        Optional<String> str = op.flatMap(e -> Optional.of(e.getName()));
        System.out.println(str.get());
    }

    /**
     * 例题
     */
    @Test
    public void test8() {
        Optional<Godness> gn = Optional.ofNullable(new Godness("李老师"));
        Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));
        String n = getGodnessName(op);
        System.out.println(n);
    }

    // 获取一个男人心中的女神的名字
    public String getGodnessName(Optional<NewMan> newMan) {
        return newMan.orElse(new NewMan())
                .getGodness()
                .orElse(new Godness("苍老师"))
                .getName();
    }

}
