package com.five.fivefeign.controller;

import com.five.fivefeign.service.FeignConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
@RequestMapping("/feign/comsumer")
public class RestConsumerController {
    Logger logger= LoggerFactory.getLogger(RestConsumerController.class);
    @Resource
    private FeignConsumer feignConsumer;
    @RequestMapping("/get")
    public String get(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getParameter("token");
        logger.info("token:{}",token);
        String str=feignConsumer.apiInfo();
        logger.info("通过feign形式消费，相应结果为：{}",str);
        return "OK!";
    }
}
