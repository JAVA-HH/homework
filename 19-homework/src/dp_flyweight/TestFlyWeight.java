package dp_flyweight;

public class TestFlyWeight {
    public static void main(String[] args) {
        //提倡重用已有对象，而不是创建新的对象
        //连接池--对数据库连接对象进行了重用
        System.out.println(Integer.valueOf(1)==Integer.valueOf(1));
        System.out.println(Integer.valueOf(127)==Integer.valueOf(127));
        System.out.println(Integer.valueOf(128)==Integer.valueOf(128));
    }
}
