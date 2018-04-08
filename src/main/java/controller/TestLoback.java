package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loback")
public class TestLoback {
    private Logger logger=LoggerFactory.getLogger(TestLoback.class);
    private Logger logger1=LoggerFactory.getLogger("123456");
   @RequestMapping("/test")
    public String toIndex(){
        logger.info("我是一个日志测试信息");
       logger1.debug("我是一个debug信息");
       return "index";
   }

   @RequestMapping("/newTest")
    public String testIndex(){
       logger.debug("我是一个debug信息的日志");
       return "index";
   }




}
