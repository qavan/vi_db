package com.qavan.vi_db;

import org.greenrobot.greendao.query.Query;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

class Utils {
    static Task createDefaultOneTypeSizeTask() {
        String ADDRESS = "HERE IS ADDRESS IN\nTWO LINES";
        String CLIENT = "CLIENT NAME";
        String CLIENT_ID = "CLIENT ID";
        return new Task(CLIENT, ADDRESS, CLIENT_ID, getCurrentDate(), (long) 0, getCurrentDate(), (long) 0, false);
    }

    static void updateTasks(List<Task> tasks, Query<Task> tasksQuery, TaskAdapter mTaskAdapter) {
        tasks = tasksQuery.list();
        mTaskAdapter.setTasks(tasks);
    }

    static int between(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static String getFormattedDMYDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return formatter.format(date);
    }

    public static Date getCurrentDate() {
        return new Date();
    }
}
