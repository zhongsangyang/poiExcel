package JobQuarz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class SimpleExample {
    public static void schedulerFactroy(){
        SchedulerFactory sf= new StdSchedulerFactory();
        try {
            Scheduler scheduler=sf.getScheduler();
            JobDetail job = newJob(HelloJob.class)
                    .withIdentity("job1", "group1")
                    .build();
            Date runTime = evenMinuteDate(new Date());
           TriggerBuilder triggerBuilder=newTrigger().withIdentity("trigger1","group2");
           Trigger trigger=triggerBuilder.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3)).build();
            scheduler.scheduleJob(job,trigger);
            scheduler.start();
            Thread.sleep(90L*1000L);
            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        schedulerFactroy();
    }
}
