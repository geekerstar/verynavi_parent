package com.verynavi.article.dao;

import com.verynavi.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author geekerstar
 * @date 2018/12/7
 * description 评论
 */
public interface CommentDao extends MongoRepository<Comment,String> {

    /**
     * 根据文章ID查询评论列表
     * @param articleid
     * @return
     */
    public List<Comment> findByArticleid(String articleid);
}
