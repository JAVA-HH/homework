package dp.prototype;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        //cloneuser();//浅拷贝
        cloneuser2();
    }

    public static void cloneuser2 () throws CloneNotSupportedException {
        User2 user = new User2();
        user.setAge(18);
        user.setName("张三");
        user.setBirthday(new Date());

        User2 user2 = (User2) user.clone();

        System.out.println(user==user2);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirthday());

        user2.getBirthday().setDate(28);
        System.out.println(user2.getName());
        System.out.println(user.getBirthday());
        System.out.println(user2.getBirthday());

}

    private static void cloneuser() throws CloneNotSupportedException {
        User user = new User();
        user.setAge(18);
        user.setName("张三");
        user.setBirthday(new Date());

        User user2 = (User) user.clone();
        System.out.println(user==user2);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getBirthday());

        user2.getBirthday().setDate(28);
        System.out.println(user2.getName());
        System.out.println(user.getBirthday());
        System.out.println(user2.getBirthday());

    }
}
