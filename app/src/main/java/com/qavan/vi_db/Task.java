package com.qavan.vi_db;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private List<Task> mTasks;

    String mStatus;
    String mTitle;
    String mAddress;
    String mExpireDate;
    String mClient;
    ArrayList<ArrayList[]> mData;


    Task(String status, String title, String address, String expireDate, String client, ArrayList<ArrayList[]> data) {
        this.mStatus = status;
        this.mTitle = title;
        this.mAddress = address;
        this.mExpireDate = expireDate;
        this.mClient = client;
        this.mData = data;
    }


    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getExpireDate() {
        return mExpireDate;
    }

    public void setExpireDate(String mExpireDate) {
        this.mExpireDate = mExpireDate;
    }

    public String getClient() {
        return mClient;
    }

    public void setClient(String mClient) {
        this.mClient = mClient;
    }
}
