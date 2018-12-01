package dp_sigleton;

public class Sigleton1 {
    //饿汉式

    //私有构造
    private Sigleton1(){}
    //在本类中创建对象
    private static final Sigleton1 ME = new Sigleton1();

    //提供公共的静态访问方法
    public static Sigleton1 getInstance(){
        return ME;
    }
}
