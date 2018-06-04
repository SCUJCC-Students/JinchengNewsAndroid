/*
 author 郑维一

 File：News.java
 Description：News Class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.object;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToOne;

import java.lang.reflect.Array;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class News {
    @Id(autoincrement = true)
    private long id;            //id
    private String title;       //标题
    private String content;     //内容
    private String author;      //作者
    private Date releaseTime;   //新闻发布时间
    private Date updataTime;    //新闻更新时间
    private String keywords;    //关键词
    private int categoryId;     //新闻类别
    @ToOne(joinProperty = "categoryId")
    private Category category;  //关系表
    private int views;          //浏览量

    @Generated(hash = 2067328315)
    public News(long id, String title, String content, String author,
            Date releaseTime, Date updataTime, String keywords, int categoryId,
            int views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.releaseTime = releaseTime;
        this.updataTime = updataTime;
        this.keywords = keywords;
        this.categoryId = categoryId;
        this.views = views;
    }

    @Generated(hash = 1579685679)
    public News() {
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseTime() {
        return this.releaseTime;
    }
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Date getUpdataTime() {
        return this.updataTime;
    }
    public void setUpdataTime(Date updataTime) {
        this.updataTime = updataTime;
    }

    public String getKeywords() {
        return this.keywords;
    }
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getCategoryId() {
        return this.categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getViews() {
        return this.views;
    }
    public void setViews(int views) {
        this.views = views;
    }
}
