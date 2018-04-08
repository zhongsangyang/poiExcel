package JobQuarz;

import org.springframework.stereotype.Component;

@Component
public class MailJob {
    public void run(){
        System.out.println("我在发送邮件");

    }
}
