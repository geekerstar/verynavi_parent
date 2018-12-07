package com.verynavi.spit.controller;

import com.verynavi.spit.pojo.Spit;
import com.verynavi.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 吐槽的表现层控制器
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Spit> spits = spitService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", spits);
    }

    /**
     * 根据id查询
     *
     * @return
     */
    @RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "spitId") String spitId) {
        Spit spit = spitService.findById(spitId);
        return new Result(true, StatusCode.OK, "查询成功", spit);
    }

    /**
     * 保存
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Spit spit) {
        spitService.save(spit);
        return new Result(true, StatusCode.OK, "保存成功");
    }

    /**
     * 更新
     *
     * @return
     */
    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result save(@PathVariable(value = "spitId") String spitId, @RequestBody Spit spit) {
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    /**
     * 删除
     *
     * @return
     */
    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "spitId") String spitId) {
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据父id去查询吐槽列表
     *
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result findByParentid(@PathVariable("parentid") String parentid, @PathVariable("page") int page, @PathVariable("size") int size) {
        Page<Spit> pageData = spitService.findByParentid(parentid, page, size);
        PageResult<Spit> pageResult = new PageResult<>(pageData.getTotalElements(), pageData.getContent());
        return new Result(true, StatusCode.OK, "查询成功", pageResult);
    }

    /**
     * 吐槽点赞
     *
     * @param spitId
     * @return
     */
    @RequestMapping(value = "/thumbup/{spitId}", method = RequestMethod.PUT)
    public Result updateThumbup(@PathVariable("spitId") String spitId) {
        //判断当前用户是否已经点赞，但是现在我们没有做认证，所以先把userid写死
        String userid = "111";
        //判断当前用户是否已经点赞
        if (redisTemplate.opsForValue().get("thumbup_" + userid) != null) {
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }
        spitService.updateThumbup(spitId);
        redisTemplate.opsForValue().set("thumbup_" + userid, 1);
        return new Result(true, StatusCode.OK, "点赞成功");
    }
}
