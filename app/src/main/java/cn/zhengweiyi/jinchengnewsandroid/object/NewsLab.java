package cn.zhengweiyi.jinchengnewsandroid.object;

import android.app.Application;

import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.MyApplication;
import cn.zhengweiyi.jinchengnewsandroid.greendao.DaoSession;
import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;

public class NewsLab {
    private NewsDao newsDao;
    public NewsLab(NewsDao newsDao) {
        this.newsDao = newsDao;
    }
    public List<News> getNews() {
        return newsDao.loadAll();
    }

    public  List<News> getNewsByCat(Long catId) {
        return newsDao.queryBuilder().where(NewsDao.Properties.CategoryId.eq(catId))
                .list();
    }
}
