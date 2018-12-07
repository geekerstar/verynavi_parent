package com.verynavi.friend.service;

import com.verynavi.friend.client.UserClient;
import com.verynavi.friend.dao.FriendDao;
import com.verynavi.friend.dao.NoFriendDao;
import com.verynavi.friend.pojo.Friend;
import com.verynavi.friend.pojo.NoFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FriendService {

    @Autowired
    private FriendDao friendDao;

    @Autowired
    private NoFriendDao noFriendDao;

    @Autowired
    private UserClient userClient;


    public int addFriend(String userid, String friendid) {
        //先判断userid到friendid是否有数据，有就是重复添加好友，返回0
        Friend friend = friendDao.findByUseridAndFriendid(userid, friendid);
        if (friend != null) {
            return 0;
        }
        //直接添加好友，让好友表中userid到friendid方向为type为0
        friend = new Friend();
        friend.setUserId(userid);
        friend.setFriendId(friendid);
        friend.setIsLike("0");
        friendDao.save(friend);
        //判断从friend到userid是否有数据，如果有，把双方状态都改为1
        if (friendDao.findByUseridAndFriendid(friendid, userid) != null) {
            //把双方的islike都改成1
            friendDao.updateIslike("1", userid, friendid);
            friendDao.updateIslike("1", friendid, userid);
        }
        return 1;
    }

    public int addNoFriend(String userid, String friendid) {
        //先判断是否已经是非好友
        NoFriend noFriend = noFriendDao.findByUseridAndFriendid(userid, friendid);
        if (noFriend != null) {
            return 0;
        }
        noFriend = new NoFriend();
        noFriend.setUserId(userid);
        noFriend.setFriendId(friendid);
        noFriendDao.save(noFriend);
        return 1;
    }

    public void deleteFriend(String userid, String friendid) {
        //删除含有表中userid到friendid这条数据
        friendDao.deletfriend(userid, friendid);
        //更新friendid到userid的islike为0
        friendDao.updateIslike("0", friendid, userid);
        //非好友表中添加数据
        NoFriend nofriend = new NoFriend();
        nofriend.setUserId(userid);
        nofriend.setFriendId(friendid);
        noFriendDao.save(nofriend);
    }
}
