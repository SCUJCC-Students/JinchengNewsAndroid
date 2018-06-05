/*
 author 郑维一

 File：MyApplication.java
 Description：News Class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zhengweiyi.jinchengnewsandroid.greendao.CategoryDao;
import cn.zhengweiyi.jinchengnewsandroid.greendao.DaoMaster;
import cn.zhengweiyi.jinchengnewsandroid.greendao.DaoSession;
import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;
import cn.zhengweiyi.jinchengnewsandroid.object.Category;
import cn.zhengweiyi.jinchengnewsandroid.object.News;

public class MyApplication extends Application {
    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private List<News> newsList = new ArrayList<>();
    private List<Category> categoryList = new ArrayList<>();
    //静态单例
    public static MyApplication instances;

    @Override
    public void onCreate() {
        super.onCreate();
        instances = this;
        setDatabase();
    }
    public static MyApplication getInstances(){
        return instances;
    }

    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，TODO 应该做一层封装，来实现数据库的安全升级。
        mHelper = new DaoMaster.DevOpenHelper(this, "sport-db", null);
        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
    public SQLiteDatabase getDb() {
        return db;
    }

    /**
     * 初始化数据
     */
    public void initData() {
        //Date datenow = new Date();
        //News news1 = new News("再不睡觉就要死了！熬最长的夜，住最贵的ICU", "说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。锦城猪健文日了解一下？", "郑维一", datenow, null, null, 1, 526);
        NewsDao newsDao = getDaoSession().getNewsDao();
        CategoryDao categoryDao = getDaoSession().getCategoryDao();
        for (Long c = 0L; c < 3; c++) {
            Category category = new Category(null, "类型" + c);
            categoryList.add(category);

            for (int i = 0; i < 15; i++) {
                Date date = new Date();
                News news = new News("再不睡觉就要死了！熬最长的夜住最贵的ICU" + i,
                        "说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。" +
                                "锦城猪健文日了解一下？" + i, "郑维一" + i, date, null,
                        "睡觉", c, 0);
                newsList.add(news);
            }
        }
        categoryDao.saveInTx(categoryList);
        newsDao.saveInTx(newsList);
    }

}
