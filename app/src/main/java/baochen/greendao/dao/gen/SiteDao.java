package baochen.greendao.dao.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import baochen.greendao.bean.Site;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SITE".
*/
public class SiteDao extends AbstractDao<Site, Long> {

    public static final String TABLENAME = "SITE";

    /**
     * Properties of entity Site.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property OwnerTag = new Property(1, String.class, "ownerTag", false, "OWNER_TAG");
    };

    private Query<Site> userBean3_OwnedSitesQuery;

    public SiteDao(DaoConfig config) {
        super(config);
    }
    
    public SiteDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SITE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"OWNER_TAG\" TEXT NOT NULL );"); // 1: ownerTag
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SITE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Site entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getOwnerTag());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Site entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getOwnerTag());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Site readEntity(Cursor cursor, int offset) {
        Site entity = new Site( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1) // ownerTag
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Site entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setOwnerTag(cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Site entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Site entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "ownedSites" to-many relationship of UserBean3. */
    public List<Site> _queryUserBean3_OwnedSites(String ownerTag) {
        synchronized (this) {
            if (userBean3_OwnedSitesQuery == null) {
                QueryBuilder<Site> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.OwnerTag.eq(null));
                userBean3_OwnedSitesQuery = queryBuilder.build();
            }
        }
        Query<Site> query = userBean3_OwnedSitesQuery.forCurrentThread();
        query.setParameter(0, ownerTag);
        return query.list();
    }

}
