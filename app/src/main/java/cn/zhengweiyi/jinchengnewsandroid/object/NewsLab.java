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
     * @return 返回新闻数组
     */
    public List<News> getNews() {
        return newsDao.loadAll();
    }

    /**
     * 根据类ID获取新闻
     * @param catId CategoryID 类ID
     * @return 返回新闻数组
     */
    public  List<News> getNewsByCat(Long catId) {
        return newsDao.queryBuilder().where(NewsDao.Properties.CategoryId.eq(catId))
                .list();
    }
}
