import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * @author G
 * @description（）
 * @date 2018/7/31.
 */
public class MainQuartz {


    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //定义一个trigger
            Trigger  trigger  =  newTrigger().
                    withIdentity("trigger1", "group1").startNow().
                    withSchedule(simpleSchedule().withIntervalInSeconds(1).repeatForever()).
                    build();
            //定义一个jodetail
            JobDetail job = newJob(StartQuartz.class).
                    withIdentity("job1", "group1").
                    usingJobData("name", "quartz").build();
            //加入这个调度
            scheduler.scheduleJob(job, trigger);
            //启动
            scheduler.start();
            //运行一段时间后关闭
            Thread.sleep(10000);
            scheduler.shutdown(true);
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
