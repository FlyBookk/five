package com.liuzq.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: five
 * @Package: com.liuzq.consumer.controller
 * @ClassName: RestFullController
 * @Author: liuzq
 * @Description: 使用ribbon去做restful形式消费
 * @Date: 2019/12/2 15:33
 * @Version: 1.0
 */
@RestController
@RequestMapping("/rest/get")
public class RestFullController {
    Logger logger= LoggerFactory.getLogger(RestController.class);
    @Value("${server.port}")
    private String port;
    @RequestMapping("/resp")
    public String get(){
        System.out.println(1/0);
        logger.info("通过ribbon+restful形式消费。。。。。端口：{}",port);
        return "通过ribbon+restful形式消费。。。。。端口"+port;
    }
}
