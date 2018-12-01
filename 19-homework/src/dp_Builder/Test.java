package dp_Builder;

public class Test{
    public static void main(String[] args) {

        Person person = new Person.PersonBulder()
                .name("李四")
                .sex("男")
                .height(173)
                .bulder();


        System.out.println(person);

    }
}
