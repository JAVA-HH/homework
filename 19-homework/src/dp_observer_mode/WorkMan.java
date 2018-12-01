package dp_observer_mode;

public class WorkMan {
    private String name;

    public WorkMan() {
    }

    public WorkMan(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WorkMan{" +
                "name='" + name + '\'' +
                '}';
    }

}
