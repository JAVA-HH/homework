package Enum;

public class Test {
    public static void main(String[] args) {
        String name = Sex.MALE.cnName;
        System.out.println(name);
        String s = Sex.FEMALE.show();
        System.out.println(s);

        System.out.println("-------------------");
        // 获取枚举对象的序号，序号从0开始
        System.out.println(Sex.FEMALE.ordinal());
        System.out.println(Sex.MALE.ordinal());
        // 把枚举对象转为字符串
        String s1 = Sex.MALE.name();
        System.out.println(s1);

        Sex NAME = Sex.valueOf("MALE");
        System.out.println(NAME);
        // 把字符串转为枚举对象, 虚拟机中的枚举对象只会有一份, 可以用== 来比较
        System.out.println(Sex.valueOf("MALE") == Sex.MALE);

        Sex[] values = Sex.values();
        for (Sex value : values) {
            System.out.println(value);
        }
    }
}
