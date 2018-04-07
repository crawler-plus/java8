package it4u.site;

public interface MyFunc {

    /**
     * 接口默认方法，用default修饰
     * @return
     */
    default String getName() {
        return "哈哈哈";
    }

    public static void show() {
        System.out.println("接口中的静态方法");
    }
}
