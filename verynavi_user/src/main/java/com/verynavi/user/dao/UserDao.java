package com.verynavi.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.verynavi.user.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 *
 * @author Administrator
 */
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    /**
     * 根据手机号去查询用户
     *
     * @param Mobile
     * @return
     */
    public User findByMobile(String Mobile);

    /**
     * 更新粉丝数量
     * @param x
     * @param friendid
     */
    @Modifying
    @Query(value = "update tb_user set fanscount=fanscount+? where id=?",nativeQuery = true)
    public void updatefanscount(int x,String friendid);

    /**
     * 更新关注数
     * @param x
     * @param userid
     */
    @Modifying
    @Query(value = "update tb_user set followcount=followcount+? where  id=?",nativeQuery = true)
    public void updatefollowcount(int x,String userid);


}
