/*
 author 郑维一

 File：News.java
 Description：News Class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.object;

import android.net.Uri;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToOne;

import java.lang.reflect.Array;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import cn.zhengweiyi.jinchengnewsandroid.greendao.DaoSession;
import cn.zhengweiyi.jinchengnewsandroid.greendao.CategoryDao;
import org.greenrobot.greendao.annotation.NotNull;
import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;

@Entity
public class News {
    @Id(autoincrement = true)
    private Long id;            //id
    private String title;       //标题
    private String content;     //内容
    private String author;      //作者
    private int images;         //图片
    private Date releaseTime;   //新闻发布时间
    private Date updateTime;    //新闻更新时间
    private String keywords;    //关键词
    private Long categoryId;    //新闻类别
    @ToOne(joinProperty = "categoryId")
    private Category category;  //关系表
    private int views;          //浏览量

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 255022283)
    private transient NewsDao myDao;
    @Generated(hash = 1372501278)
    private transient Long category__resolvedKey;

    @Keep
    public News(String title, String content, String author, int images,
                Date releaseTime, Date updateTime, String keywords, Long categoryId,
                int views) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.images = images;
        this.releaseTime = releaseTime;
        this.updateTime = updateTime;
        this.keywords = keywords;
        this.categoryId = categoryId;
        this.views = views;
    }


    @Generated(hash = 589358515)
    public News(Long id, String title, String content, String author, int images,
            Date releaseTime, Date updateTime, String keywords, Long categoryId,
            int views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.images = images;
        this.releaseTime = releaseTime;
        this.updateTime = updateTime;
        this.keywords = keywords;
        this.categoryId = categoryId;
        this.views = views;
    }


    @Generated(hash = 1579685679)
    public News() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
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


    public int getImages() {
        return this.images;
    }


    public void setImages(int images) {
        this.images = images;
    }


    public Date getReleaseTime() {
        return this.releaseTime;
    }


    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }


    public Date getUpdateTime() {
        return this.updateTime;
    }


    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    public String getKeywords() {
        return this.keywords;
    }


    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public Long getCategoryId() {
        return this.categoryId;
    }


    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    public int getViews() {
        return this.views;
    }


    public void setViews(int views) {
        this.views = views;
    }


    /** To-one relationship, resolved on first access. */
    @Generated(hash = 728129201)
    public Category getCategory() {
        Long __key = this.categoryId;
        if (category__resolvedKey == null || !category__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoryDao targetDao = daoSession.getCategoryDao();
            Category categoryNew = targetDao.load(__key);
            synchronized (this) {
                category = categoryNew;
                category__resolvedKey = __key;
            }
        }
        return category;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1132018243)
    public void setCategory(Category category) {
        synchronized (this) {
            this.category = category;
            categoryId = category == null ? null : category.getId();
            category__resolvedKey = categoryId;
        }
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }


    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 543991306)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getNewsDao() : null;
    }
}