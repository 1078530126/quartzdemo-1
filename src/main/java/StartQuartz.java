import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * @author G
 * @description（）
 * @date 2018/7/31.
 */
public class StartQuartz implements Job {



    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {


        JobDetail jobDetail = jobExecutionContext.getJobDetail();


        String name = jobDetail.getJobDataMap().getString("name");

        System.out.println("你说是我们相见恨晚 我说  "+name+" at" +new Date());
        System.out.println("想问问你 敢不敢 像你说过的那样爱我   "+name+" at" +new Date());


    }



}
