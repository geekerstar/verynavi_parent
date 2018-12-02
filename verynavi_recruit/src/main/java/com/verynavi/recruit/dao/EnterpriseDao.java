package com.verynavi.recruit.dao;

import com.verynavi.recruit.pojo.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface EnterpriseDao extends JpaRepository<Enterprise, String>, JpaSpecificationExecutor<Enterprise> {

    /**
     * 按是否热门查询企业信息 where ishot = ?
     *
     * @param ishot
     * @return
     */
    public List<Enterprise> findByIshot(String ishot);

}
