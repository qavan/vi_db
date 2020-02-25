package com.qavan.vi_db;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class RouteActivity extends Activity implements ToggleButton.OnClickListener {
    private TaskAdapter mTaskAdapter;
    private List<Task> mTasks;
    private TaskDao mTaskDao;
    private Query<Task> tasksQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        mTasks = new ArrayList<>();

        mTaskAdapter = new TaskAdapter(mTasks, getLayoutInflater(), this);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTaskAdapter);

        Button mToggleButton = findViewById(R.id.idAddTaskButton);
        mToggleButton.setOnClickListener(this);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mTaskDao = daoSession.getTaskDao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tasksQuery = mTaskDao.queryBuilder().orderAsc(TaskDao.Properties.TaskId).build();
        Utils.updateTasks(mTasks, tasksQuery, mTaskAdapter);
    }

    @Override
    public void onClick(View v) {
        appendTask();
    }

    public void appendTask() {
        Task task = Utils.createDefaultOneTypeSizeTask();
        mTaskDao.insert(task);
        Utils.updateTasks(mTasks, tasksQuery, mTaskAdapter);
    }

    public Context getContext() {
        return this;
    }
}
