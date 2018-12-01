package Enum;

public enum  Sex {
    MALE("男"),
    FEMALE("女");
    String cnName;
    Sex(String name){
        this.cnName=name;
    }
    public String show(){
        return "枚举";
    }
}
