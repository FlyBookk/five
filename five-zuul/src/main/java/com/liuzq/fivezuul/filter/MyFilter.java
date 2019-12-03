package com.liuzq.fivezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: five
 * @Package: com.liuzq.fivezuul.filter
 * @ClassName: MyFilter
 * @Author: liuzq
 * @Description:
 * @Date: 2019/12/3 10:11
 * @Version: 1.0
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
 * pre：路由之前
 * routing：路由之时
 * post： 路由之后
 * error：发送错误调用
 * filterOrder：过滤的顺序
 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
 * run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 * */
@Component
public class MyFilter extends ZuulFilter {
    Logger logger= LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("",e);
        }
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            logger.info("zuul路由失败,token为空!");
            ctx.setSendZuulResponse(false);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                logger.error("",e);
            }
        }
        return null;
    }
}
