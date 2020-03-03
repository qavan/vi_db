package com.qavan.vi_db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CardActivity extends Activity implements Button.OnClickListener {
    private final String TAG = "CARD_ACTIVITY";
    private Task mCurrentTaskInCard;
    private TextView mTVAddress;
    private TextView mTVClient;
    private TextView mTVPrevDate;
    private TextView mTVPrevValue;
    private TextView mTVCurrentDate;
    private TextView mTVCurrentValue;
    private Long mId;
    private String mAddress;
    private String mClient;
    private String mClientId;
    private Date mPrevDate;
    private Long mPrevValue;
    private Date mCurrentDate;
    private Long mCurrentValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        TaskDao mTaskDao = daoSession.getTaskDao();

        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        mId = getIntent().getExtras().getLong("id");
        mAddress = getIntent().getExtras().getString("address");
        mClient = getIntent().getExtras().getString("client");
        mClientId = getIntent().getExtras().getString("client id");
        //TODO ADD NORMAL CHECK


//        try {
//            Toast.makeText(this, formatter.parse(getIntent().getExtras().getString("prev date")).toString(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, formatter.parse(getIntent().getExtras().getString("current date")).toString(), Toast.LENGTH_SHORT).show();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        try {
//            mPrevDate = formatter.parse(getIntent().getExtras().getString("prev date"));
//            mCurrentDate = formatter.parse(getIntent().getExtras().getString("prev date"));
//        } catch (ParseException e) {
//            Toast.makeText(this, "Ошибка открытия карточки", Toast.LENGTH_SHORT).show();
//        }
        mPrevValue = getIntent().getExtras().getLong("prev date value");
        mCurrentValue = getIntent().getExtras().getLong("current date value");

        mCurrentTaskInCard = mTaskDao.queryBuilder().where(TaskDao.Properties.TaskId.eq(mId)).build().list().get(0);

        Button bWrite = findViewById(R.id.button);
        bWrite.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        EditText ETCurrentValue = findViewById(R.id.idCurrentValueEditText);
        Long value = Long.parseLong(ETCurrentValue.getText().toString());
        if (value > 0) {
            mCurrentTaskInCard.setN_current_value(value);
            mCurrentTaskInCard.update();
            Log.i(TAG, "updated task with id = " + mId);
            Toast.makeText(this, "Показания записаны", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, "Введите правильные показания!", Toast.LENGTH_SHORT).show();
        }
    }
}
