package com.qavan.vi_db;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import org.greenrobot.greendao.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class Utils {
    static Task createDefaultOneTypeSizeTask() {
        String ADDRESS = "HERE IS ADDRESS IN\nTWO LINES";
        String CLIENT = "CLIENT NAME";
        String CLIENT_ID = "CLIENT ID";
        String CURRENT_DATE = getCurrentDate().toString();
        return new Task(CLIENT, ADDRESS, CLIENT_ID, CURRENT_DATE, null, CURRENT_DATE, null, false);
    }

    static void updateTasks(List<Task> tasks, Query<Task> tasksQuery, TaskAdapter mTaskAdapter) {
        tasks = tasksQuery.list();
        mTaskAdapter.setTasks(tasks);
    }

    private static Date getCurrentDate() {
        return new Date();
    }

    public static Date getJavaMainFormattedDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
        try {
            return sdf.parse(date.replace("Z", "").replace("T", "-"));
        } catch (ParseException e) {
            return null;
        }
    }

    public static String getFormattedDateDDMMYY(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    static void getPermission(Activity activity, Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Нужны права доступа к интернету!", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(activity, new String[]{permission}, 1);
        }
    }

    public static void appendTask(TaskDao taskDao, List<Task> tasks, Query<Task> taskQuery, TaskAdapter taskAdapter) {
        Task task = Utils.createDefaultOneTypeSizeTask();
        taskDao.insert(task);
        Utils.updateTasks(tasks, taskQuery, taskAdapter);
    }
}
