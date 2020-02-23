package com.qavan.vi_db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(active = true, nameInDb = "TASKS")
public class Task {
    @Id
    private Long id;
    @NotNull
    private String mStatus;
    @NotNull
    private String mTitle;
    @NotNull
    private String mAddress;
    @NotNull
    private String mExpireDate;
    @NotNull
    private String mClient;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;


    Task(String status, String title, String address, String expireDate, String client) {
        this.mStatus = status;
        this.mTitle = title;
        this.mAddress = address;
        this.mExpireDate = expireDate;
        this.mClient = client;
    }


    @Generated(hash = 865361193)
    public Task(Long id, @NotNull String mStatus, @NotNull String mTitle,
                @NotNull String mAddress, @NotNull String mExpireDate, @NotNull String mClient) {
        this.id = id;
        this.mStatus = mStatus;
        this.mTitle = mTitle;
        this.mAddress = mAddress;
        this.mExpireDate = mExpireDate;
        this.mClient = mClient;
    }


    @Generated(hash = 733837707)
    public Task() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getMStatus() {
        return this.mStatus;
    }


    public void setMStatus(String mStatus) {
        this.mStatus = mStatus;
    }


    public String getMTitle() {
        return this.mTitle;
    }


    public void setMTitle(String mTitle) {
        this.mTitle = mTitle;
    }


    public String getMAddress() {
        return this.mAddress;
    }


    public void setMAddress(String mAddress) {
        this.mAddress = mAddress;
    }


    public String getMExpireDate() {
        return this.mExpireDate;
    }


    public void setMExpireDate(String mExpireDate) {
        this.mExpireDate = mExpireDate;
    }


    public String getMClient() {
        return this.mClient;
    }


    public void setMClient(String mClient) {
        this.mClient = mClient;
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


    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }
}
