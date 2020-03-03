package com.qavan.vi_db;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.greendao.query.Query;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RouteActivity extends Activity implements ToggleButton.OnClickListener {
    private TaskAdapter mTaskAdapter;
    private List<Task> mTasks;
    private List<Task> mRemoteTasks;
    private TaskDao mTaskDao;
    private Query<Task> tasksQuery;
    private OkHttpClient mHttpClient;
    private Thread thread;
    private Handler h;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);


        mTasks = new ArrayList<>();
        mRemoteTasks = new ArrayList<>();

        mTaskAdapter = new TaskAdapter(mTasks, getLayoutInflater(), this);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTaskAdapter);

        Button mToggleButton = findViewById(R.id.idAddTaskButton);
        mToggleButton.setOnClickListener(this);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();
        mTaskDao = daoSession.getTaskDao();


        h = new Handler(this.getMainLooper());
        h.post(new Runnable() {
            @Override
            public void run() {
                mHttpClient = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\n    \"action\":\"cd_points\",\n    \"method\":\"Query\",\n    \"data\":[\n       {\n          \"query\":\"\",\n          \"page\":1,\n          \"start\":0,\n          \"limit\":25\n       }\n    ],\n    \"type\":\"rpc\",\n    \"tid\":9\n }");
                Request request = new Request.Builder()
                        .url("http://kes.it-serv.ru/voice/rpc")
                        .method("POST", body)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("RPC-Authorization", "Token 0LvQvtCz0LjQvTox")
                        .addHeader("Authorization", "Basic 0LvQvtCz0LjQvTox")
                        .build();
                mHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        if (!response.isSuccessful())
                            throw new IOException("Unexpected code " + response);

//                            Headers responseHeaders = response.headers();
//                            for (int i = 0, size = responseHeaders.size(); i < size; i++) {
//                                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                            }
                        System.out.println(response.body().string());
                        String jsonData = response.body().string().replace("[\n" +
                                "  {\n" +
                                "    \"meta\": {", "  {\n" +
                                "    \"meta\": {").replace("\"\n" +
                                "  }\n" +
                                "]", "\"\n" +
                                "  }\n");
                        System.out.println(jsonData);

                        JSONObject Jobject;
                        JSONObject Jsonobj = null;
                        JSONArray Jsonarr = null;
                        mRemoteTasks = new ArrayList<>();

                        try {
                            Jobject = new JSONObject(jsonData);
                            Jsonobj = Jobject.getJSONObject("result");
                            Jsonarr = Jsonobj.getJSONArray("records");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        System.out.println(Jsonobj);
                        System.out.println(Jsonarr);
                        for (int i = 0; i < Jsonarr.length(); i++) {
                            try {
                                JSONObject currObj = Jsonarr.getJSONObject(i);
                                Task tmp = new Task(currObj.get("c_subscr").toString(),
                                        currObj.get("c_address").toString(),
                                        currObj.get("c_subscr").toString(),
                                        currObj.get("d_prev_date").toString(),
                                        currObj.get("n_prev_value").toString(),
                                        currObj.get("d_current_date").toString(),
                                        currObj.get("n_current_value").toString(),
                                        currObj.get("b_done").toString());
//                                System.out.println(String.format("%s %s %s", tmp.getC_client(), tmp.getD_prev_date(), tmp.getD_current_date()));
                                mRemoteTasks.add(tmp);
                            } catch (JSONException e) {
                                h.sendEmptyMessage(1);
                                e.printStackTrace();
                            }
                        }
                        h.sendEmptyMessage(1);
                    }
                });
            }
        });
        System.out.println(mRemoteTasks);
        if (mRemoteTasks.size() != 0) {
            mTasks.clear();
            mTasks = mRemoteTasks;
            mTaskDao.deleteAll();
            tasksQuery = mTaskDao.queryBuilder().orderAsc(TaskDao.Properties.TaskId).build();
            Utils.updateTasks(mTasks, tasksQuery, mTaskAdapter);
        }
        mRemoteTasks.clear();
    }

    @Override
    protected void onStart() {
        super.onStart();
        tasksQuery = mTaskDao.queryBuilder().orderAsc(TaskDao.Properties.TaskId).build();
        Utils.updateTasks(mTasks, tasksQuery, mTaskAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Нужны права доступа к интернету!", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, 1);
            return;
        }
//        thread = new Thread(){
//            @Override
//            public void run() {
//                        runOnUiThread(new Runnable() {
//
//                        });
//                Intent mainActivity = new Intent(getApplicationContext(),RouteActivity.class);
//                startActivity(mainActivity);
//            }
//        };
//        thread.start();
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
