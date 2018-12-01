package dp_sigleton;

public class Sigleton2 {
    //懒汉式

    //私有构造
    private Sigleton2(){}

    private static Sigleton2 ME;

    public static synchronized Sigleton2 getInstance(){
        if (ME==null){
            ME = new Sigleton2();
        }
        return ME;
    }
}
