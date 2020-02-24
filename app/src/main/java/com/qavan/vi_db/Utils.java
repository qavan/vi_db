package com.qavan.vi_db;

import org.greenrobot.greendao.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

class Utils {
    static Task createDefaultOneTypeSizeTask() {
        String TITLE = "Прием показаний от 01.01.1970 00:00";
        String ADDRESS = "Тут адрес задания в 2 строки, просто поверь мне!";
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String DATE = formatter.format(now);
        String CLIENT = "Физлицо\\Юрлицо";
        return new Task((byte) between(0, 0), TITLE, ADDRESS, DATE, CLIENT,
                (byte) 1, (long) 0, null, null,
                (byte) 1, (long) 0, null, null,
                (byte) 1, (long) 0, null, null);
    }

    static void updateTasks(List<Task> tasks, Query<Task> tasksQuery, TaskAdapter mTaskAdapter) {
        tasks = tasksQuery.list();
        mTaskAdapter.setTasks(tasks);
    }

    static int between(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
