package com.verynavi.article.pojo;

import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.io.Serializable;

/**
 * @author geekerstar
 * @date 2018/12/7
 * description
 */
public class Comment implements Serializable {
    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Data publishdata;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Data getPublishdata() {
        return publishdata;
    }

    public void setPublishdata(Data publishdata) {
        this.publishdata = publishdata;
    }
}
