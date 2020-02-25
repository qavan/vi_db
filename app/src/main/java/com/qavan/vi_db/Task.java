package com.qavan.vi_db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;


@Entity(active = true, nameInDb = "TASKS_TEST")
public class Task {
    @Id
    private Long TaskId;
    @NotNull
    private Byte Status;
    @NotNull
    private String Title;
    @NotNull
    private String Address;
    @NotNull
    private String ExpireDate;
    @NotNull
    private String Client;
    @NotNull
    private Byte ElectricityType;
    @NotNull
    private Long ElectricityValue1;
    private Long ElectricityValue2;
    private Long ElectricityValue3;
    @NotNull
    private Byte HotWaterType;
    @NotNull
    private Long HotWaterValue1;
    private Long HotWaterValue2;
    private Long HotWaterValue3;
    @NotNull
    private Byte ColdWaterType;
    @NotNull
    private Long ColdWaterValue1;
    private Long ColdWaterValue2;
    private Long ColdWaterValue3;
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
        this.Status = status;
        this.Title = title;
        this.Address = address;
        this.ExpireDate = expireDate;
        this.Client = client;
        this.ElectricityType = electricityType;
        this.ElectricityValue1 = eValue1;
        this.ElectricityValue2 = eValue2;
        this.ElectricityValue3 = eValue3;
        this.HotWaterType = hotWaterType;
        this.HotWaterValue1 = hotWaterValue1;
        this.HotWaterValue2 = hotWaterValue2;
        this.HotWaterValue3 = hotWaterValue3;
        this.ColdWaterType = coldWaterType;
        this.ColdWaterValue1 = coldWaterValue1;
        this.ColdWaterValue2 = coldWaterValue2;
        this.ColdWaterValue3 = coldWaterValue3;
    }


    @Generated(hash = 120659735)
    public Task(Long TaskId, @NotNull Byte Status, @NotNull String Title, @NotNull String Address,
                @NotNull String ExpireDate, @NotNull String Client, @NotNull Byte ElectricityType,
                @NotNull Long ElectricityValue1, Long ElectricityValue2, Long ElectricityValue3,
                @NotNull Byte HotWaterType, @NotNull Long HotWaterValue1, Long HotWaterValue2, Long HotWaterValue3,
                @NotNull Byte ColdWaterType, @NotNull Long ColdWaterValue1, Long ColdWaterValue2,
                Long ColdWaterValue3) {
        this.TaskId = TaskId;
        this.Status = Status;
        this.Title = Title;
        this.Address = Address;
        this.ExpireDate = ExpireDate;
        this.Client = Client;
        this.ElectricityType = ElectricityType;
        this.ElectricityValue1 = ElectricityValue1;
        this.ElectricityValue2 = ElectricityValue2;
        this.ElectricityValue3 = ElectricityValue3;
        this.HotWaterType = HotWaterType;
        this.HotWaterValue1 = HotWaterValue1;
        this.HotWaterValue2 = HotWaterValue2;
        this.HotWaterValue3 = HotWaterValue3;
        this.ColdWaterType = ColdWaterType;
        this.ColdWaterValue1 = ColdWaterValue1;
        this.ColdWaterValue2 = ColdWaterValue2;
        this.ColdWaterValue3 = ColdWaterValue3;
    }


    @Generated(hash = 733837707)
    public Task() {
    }


    public Long getTaskId() {
        return this.TaskId;
    }


    public void setTaskId(Long TaskId) {
        this.TaskId = TaskId;
    }


    public Byte getStatus() {
        return this.Status;
    }


    public void setStatus(Byte Status) {
        this.Status = Status;
    }


    public String getTitle() {
        return this.Title;
    }


    public void setTitle(String Title) {
        this.Title = Title;
    }


    public String getAddress() {
        return this.Address;
    }


    public void setAddress(String Address) {
        this.Address = Address;
    }


    public String getExpireDate() {
        return this.ExpireDate;
    }


    public void setExpireDate(String ExpireDate) {
        this.ExpireDate = ExpireDate;
    }


    public String getClient() {
        return this.Client;
    }


    public void setClient(String Client) {
        this.Client = Client;
    }


    public Byte getElectricityType() {
        return this.ElectricityType;
    }


    public void setElectricityType(Byte ElectricityType) {
        this.ElectricityType = ElectricityType;
    }


    public Long getElectricityValue1() {
        return this.ElectricityValue1;
    }


    public void setElectricityValue1(Long ElectricityValue1) {
        this.ElectricityValue1 = ElectricityValue1;
    }


    public Long getElectricityValue2() {
        return this.ElectricityValue2;
    }


    public void setElectricityValue2(Long ElectricityValue2) {
        this.ElectricityValue2 = ElectricityValue2;
    }


    public Long getElectricityValue3() {
        return this.ElectricityValue3;
    }


    public void setElectricityValue3(Long ElectricityValue3) {
        this.ElectricityValue3 = ElectricityValue3;
    }


    public Byte getHotWaterType() {
        return this.HotWaterType;
    }


    public void setHotWaterType(Byte HotWaterType) {
        this.HotWaterType = HotWaterType;
    }


    public Long getHotWaterValue1() {
        return this.HotWaterValue1;
    }


    public void setHotWaterValue1(Long HotWaterValue1) {
        this.HotWaterValue1 = HotWaterValue1;
    }


    public Long getHotWaterValue2() {
        return this.HotWaterValue2;
    }


    public void setHotWaterValue2(Long HotWaterValue2) {
        this.HotWaterValue2 = HotWaterValue2;
    }


    public Long getHotWaterValue3() {
        return this.HotWaterValue3;
    }


    public void setHotWaterValue3(Long HotWaterValue3) {
        this.HotWaterValue3 = HotWaterValue3;
    }


    public Byte getColdWaterType() {
        return this.ColdWaterType;
    }


    public void setColdWaterType(Byte ColdWaterType) {
        this.ColdWaterType = ColdWaterType;
    }


    public Long getColdWaterValue1() {
        return this.ColdWaterValue1;
    }


    public void setColdWaterValue1(Long ColdWaterValue1) {
        this.ColdWaterValue1 = ColdWaterValue1;
    }


    public Long getColdWaterValue2() {
        return this.ColdWaterValue2;
    }


    public void setColdWaterValue2(Long ColdWaterValue2) {
        this.ColdWaterValue2 = ColdWaterValue2;
    }


    public Long getColdWaterValue3() {
        return this.ColdWaterValue3;
    }


    public void setColdWaterValue3(Long ColdWaterValue3) {
        this.ColdWaterValue3 = ColdWaterValue3;
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
