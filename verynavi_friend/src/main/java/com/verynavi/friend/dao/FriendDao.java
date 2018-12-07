package com.verynavi.friend.dao;

import com.verynavi.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 交友的持久层接口
 */
public interface FriendDao extends JpaRepository<Friend, String> {

    public Friend findByUseridAndFriendid(String userid, String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid=? AND friendid=?", nativeQuery = true)
    public void updateIslike(String islike, String userid, String friendid);

    @Modifying
    @Query(value = "delete FROM tb_friend where userid = ? AND friend = ?", nativeQuery = true)
    void deletfriend(String userid, String friendid);
}
