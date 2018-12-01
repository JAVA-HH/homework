package dp_Builder;

public class Person {
    private String name;
    private String sex;
    private Integer weight;
    private Integer height;

    public Person(String name, String sex, Integer weight, Integer height) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
    //建造器
    public static class PersonBulder{
        private String name;
        private String sex;
        private Integer weight;
        private Integer height;

        // 返回值类型不再是void 而是建造器类型本身
        public PersonBulder name(String name){
            this.name = name;
            return this;
        }
        public PersonBulder sex(String sex){
            this.sex = sex;
            return this;
        }
        public PersonBulder weight(Integer weight){
            this.weight = weight;
            return this;
        }
        public PersonBulder height(Integer height){
            this.height = height;
            return this;
        }

        public Person bulder(){
            // 需要的信息收集齐了

            return new Person(this.name,this.sex,this.weight,this.height);
        }

    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }
}
