package com.qavan.vi_db;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AsyncDatabaseUpdater extends AsyncTask<String, Void, List<Task>> {
    private final static String TAG = "ASYNC_DATABASE_UPDATER";

    private List<Task> mRemoteTasks = new ArrayList<>();
    private OkHttpClient mHttpClient = new OkHttpClient();

    @Override
    protected List<Task> doInBackground(String... check) {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n    \"action\":\"cd_points\",\n    \"method\":\"Query\",\n    \"data\":[\n       {\n          \"query\":\"\",\n          \"page\":1,\n          \"start\":0,\n          \"limit\":25\n       }\n    ],\n    \"type\":\"rpc\",\n    \"tid\":9\n }");
        Request request = new Request.Builder()
                .url(check[0])
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("RPC-Authorization", "Token 0LvQvtCz0LjQvTox")
                .build();
        mHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@org.jetbrains.annotations.NotNull Call call, @org.jetbrains.annotations.NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@org.jetbrains.annotations.NotNull Call call, @org.jetbrains.annotations.NotNull Response response) throws IOException {
                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
                String jsonData = Objects.requireNonNull(response.body()).string().replace("[\n  {\n    \"meta\": {", "  {\n    \"meta\": {").replace("\"\n  }\n]", "\"\n  }\n");

                JSONObject Jobject;
                JSONObject Jsonobj;
                JSONArray Jsonarr;

                try {
                    Jobject = new JSONObject(jsonData);
                    Jsonobj = Jobject.getJSONObject("result");
                    Jsonarr = Jsonobj.getJSONArray("records");
                } catch (JSONException e) {
                    Log.i(TAG, "JSONException error while parsing from response");
                    e.printStackTrace();
                    return;
                }
                for (int i = 0; i < Jsonarr.length(); i++) {
                    try {
                        JSONObject currObj = Jsonarr.getJSONObject(i);
                        Task tmpTask = new Task(currObj.get("c_subscr").toString(), currObj.get("c_address").toString(), currObj.get("c_subscr").toString(), currObj.get("d_prev_date").toString(), currObj.get("n_prev_value").toString(), currObj.get("d_current_date").toString(), currObj.get("n_current_value").toString(), Boolean.valueOf(currObj.get("b_done").toString()));
                        mRemoteTasks.add(tmpTask);
                    } catch (JSONException e) {
                        Log.i(TAG, String.format("JSONException error at task [i]=%s", i));
                        e.printStackTrace();
                    }
                }
                Log.i(TAG, String.format("Loaded %s tasks", mRemoteTasks.size()));
                RouteActivity.setTasks(mRemoteTasks);
            }
        });
        return null;
    }

    @Override
    protected void onPostExecute(List<Task> tasks) {
        super.onPostExecute(tasks);
    }
}
