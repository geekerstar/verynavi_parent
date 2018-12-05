package com.verynavi.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

/**
 * @author geekerstar
 * @date 2018/12/5
 * description
 */
@Component
public class ManageFilter extends ZuulFilter {
    /**
     * 在请求前pre或者后post执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器的执行顺序，数字越小，表示越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作 return 任何object的值都表示继续执行
     * setsendzullResponse(false)表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
