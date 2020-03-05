package com.qavan.vi_db;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;


public class RouteActivity extends Activity {
    private static final String TAG = "ROUTE_ACTIVITY";
    private static final String RPC_SERVER_ADDRESS = "http://kes.it-serv.ru/voice/rpc";

    private static List<Task> mTasks;
    private static TaskAdapter mTaskAdapter;
    private static TaskDao mTaskDao;
    private static Query<Task> mTasksQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        mTasks = new ArrayList<>();
        Log.i(RouteActivity.TAG, String.valueOf(mTasks.size()));
        mTaskAdapter = new TaskAdapter(mTasks, getLayoutInflater(), this);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTaskAdapter);

        final Button mSyncWithServer = findViewById(R.id.idSyncRPCServerToClientButton);
        mSyncWithServer.setOnClickListener(asyncLoadFromServer);

        final Button mSyncWithClient = findViewById(R.id.idSyncClientToRPCServerButton);
        mSyncWithClient.setOnClickListener(asyncUploadToServer);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mTaskDao = daoSession.getTaskDao();
        mTasksQuery = mTaskDao.queryBuilder().orderAsc(TaskDao.Properties.TaskId).build();

        Utils.updateTasks(mTasks, mTasksQuery, mTaskAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Utils.getPermission(this, getApplicationContext(), Manifest.permission.INTERNET);

        Utils.updateTasks(mTasks, mTasksQuery, mTaskAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Utils.getPermission(this, getApplicationContext(), Manifest.permission.INTERNET);

        Utils.updateTasks(mTasks, mTasksQuery, mTaskAdapter);
    }

    Button.OnClickListener asyncLoadFromServer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncDatabaseRPCServerToClient aTask = new AsyncDatabaseRPCServerToClient();
            aTask.execute(RPC_SERVER_ADDRESS);
            Utils.updateTasks(mTasks, mTasksQuery, mTaskAdapter);
        }
    };

    Button.OnClickListener asyncUploadToServer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncDatabaseClientToRPCServer aTask = new AsyncDatabaseClientToRPCServer();
            aTask.execute(RouteActivity.getTasks());
        }
    };


    public Context getContext() {
        return getApplicationContext();
    }

    public static void setTasks(List<Task> tasks) {
        if (mTasks.size() != tasks.size()) {
            mTasks = tasks;
            for (Task task : tasks) {
                mTaskDao.insert(task);
            }
            Log.i(RouteActivity.TAG, String.format("Got and synced %s tasks", mTasks.size()));
        } else
            Log.i(RouteActivity.TAG, "Tasks already synced");
    }

    public static List<Task> getTasks() {
        return mTasksQuery.list();
    }
}
