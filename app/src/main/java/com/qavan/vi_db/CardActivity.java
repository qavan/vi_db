package com.qavan.vi_db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CardActivity extends Activity implements Button.OnClickListener {
    private final String TAG = "CARD_ACTIVITY";
    private Task mTask;
    private String mId;
    private TaskDao mTaskDao;

    private TextView mElectricity;
    private TextView mHotWater;
    private TextView mColdWater;
    private TextView mCounterId;
    private TextView mClientId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        mTaskDao = daoSession.getTaskDao();

        mId = getIntent().getExtras().getString("ID");

        mTask = mTaskDao.queryBuilder().where(TaskDao.Properties.Id.eq(mId)).build().list().get(0);

        mElectricity = findViewById(R.id.editText);
        mHotWater = findViewById(R.id.editText2);
        mColdWater = findViewById(R.id.editText3);
        mCounterId = findViewById(R.id.textViewCounterIdNumbers);
        mClientId = findViewById(R.id.textViewClientIdNumbers);

        Button bWrite = findViewById(R.id.button);
        bWrite.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "to card for task with id = " + mId);
        mElectricity.setText(String.format("%s", mTask.getMEValue1()));
        mHotWater.setText(String.format("%s", mTask.getMHWValue1()));
        mColdWater.setText(String.format("%s", mTask.getMCWValue1()));
        mCounterId.setText("украло НЛО");
        mClientId.setText("украло НЛО");
    }

    @Override
    public void onClick(View v) {
        mTask.setMEValue1(Long.parseLong(mElectricity.getText().toString()));
        mTask.setMHWValue1(Long.parseLong(mHotWater.getText().toString()));
        mTask.setMCWValue1(Long.parseLong(mColdWater.getText().toString()));
        mTask.update();
        Log.i(TAG, "updated task with id = " + mId);
    }
}
