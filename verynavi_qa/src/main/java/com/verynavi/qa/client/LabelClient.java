package com.verynavi.qa.client;

import com.verynavi.qa.client.impl.LabelClientImpl;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户指向基础微服务的方法
 */
@FeignClient(value = "verynavi-base",fallback = LabelClientImpl.class)  // 此处不支持下划线
public interface LabelClient {

    /**
     * 根据id查询
     * @param labelId
     * @return
     */
    @RequestMapping(value = "/label/{labelId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
