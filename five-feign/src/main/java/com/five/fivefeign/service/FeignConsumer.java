package com.five.fivefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @ProjectName: five
 * @Package: com.five.fivefeign.service
 * @ClassName: FeignConsumer
 * @Author: liuzq
 * @Description: feign调用
 * @Date: 2019/12/2 17:02
 * @Version: 1.0
 */
@FeignClient(name="PROVIDER",fallback = SchedualServiceHiHystric.class)
public interface FeignConsumer {
    @RequestMapping(value = "rest/get/resp", method = RequestMethod.POST)
     String apiInfo();
}
