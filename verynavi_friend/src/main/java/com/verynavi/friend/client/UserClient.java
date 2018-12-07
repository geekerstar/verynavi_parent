package com.verynavi.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户操作的调用接口
 */
@Component
@FeignClient("verynavi-user")
public interface UserClient {


    @RequestMapping(value = "/user/{userid}/{friendid}/{x]", method = RequestMethod.POST)
    void updatefanscountandfollowcount(@PathVariable("userid") String useId, @PathVariable("friendid") String friendid, @PathVariable("x") int x);


}
