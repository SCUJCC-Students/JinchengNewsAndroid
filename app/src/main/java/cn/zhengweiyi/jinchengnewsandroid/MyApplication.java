/*
 author 郑维一

 File：MyApplication.java
 Description：custom Application class
 Site：www.zhengweiyi.cn
 */

package cn.zhengweiyi.jinchengnewsandroid;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

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
     * 设置 GreenDao
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
     * TODO 实现服务器读取后删除/修改该方法
     */
    public void initData() {
        NewsDao newsDao = getDaoSession().getNewsDao();
        CategoryDao categoryDao = getDaoSession().getCategoryDao();
        Date dateNow = new Date();
        News news1 = new News("再不睡觉就要死了！熬最长的夜，住最贵的ICU",
                "说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。锦城猪健文日了解一下？\n\n" +
                        "如果生命到此为止\n" +
                        "你是不是没有任何遗憾？\n\n" +
                        "近日\n" +
                        "一条关于“朋克养生”的短片刷爆网络\n" +
                        "上线仅三天微博点击量超2500万次！\n" +
                        "内容十分扎心！\n" +
                        "看完本编立马泡了一杯枸杞…\n\n" +
                        "视频：《健康本该如此》\n" +
                        "短片中的每一个场景，\n" +
                        "都是现代人生活的缩影。\n" +
                        "故事里的主人公\n" +
                        "就像我们身边的每一个人：\n" +
                        "“一边慢性轻生，一边养着生。”\n" +
                        "一边熬夜到天明，\n" +
                        "一边兢兢业业敷着最贵的面膜；\n\n" +
                        "一边心血来潮地办健身年卡，\n一边闲置后出售；\n\n" +
                        "听说手机辐射伤害眼睛，\n" +
                        "一边玩着手机，\n" +
                        "一边把屏幕换成了绿色；\n\n" +
                        "一边吃垃圾食品，一边给自己泡杯枸杞水；\n" +
                        "一边喊着减肥，一边把零食往嘴里送；\n" +
                        "一边蹦迪，一边吃维生素；\n" +
                        "一边养着生，一边熬夜作着死……\n" +
                        "可是化再贵的妆，\n" +
                        "也遮不住黑眼圈。\n" +
                        "吃再多的保养品，\n" +
                        "也难以治愈已经出问题的身体。\n" +
                        "肥胖、皮肤癌、猝死……\n" +
                        "住一次ICU，可以迅速榨干整个家庭。\n" +
                        "灵魂熬得起，肉体却伤不起。\n" +
                        "你可以继续想要很多很多钱，\n" +
                        "想要很多很多爱，\n" +
                        "但请记得：\n" +
                        "健康是根本，\n" +
                        "且作且珍惜！"
                , "郑维一", R.mipmap.news_time_go_to_sleep, dateNow, null, null, 0L, 526);
        News news2 = new News("2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校举行", "锦城国旗护卫队讯 2018年5月26日，2018年四川省高校国旗护卫队联盟会操暨锦城国旗护卫队十周年庆典在我校第一运动场举行，来自四川省27所高校国旗护卫队、国旗班、仪仗队的战友们齐聚锦城。", "锦城国旗护卫队", R.mipmap.news_flag_guard_2018parade, dateNow, null, null, 2L, 2387);
        News news3 = new News("毕业季，3招教你拍出网红毕业照", "没有内容", "锦城青年", R.drawable.ic_image_default, dateNow, null, null, 1L, 127);
        News news4 = new News("和西瓜最配的动画电影", "没有内容", "四川大学锦城学院", R.mipmap.news_cartoon_movie, dateNow, null, null, 0L, 36);
        News news5 = new News("我校第十二届大学生创新创业大赛总决赛暨颁奖典礼精彩预告", "没有内容", "四川大学锦城学院", R.mipmap.news_venture_contest_price, dateNow, null, null, 0L, 90);
        News news6 = new News("小便带你回顾去年做客锦大的那些明星", "没有内容", "四川大学锦城学院", R.drawable.ic_image_default, dateNow, null, null, 0L, 1370);
        News news7 = new News("民谣伴你度周末！", "没有内容", "四川大学锦城学院", R.drawable.ic_image_default, dateNow, null, null, 0L, 130);
        News news8 = new News("思考未来 方可赢得未来 —— 《未来型教育论坛学术论文集》", "没有内容", "四川大学锦城学院", R.drawable.ic_image_default, dateNow, null, null, 0L, 38);
        newsList.add(news1);
        newsList.add(news2);
        newsList.add(news3);
        newsList.add(news4);
        newsList.add(news5);
        newsList.add(news6);
        newsList.add(news7);
        newsList.add(news8);
        for (Long c = 0L; c < 3; c++) {
            Category category = new Category(null, "类型" + c);
            categoryList.add(category);
            for (int i = 0; i < 15; i++) {
                Date date = new Date();
                News news = new News("再不睡就死了!熬最长的夜,住最贵的ICU" + i + "来自类型" + c,
                        "说真的，好久没有好好睡个觉了。现在熬夜和面膜都不配了，最配的都变成ICU了。" +
                                "锦城猪健文日了解一下？" + i, "郑维" + i + "类型" +c , R.mipmap.news_time_go_to_sleep, date, null,
                        "睡觉", c, 0);
                newsList.add(news);
            }
        }
        categoryDao.saveInTx(categoryList);
        newsDao.saveInTx(newsList);
    }
}
