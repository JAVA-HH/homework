package dp_iterator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        //以一种一致的对集合内的元素进行遍历，而不用在乎集合内的数据结构
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(9);
        list.add(2);
        list.add(5);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
