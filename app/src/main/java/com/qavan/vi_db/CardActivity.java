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
    private TextView mElectricityValue1;
    private TextView mElectricityValue2;
    private TextView mElectricityValue3;
    private TextView mHotWaterValue1;
    private TextView mHotWaterValue2;
    private TextView mHotWaterValue3;
    private TextView mColdWaterValue1;
    private TextView mColdWaterValue2;
    private TextView mColdWaterValue3;
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

        mElectricityValue1 = findViewById(R.id.editTextElectricity1);
        mElectricityValue2 = findViewById(R.id.editTextElectricity2);
        mElectricityValue3 = findViewById(R.id.editTextElectricity3);

        mHotWaterValue1 = findViewById(R.id.editTextHotWater1);
        mHotWaterValue2 = findViewById(R.id.editTextHotWater2);
        mHotWaterValue3 = findViewById(R.id.editTextHotWater3);

        mColdWaterValue1 = findViewById(R.id.editTextColdWater1);
        mColdWaterValue2 = findViewById(R.id.editTextColdWater2);
        mColdWaterValue3 = findViewById(R.id.editTextColdWater3);

        mCounterId = findViewById(R.id.textViewCounterIdNumbers);

        mClientId = findViewById(R.id.textViewClientIdNumbers);

        Button bWrite = findViewById(R.id.button);
        bWrite.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "to card for task with id = " + mId);
        if (mTask.getElectricityType() == 1) {

            Long electro1 = mTask.getElectricityValue1();
            if (electro1 != null) mElectricityValue1.setText(String.format("%s", electro1));
        }
        if (mTask.getHotWaterType() == 1) {
            Long hot1 = mTask.getHotWaterValue1();
            if (hot1 != null) mHotWaterValue1.setText(String.format("%s", hot1));
        }
        if (mTask.getColdWaterType() == 1) {
            Long cold1 = mTask.getColdWaterValue1();
            if (cold1 != null) mColdWaterValue1.setText(String.format("%s", cold1));
        }
        mCounterId.setText("украло НЛО");
        mClientId.setText("украло НЛО");
    }

    @Override
    public void onClick(View v) {
        //TODO CHECK ONLY FOR NUMBER
        Long electricity = Long.parseLong(mElectricityValue1.getText().toString());
        Long hotWater = Long.parseLong(mHotWaterValue1.getText().toString());
        Long coldWater = Long.parseLong(mColdWaterValue1.getText().toString());
        mTask.setElectricityValue1(electricity);
        mTask.setHotWaterValue1(hotWater);
        mTask.setColdWaterValue1(coldWater);
        if (electricity > (long) 0 & hotWater > (long) 0 & coldWater > (long) 0 & !electricity.equals((long) 0) & !hotWater.equals((long) 0) & !coldWater.equals((long) 0)) {
            mTask.setStatus((byte) 1);
        } else if (electricity.equals((long) 0) | hotWater.equals((long) 0) | coldWater.equals((long) 0)) {
            mTask.setStatus((byte) 2);
        } else {
            mTask.setStatus((byte) 3);
        }
        mTask.update();
        Log.i(TAG, "updated task with id = " + mId);
        Toast.makeText(this, "Показания записаны", Toast.LENGTH_SHORT).show();
        this.finish();
    }
}
