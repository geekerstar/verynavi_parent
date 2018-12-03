package com.verynavi.spit.dao;

import com.verynavi.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * 吐槽的持久层接口
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    /**
     * 根据吐槽的父ID去查询吐槽列表
     * @param parentid
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);

}
