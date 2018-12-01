package dp_sigleton;

public class TestSigleton {
    public static void main(String[] args) {
        //        Singleton1 x = Singleton1.getInstance();
//        Singleton1 y = Singleton1.getInstance();
//        Singleton1 z = Singleton1.getInstance();
//
//        System.out.println(x == y);
//        System.out.println(x == z);

        Sigleton2 instance = Sigleton2.getInstance();
        Sigleton2 instance1 = Sigleton2.getInstance();
        System.out.println(instance==instance1);

        Sigleton4 instance2 = Sigleton4.getInstance();
        instance2.test();
        Sigleton4 instance3 = Sigleton4.getInstance();
        System.out.println(instance2==instance3);


    }
}
