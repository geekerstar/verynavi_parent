package com.verynavi.article.dao;

import com.verynavi.article.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article>{

    /**
     * 文章点赞
     * @param articleId
     *
     * modifying 操作更新
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup =thumpup+1 WHERE id =?",nativeQuery = true)
    public void thumbup(String articleId);

    /**
     * 文章审核
     * @param articleId
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?",nativeQuery = true)
    public void examine(String articleId);

}
