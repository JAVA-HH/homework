package dp_Strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 18));
        list.add(new Student("lisi", 20));
        list.add(new Student("wangwu", 16));
        list.add(new Student("zhaoliu", 22));
        list.add(new Student("zhaoliu", 20));
        //按年龄排
        Collections.sort(list, ( o1,  o2)-> o1.getAge()-o2.getAge());//默认是从小到大
        System.out.println(list);
        Collections.sort(list, (a, b) ->  {
            int x = a.getName().compareTo(b.getName());

            return x==0?a.getAge() - b.getAge():x;

        } );
        System.out.println(list);
    }
}
