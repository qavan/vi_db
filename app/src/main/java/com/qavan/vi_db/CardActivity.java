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


public class CardActivity extends Activity implements Button.OnClickListener {
    private static final String TAG = "CARD_ACTIVITY";

    private TaskDao mTaskDao;
    private Task mCurrentTaskInCard;
    private TextView mETClient;
    private TextView mETClientId;
    private TextView mETAddress;
    private TextView mTVPrevDate;
    private TextView mTVCurrentDate;
    private TextView mTVPrevValue;
    private EditText mTVCurrentValue;
    private Long mId;
    private String mAddress;
    private String mClient;
    private String mClientId;
    private String mPrevDate;
    private String mCurrentDate;
    private String mPrevValue;
    private String mCurrentValue;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        DaoSession daoSession = ((App) getApplication()).getDaoSession();

        mTaskDao = daoSession.getTaskDao();

        mETClientId = findViewById(R.id.idClientIdEditText);
        mETClient = findViewById(R.id.idClientEditText);
        mETAddress = findViewById(R.id.idAddressEditText);
        mTVPrevDate = findViewById(R.id.idPrevDateTextView);
        mTVPrevValue = findViewById(R.id.idPrevValueEditText);
        mTVCurrentDate = findViewById(R.id.idСurrentDateTextView);
        mTVCurrentValue = findViewById(R.id.idCurrentValueEditText);

        Button bWrite = findViewById(R.id.button);
        bWrite.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mId = getIntent().getExtras().getLong("id");
        mCurrentTaskInCard = mTaskDao.queryBuilder().where(TaskDao.Properties.TaskId.eq(mId)).build().list().get(0);
        mAddress = mCurrentTaskInCard.getC_address();
        mClient = mCurrentTaskInCard.getC_client();
        mClientId = mCurrentTaskInCard.getC_client_id();
        mPrevDate = mCurrentTaskInCard.getD_prev_date();
        mCurrentDate = mCurrentTaskInCard.getD_current_date();
        mPrevValue = mCurrentTaskInCard.getN_prev_value();
        mCurrentValue = mCurrentTaskInCard.getN_current_value();
        if (mPrevDate == null) {
            Toast.makeText(this, "Даты отсутствуют mPrevDate", Toast.LENGTH_LONG).show();
        } else if (mCurrentDate == null) {
            Toast.makeText(this, "Даты отсутствуют mCurrentDate", Toast.LENGTH_LONG).show();
        }

        mETClientId.setText(mCurrentTaskInCard.getC_client_id());
        mETClient.setText(mCurrentTaskInCard.getC_client());
        mETAddress.setText(mCurrentTaskInCard.getC_address());

        System.out.println(mCurrentTaskInCard.getD_prev_date());

        mTVPrevDate.setText(String.format("Предыдущее от %s", Utils.getFormattedDateDDMMYY(Utils.getJavaMainFormattedDate(mCurrentTaskInCard.getD_prev_date()))));
        mTVCurrentDate.setText(String.format("   Текущее от %s", Utils.getFormattedDateDDMMYY(Utils.getJavaMainFormattedDate(mCurrentTaskInCard.getD_current_date()))));
        mTVPrevValue.setText(mCurrentTaskInCard.getN_prev_value());
        mTVCurrentValue.setText(mCurrentTaskInCard.getN_current_value());
    }

    @Override
    public void onClick(View v) {
        if (false) {
            Log.i(TAG, "updated task with id = " + mId);
            Toast.makeText(this, "Показания записаны", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {
            Toast.makeText(this, "Введите правильные показания!", Toast.LENGTH_SHORT).show();
        }
    }
}
