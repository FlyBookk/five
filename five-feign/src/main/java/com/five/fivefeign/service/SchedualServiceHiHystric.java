package com.five.fivefeign.service;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: five
 * @Package: com.five.fivefeign.service
 * @ClassName: SchedualServiceHiHystric
 * @Author: liuzq
 * @Description: 熔断策略方法
 * @Date: 2019/12/2 17:56
 * @Version: 1.0
 */
@Component
public class SchedualServiceHiHystric  implements FeignConsumer{

    @Override
    public String apiInfo() {
        return "sorry error! 执行熔断策略返回....";
    }
}
