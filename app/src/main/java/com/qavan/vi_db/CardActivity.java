package com.qavan.vi_db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CardActivity extends Activity implements Button.OnClickListener {
    private final String TAG = "CARD_ACTIVITY";
    private Task mTask;
    private String mId;
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

        TaskDao mTaskDao = daoSession.getTaskDao();

        mId = getIntent().getExtras().getString("ID");

        mTask = mTaskDao.queryBuilder().where(TaskDao.Properties.TaskId.eq(mId)).build().list().get(0);

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
        mElectricity.setText(String.format("%s", mTask.getElectricityValue1()));
        mHotWater.setText(String.format("%s", mTask.getHotWaterValue1()));
        mColdWater.setText(String.format("%s", mTask.getColdWaterValue1()));
        mCounterId.setText("украло НЛО");
        mClientId.setText("украло НЛО");
    }

    @Override
    public void onClick(View v) {
        Long electricity = Long.parseLong(mElectricity.getText().toString());
        Long hotWater = Long.parseLong(mHotWater.getText().toString());
        Long coldWater = Long.parseLong(mColdWater.getText().toString());
        mTask.setElectricityValue1(electricity);
        mTask.setHotWaterValue1(hotWater);
        mTask.setColdWaterValue1(coldWater);
        if (electricity > 0 && hotWater > 0 && coldWater > 0) {
            mTask.setStatus((byte) 4);
        } else if (electricity > 0 | hotWater > 0 | coldWater > 0) {
            mTask.setStatus((byte) 1);
        }
        mTask.update();
        Log.i(TAG, "updated task with id = " + mId);
        Toast.makeText(this, "Показания записаны", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
