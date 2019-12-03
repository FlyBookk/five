package com.liuzq.restribbon.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ProjectName: five
 * @Package: com.liuzq.restribbon.controller
 * @ClassName: RestConsumerController
 * @Author: liuzq
 * @Description: rest消费
 * @Date: 2019/12/2 15:44
 * @Version: 1.0
 */
@RestController
@RequestMapping("/ribbon/comsumer")
public class RestConsumerController {
    Logger logger= LoggerFactory.getLogger(RestConsumerController.class);
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/get")
    @HystrixCommand(fallbackMethod = "hiError")
    public String get(){
        String forObject = restTemplate.getForObject("http://PROVIDER/rest/get/resp", String.class);
        logger.info("通过ribbon+restful形式消费，相应结果为：{}",forObject);
        return "OK!";
    }
    public String hiError() {
        logger.info("rest调用失败，执行熔断策略。。。。。。");
        return "hi,sorry,error!";
    }
}
