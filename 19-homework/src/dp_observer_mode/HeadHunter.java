package dp_observer_mode;





import java.util.ArrayList;

public class HeadHunter {
    //存求职者的集合
    private ArrayList<WorkMan> manList = new ArrayList<>();
    //存工作岗位的集合
    private ArrayList<Job> jobList = new ArrayList<>();
    //添加求值者的方法
   public void addMan(WorkMan man){
       manList.add(man);
    }

    public void addJob(Job job){
       //把工作添加进去
       jobList.add(job);
        //通知求职者有岗位信息
        sendJobToMan(job);
    }
    //注销
    public void removeMan(WorkMan man){
       manList.remove(man);
    }
    //发布工作岗位的方法
    private void sendJobToMan(Job job) {
        for (WorkMan man : manList) {
            System.out.println(man.getName() + "你好,有一份工作" + job.getJobName() + "薪资" + job.getMoney() + "欢迎你前去面试");
        }
    }

}
