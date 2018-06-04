package cn.zhengweiyi.jinchengnewsandroid.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import cn.zhengweiyi.jinchengnewsandroid.object.News;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "NEWS".
*/
public class NewsDao extends AbstractDao<News, Long> {

    public static final String TABLENAME = "NEWS";

    /**
     * Properties of entity News.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Content = new Property(2, String.class, "content", false, "CONTENT");
        public final static Property Author = new Property(3, String.class, "author", false, "AUTHOR");
        public final static Property ReleaseTime = new Property(4, java.util.Date.class, "releaseTime", false, "RELEASE_TIME");
        public final static Property UpdataTime = new Property(5, java.util.Date.class, "updataTime", false, "UPDATA_TIME");
        public final static Property Keywords = new Property(6, String.class, "keywords", false, "KEYWORDS");
        public final static Property CategoryId = new Property(7, int.class, "categoryId", false, "CATEGORY_ID");
        public final static Property Views = new Property(8, int.class, "views", false, "VIEWS");
    }


    public NewsDao(DaoConfig config) {
        super(config);
    }
    
    public NewsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"NEWS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"CONTENT\" TEXT," + // 2: content
                "\"AUTHOR\" TEXT," + // 3: author
                "\"RELEASE_TIME\" INTEGER," + // 4: releaseTime
                "\"UPDATA_TIME\" INTEGER," + // 5: updataTime
                "\"KEYWORDS\" TEXT," + // 6: keywords
                "\"CATEGORY_ID\" INTEGER NOT NULL ," + // 7: categoryId
                "\"VIEWS\" INTEGER NOT NULL );"); // 8: views
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"NEWS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, News entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
 
        java.util.Date releaseTime = entity.getReleaseTime();
        if (releaseTime != null) {
            stmt.bindLong(5, releaseTime.getTime());
        }
 
        java.util.Date updataTime = entity.getUpdataTime();
        if (updataTime != null) {
            stmt.bindLong(6, updataTime.getTime());
        }
 
        String keywords = entity.getKeywords();
        if (keywords != null) {
            stmt.bindString(7, keywords);
        }
        stmt.bindLong(8, entity.getCategoryId());
        stmt.bindLong(9, entity.getViews());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, News entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(3, content);
        }
 
        String author = entity.getAuthor();
        if (author != null) {
            stmt.bindString(4, author);
        }
 
        java.util.Date releaseTime = entity.getReleaseTime();
        if (releaseTime != null) {
            stmt.bindLong(5, releaseTime.getTime());
        }
 
        java.util.Date updataTime = entity.getUpdataTime();
        if (updataTime != null) {
            stmt.bindLong(6, updataTime.getTime());
        }
 
        String keywords = entity.getKeywords();
        if (keywords != null) {
            stmt.bindString(7, keywords);
        }
        stmt.bindLong(8, entity.getCategoryId());
        stmt.bindLong(9, entity.getViews());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public News readEntity(Cursor cursor, int offset) {
        News entity = new News( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // content
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // author
            cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)), // releaseTime
            cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)), // updataTime
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // keywords
            cursor.getInt(offset + 7), // categoryId
            cursor.getInt(offset + 8) // views
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, News entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContent(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAuthor(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setReleaseTime(cursor.isNull(offset + 4) ? null : new java.util.Date(cursor.getLong(offset + 4)));
        entity.setUpdataTime(cursor.isNull(offset + 5) ? null : new java.util.Date(cursor.getLong(offset + 5)));
        entity.setKeywords(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setCategoryId(cursor.getInt(offset + 7));
        entity.setViews(cursor.getInt(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(News entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(News entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(News entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
