package com.verynavi.spit.service;

import com.verynavi.spit.dao.SpitDao;
import com.verynavi.spit.pojo.Spit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import util.IdWorker;
import java.util.Date;
import java.util.List;

/**
 *
 * 吐槽的业务层
 */
@Service
public class SpitService {

    @Autowired
    private SpitDao spitDao;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询所有
     * @return
     */
    public List<Spit> findAll() {
        return spitDao.findAll();
    }

    /**
     * 根据id去查询
     * @param id
     * @return
     */
    public Spit findById(String id) {
        return spitDao.findById(id).get();
    }


    /**
     * 新增吐槽
     * @param spit
     */
    public void save(Spit spit) {
        spit.set_id(idWorker.nextId()+"");
        // 发布日期
        spit.setPublishtime(new Date());
        //浏览量
        spit.setVisits(0);
        //分享数
        spit.setShare(0);
        //点赞数
        spit.setThumbup(0);
        //回复数
        spit.setComment(0);
        //状态
        spit.setState("1");
        // 判断吐槽中是否有父id ，有父id 需要父id查询出来吐槽对象，并更新它的回复数
        if (spit.getParentid()!=null && !"".equals(spit.getParentid())){
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(spit.getParentid()));
            Update update = new Update();
            update.inc("comment",1);

        }
        spitDao.save(spit);
    }

    /**
     * 更新
     * @param spit
     */
    public void update(Spit spit) {
        spitDao.save(spit);
    }

    /**
     * 删除id
     * @param id
     */
    public void deleteById(String id) {
        spitDao.deleteById(id);
    }

    /**
     * 根据父级id查询吐槽
     * @param parentid
     * @param page
     * @param size
     * @return
     */
    public Page<Spit> findByParentid(String parentid,int page,int size) {
        // 创建分页对象
        PageRequest pageRequest = PageRequest.of(page,size);
        // 执行查询并返回
        return spitDao.findByParentid(parentid,pageRequest);
    }

    //方式一：效率有问题
//    public void updateThumbup(String spitId){
//        Spit spit = spitDao.findById(spitId).get();
//        spit.setThumbup((spit.getThumbup()==null?0:spit.getThumbup())+1);
//        spitDao.save(spit);
//    }

    public void updateThumbup(String spitId){
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is("1"));
        Update update = new Update();
        update.inc("thumbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }



}
