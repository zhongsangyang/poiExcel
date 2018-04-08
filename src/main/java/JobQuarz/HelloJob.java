package JobQuarz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.util.Date;
public class HelloJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Hello word -"+new Date());
    }
}
