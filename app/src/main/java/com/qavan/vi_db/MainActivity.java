package com.qavan.vi_db;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qavan.vi_db.adapter.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ToggleButton.OnClickListener {
    private RecyclerView recyclerView;
    private ToggleButton toggleButton;
    private TaskAdapter adapter;
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new TaskAdapter(tasks, getLayoutInflater());

        tasks = initialize3Tasks();

        recyclerView.setAdapter(adapter);

        toggleButton = findViewById(R.id.idCheckBoxService);
        toggleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Task task = new Task("Взято в работу",
                "Прием показаний от 00.00.0000 00:00",
                "Адрес задания в\n2 строки",
                "Дата по 00.00.000", "Клиент",
                null);
        tasks.add(task);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public List<Task> initialize3Tasks() {
        String STATUS_0 = "Взято в работу";
        String STATUS_1 = "Ожидает";
        String STATUS_2 = "Провалена";
        String TITLE = "Прием показаний от 00.00.0000 00:00";
        String ADDRESS = "Адрес задания в\n2 строки";
        String DATE = "Дата по 00.00.000";
        String CLIENT = "Клиент";
        List<Task> mTasks = new ArrayList<>();
        mTasks.add(new Task(STATUS_0, TITLE, ADDRESS, DATE, CLIENT, null));
        mTasks.add(new Task(STATUS_1, TITLE, ADDRESS, DATE, CLIENT, null));
        mTasks.add(new Task(STATUS_0, TITLE, ADDRESS, DATE, CLIENT, null));
        return mTasks;
    }

}
