package dp_observer_mode;

public class Job {
    private String jobName;
    private String money;

    public Job() {
    }

    public Job(String jobName, String money) {
        this.jobName = jobName;
        this.money = money;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
