package com.verynavi.search.dao;

import com.verynavi.search.pojo.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 文章搜索的持久层
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String>{

    /**
     * 使用关键字在文章的内容或者标题中模糊查询并分页
     * @param title
     * @param content
     * @param pageable
     * @return
     */
    Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);

}
