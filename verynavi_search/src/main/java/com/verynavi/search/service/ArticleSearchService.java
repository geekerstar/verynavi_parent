package com.verynavi.search.service;

import com.verynavi.search.dao.ArticleSearchDao;
import com.verynavi.search.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import util.IdWorker;


@Service
public class ArticleSearchService {

    @Autowired
    private ArticleSearchDao articleSearchDao;

//    @Autowired
//    private IdWorker idWorker;

    /**
     * 保存方法
     *
     * @param article
     */
    public void save(Article article) {
//        article.setId(idWorker.nextId()+"");
        articleSearchDao.save(article);
    }

    public Page<Article> findByKeywords(String keywords, int page, int size) {
        // 创建分页对象
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        // 查询并返回
        return articleSearchDao.findByTitleOrContentLike(keywords, keywords, pageRequest);
    }

}
