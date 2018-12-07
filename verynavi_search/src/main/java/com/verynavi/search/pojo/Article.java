package com.verynavi.search.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * ElasticSearch中的最小级（文档）
 * 表示一个文档类，需要指定文档是什么类型，以及在那个索引中
 */
@Document(indexName = "tensquare_article", type = "article")
public class Article implements Serializable {

    @Id
    private String id;
    /**
     * 是否索引，就是看该域是否能被搜索
     * 是否粉刺，就表示搜索的时候是整体匹配还是单词匹配
     * 是否存储，是否在页面上显示
     */
    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;
    /**
     * 审核状态
     */
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
