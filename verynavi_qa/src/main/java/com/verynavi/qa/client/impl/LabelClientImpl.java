package com.verynavi.qa.client.impl;

import com.verynavi.qa.client.LabelClient;
import entity.Result;
import entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @author geekerstar
 * @date 2018/12/5
 * description
 */
@Component
public class LabelClientImpl implements LabelClient {

    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.ERROR, "熔断器触发了！");
    }
}
