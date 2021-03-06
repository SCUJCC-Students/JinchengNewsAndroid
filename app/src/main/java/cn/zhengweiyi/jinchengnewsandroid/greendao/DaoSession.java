package cn.zhengweiyi.jinchengnewsandroid.greendao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import cn.zhengweiyi.jinchengnewsandroid.object.News;
import cn.zhengweiyi.jinchengnewsandroid.object.Category;

import cn.zhengweiyi.jinchengnewsandroid.greendao.NewsDao;
import cn.zhengweiyi.jinchengnewsandroid.greendao.CategoryDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig newsDaoConfig;
    private final DaoConfig categoryDaoConfig;

    private final NewsDao newsDao;
    private final CategoryDao categoryDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        newsDaoConfig = daoConfigMap.get(NewsDao.class).clone();
        newsDaoConfig.initIdentityScope(type);

        categoryDaoConfig = daoConfigMap.get(CategoryDao.class).clone();
        categoryDaoConfig.initIdentityScope(type);

        newsDao = new NewsDao(newsDaoConfig, this);
        categoryDao = new CategoryDao(categoryDaoConfig, this);

        registerDao(News.class, newsDao);
        registerDao(Category.class, categoryDao);
    }
    
    public void clear() {
        newsDaoConfig.clearIdentityScope();
        categoryDaoConfig.clearIdentityScope();
    }

    public NewsDao getNewsDao() {
        return newsDao;
    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }

}
