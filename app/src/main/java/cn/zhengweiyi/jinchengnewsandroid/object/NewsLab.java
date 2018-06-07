/*
 author 郑维一

 File：NewsLab.java
 Description：get News
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid.object;

import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;

public class NewsLab {
    private NewsDao newsDao;

    public NewsLab(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    /**
     * 获取全部新闻
     * @return 返回新闻数据
     */
    public List<News> getNews() {
        return newsDao.loadAll();
    }

    /**
     * 根据类ID获取新闻
     * @param catId CategoryID 类ID
     * @return 返回新闻数据
     */
    public List<News> getNewsByCat(Long catId) {
        return newsDao.queryBuilder().where(NewsDao.Properties.CategoryId.eq(catId))
                .list();
    }

    /**
     * 根据新闻Id获取新闻
     * @param Id 新闻ID
     * @return 返回新闻数据
     */
    public List<News> getNewsById(Long Id) {
        return newsDao.queryBuilder().where(NewsDao.Properties.Id.eq(Id)).list();
    }
}
