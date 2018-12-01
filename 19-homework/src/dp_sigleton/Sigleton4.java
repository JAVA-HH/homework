package dp_sigleton;

public class Sigleton4 {
    static {
        System.out.println("主类的静态方法执行了");
    }

    private Sigleton4(){}

    // holder 拥有, 由静态内部类创建了他的唯一实例
    private static class Hoder{
        static {
            System.out.println("hoder类的静态方法执行了");
        }
        static Sigleton4 ME = new Sigleton4();
    }

    public static Sigleton4 getInstance(){
        return Hoder.ME;

    }

    static void test(){
        System.out.println("test方法执行了");
    }
}
