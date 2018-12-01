package dp_observer_mode;

public class Test {
    public static void main(String[] args) {
        //A:
        //案例:
        //找猎头找工作
        //B:
        //观察者 = 订阅者 + 发布者
        //WorkMan 找工作的人
        // HeadHunter 猎头
        // Job 工作岗位
        WorkMan s1 = new WorkMan("张三");
        WorkMan s2 = new WorkMan("李四");
        WorkMan s3 = new WorkMan("王五");
        WorkMan s4 = new WorkMan("赵六");
        WorkMan s5 = new WorkMan("田七");
        //到猎头那里注册一下
        HeadHunter headHunter = new HeadHunter();
        headHunter.addMan(s1);
        headHunter.addMan(s2);
        headHunter.addMan(s3);
        headHunter.addMan(s4);
        headHunter.addMan(s5);
        // // Job 工作岗位
        Job Javajob = new Job("Java开发工程师", "15000");
        Job phpjob = new Job("前端开发工程师", "10000");
        Job linux = new Job("运维工程师", "15000");
        //注销
        headHunter.removeMan(s5);
        //把工作添加到猎头处并发布给求职者
        headHunter.addJob(Javajob);
        headHunter.addJob(phpjob);
        headHunter.addJob(linux);
    }
}
