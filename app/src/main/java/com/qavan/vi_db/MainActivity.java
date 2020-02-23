package com.qavan.vi_db;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qavan.vi_db.adapter.TaskAdapter;

import org.greenrobot.greendao.query.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ToggleButton.OnClickListener {
    private RecyclerView mRecyclerView;
    private ToggleButton mToggleButton;
    private TaskAdapter mTaskAdapter;
    private List<Task> mTasks;

    public TaskDao getmTaskDao() {
        return mTaskDao;
    }

    private TaskDao mTaskDao;
    private Query<Task> tasksQuery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        mTasks = new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mTaskAdapter = new TaskAdapter(mTasks, getLayoutInflater(), this);

        mRecyclerView.setAdapter(mTaskAdapter);

        mToggleButton = findViewById(R.id.idCheckBoxService);
        mToggleButton.setOnClickListener(this);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mTaskDao = daoSession.getTaskDao();

        tasksQuery = mTaskDao.queryBuilder().orderAsc(TaskDao.Properties.Id).build();
        updateTasks();
    }

    @Override
    public void onClick(View v) {
        addTask();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void updateTasks() {
        mTasks = tasksQuery.list();
        mTaskAdapter.setTasks(mTasks);
    }

    public Task createNewTask() {
        String STATUS_0 = "Взято в работу";
        String STATUS_1 = "Ожидает";
        String STATUS_2 = "Провалена";
        String TITLE = "Прием показаний от 00.00.0000 00:00";
        String ADDRESS = "Адрес задания в\n2 строки";
        String DATE = "Дата по 00.00.000";
        String CLIENT = "Клиент";
        return new Task(STATUS_0, TITLE, ADDRESS, DATE, CLIENT);
    }

    public void addTask() {
        Task task = createNewTask();
        mTaskDao.insert(task);
        updateTasks();
    }

    public List<Task> getTasks() {
        return mTasks;
    }
}
