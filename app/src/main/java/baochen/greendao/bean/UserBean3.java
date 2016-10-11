package baochen.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import baochen.greendao.dao.gen.DaoSession;
import baochen.greendao.dao.gen.UserBean3Dao;
import baochen.greendao.dao.gen.SiteDao;

/**
 * Created by baochen on 2016/10/11.
 * 一对多关联
 */
@Entity
public class UserBean3 {
    @Id
    private Long id;
    @Unique
    private String authorTag;

    @ToMany(joinProperties = {
            @JoinProperty(name = "authorTag", referencedName = "ownerTag")
    })
    private List<Site> ownedSites;

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

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2095874465)
    public synchronized void resetOwnedSites() {
        ownedSites = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 207652299)
    public List<Site> getOwnedSites() {
        if (ownedSites == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            SiteDao targetDao = daoSession.getSiteDao();
            List<Site> ownedSitesNew = targetDao._queryUserBean3_OwnedSites(authorTag);
            synchronized (this) {
                if(ownedSites == null) {
                    ownedSites = ownedSitesNew;
                }
            }
        }
        return ownedSites;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1975407876)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserBean3Dao() : null;
    }

    /** Used for active entity operations. */
    @Generated(hash = 1736606682)
    private transient UserBean3Dao myDao;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    public String getAuthorTag() {
        return this.authorTag;
    }

    public void setAuthorTag(String authorTag) {
        this.authorTag = authorTag;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 120421374)
    public UserBean3(Long id, String authorTag) {
        this.id = id;
        this.authorTag = authorTag;
    }

    @Generated(hash = 1813052433)
    public UserBean3() {
    }
}
