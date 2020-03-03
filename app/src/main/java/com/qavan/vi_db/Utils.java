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
        String TITLE = "Прием показаний от 01.01.1970 00:00";
        String ADDRESS = "HERE IS ADDRESS IN\nTWO LINES";
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            Date DATE = formatter.parse(now.toString());
            String CLIENT = "CLIENT NAME";
            String CLIENT_ID = "CLIENT ID";
            return new Task(CLIENT, ADDRESS, CLIENT_ID, DATE, (long) 0, DATE, (long) 0, false);
        } catch (ParseException e) {
            Date DATE = now;
            String CLIENT = "CLIENT NAME";
            String CLIENT_ID = "CLIENT ID";
            return new Task(CLIENT, ADDRESS, CLIENT_ID, DATE, (long) 0, DATE, (long) 0, false);
        }
    }

    static void updateTasks(List<Task> tasks, Query<Task> tasksQuery, TaskAdapter mTaskAdapter) {
        tasks = tasksQuery.list();
        mTaskAdapter.setTasks(tasks);
    }

    static int between(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
