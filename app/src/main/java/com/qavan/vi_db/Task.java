package com.qavan.vi_db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;


@Entity(active = true, nameInDb = "TASKS_TEST")
public class Task {
    @Id
    private Long id;
    @NotNull
    private Byte mStatus;
    @NotNull
    private String mTitle;
    @NotNull
    private String mAddress;
    @NotNull
    private String mExpireDate;
    @NotNull
    private String mClient;
    @NotNull
    private Byte mEType;
    @NotNull
    private Long mEValue1;
    private Long mEValue2;
    private Long mEValue3;
    @NotNull
    private Byte mHWType;
    @NotNull
    private Long mHWValue1;
    private Long mHWValue2;
    private Long mHWValue3;
    @NotNull
    private Byte mCWType;
    @NotNull
    private Long mCWValue1;
    private Long mCWValue2;
    private Long mCWValue3;
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


    Task(Byte status, String title, String address, String expireDate, String client,
         Byte electricityType, Long eValue1, @NotNull Long eValue2, @NotNull Long eValue3,
         Byte hotWaterType, Long hotWaterValue1, @NotNull Long hotWaterValue2, @NotNull Long hotWaterValue3,
         Byte coldWaterType, Long coldWaterValue1, @NotNull Long coldWaterValue2, @NotNull Long coldWaterValue3
    ) {
        this.mStatus = status;
        this.mTitle = title;
        this.mAddress = address;
        this.mExpireDate = expireDate;
        this.mClient = client;
        this.mEType = electricityType;
        this.mEValue1 = eValue1;
        this.mEValue2 = eValue2;
        this.mEValue3 = eValue3;
        this.mHWType = hotWaterType;
        this.mHWValue1 = hotWaterValue1;
        this.mHWValue2 = hotWaterValue2;
        this.mHWValue3 = hotWaterValue3;
        this.mCWType = coldWaterType;
        this.mCWValue1 = coldWaterValue1;
        this.mCWValue2 = coldWaterValue2;
        this.mCWValue3 = coldWaterValue3;
    }


    @Generated(hash = 1091582456)
    public Task(Long id, @NotNull Byte mStatus, @NotNull String mTitle, @NotNull String mAddress,
                @NotNull String mExpireDate, @NotNull String mClient, @NotNull Byte mEType, @NotNull Long mEValue1,
                Long mEValue2, Long mEValue3, @NotNull Byte mHWType, @NotNull Long mHWValue1, Long mHWValue2,
                Long mHWValue3, @NotNull Byte mCWType, @NotNull Long mCWValue1, Long mCWValue2, Long mCWValue3) {
        this.id = id;
        this.mStatus = mStatus;
        this.mTitle = mTitle;
        this.mAddress = mAddress;
        this.mExpireDate = mExpireDate;
        this.mClient = mClient;
        this.mEType = mEType;
        this.mEValue1 = mEValue1;
        this.mEValue2 = mEValue2;
        this.mEValue3 = mEValue3;
        this.mHWType = mHWType;
        this.mHWValue1 = mHWValue1;
        this.mHWValue2 = mHWValue2;
        this.mHWValue3 = mHWValue3;
        this.mCWType = mCWType;
        this.mCWValue1 = mCWValue1;
        this.mCWValue2 = mCWValue2;
        this.mCWValue3 = mCWValue3;
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


    public Byte getMStatus() {
        return this.mStatus;
    }


    public void setMStatus(Byte mStatus) {
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


    public Byte getMEType() {
        return this.mEType;
    }


    public void setMEType(Byte mEType) {
        this.mEType = mEType;
    }


    public Long getMEValue1() {
        return this.mEValue1;
    }


    public void setMEValue1(Long mEValue1) {
        this.mEValue1 = mEValue1;
    }


    public Long getMEValue2() {
        return this.mEValue2;
    }


    public void setMEValue2(Long mEValue2) {
        this.mEValue2 = mEValue2;
    }


    public Long getMEValue3() {
        return this.mEValue3;
    }


    public void setMEValue3(Long mEValue3) {
        this.mEValue3 = mEValue3;
    }


    public Byte getMHWType() {
        return this.mHWType;
    }


    public void setMHWType(Byte mHWType) {
        this.mHWType = mHWType;
    }


    public Long getMHWValue1() {
        return this.mHWValue1;
    }


    public void setMHWValue1(Long mHWValue1) {
        this.mHWValue1 = mHWValue1;
    }


    public Long getMHWValue2() {
        return this.mHWValue2;
    }


    public void setMHWValue2(Long mHWValue2) {
        this.mHWValue2 = mHWValue2;
    }


    public Long getMHWValue3() {
        return this.mHWValue3;
    }


    public void setMHWValue3(Long mHWValue3) {
        this.mHWValue3 = mHWValue3;
    }


    public Byte getMCWType() {
        return this.mCWType;
    }


    public void setMCWType(Byte mCWType) {
        this.mCWType = mCWType;
    }


    public Long getMCWValue1() {
        return this.mCWValue1;
    }


    public void setMCWValue1(Long mCWValue1) {
        this.mCWValue1 = mCWValue1;
    }


    public Long getMCWValue2() {
        return this.mCWValue2;
    }


    public void setMCWValue2(Long mCWValue2) {
        this.mCWValue2 = mCWValue2;
    }


    public Long getMCWValue3() {
        return this.mCWValue3;
    }


    public void setMCWValue3(Long mCWValue3) {
        this.mCWValue3 = mCWValue3;
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
