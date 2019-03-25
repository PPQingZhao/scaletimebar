package com.xplay.pp.scaletimebar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xplay.pp.scaletimebar.timebar.ScaleModel;
import com.xplay.pp.scaletimebar.timebar.ScaleTimeBar;
import com.xplay.pp.scaletimebar.timebar.SmallTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    private TextView main_tv_show;
    private ScaleTimeBar main_scaletimebar;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private ScaleTimeBar main_scaletimebar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTimebar1();
        initTimebar2();
    }

    private void initView() {
        main_tv_show = findViewById(R.id.main_tv_show);
        main_scaletimebar = findViewById(R.id.main_scaletimebar);
        main_scaletimebar2 = findViewById(R.id.main_scaletimebar2);
    }

    private void initTimebar2() {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2019);
        instance.set(Calendar.MONTH, 5);
        instance.set(Calendar.DATE, 1);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        long startTime = instance.getTimeInMillis();
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);
        long endTime = instance.getTimeInMillis();
        ArrayList<SmallTime> smallTimes = new ArrayList<>();
        SmallTime smallTime = null;
        long time_1_50 = (endTime - startTime) / 100;
        for (int i = 0; i < 100; i++) {
            smallTime = new SmallTime();
            smallTime.setStartValue(startTime + time_1_50 * i);
            smallTime.setEndValue(startTime + time_1_50 * (i + 1));
            if (i % 5 == 0) {
                smallTime.setTimeColor(Color.RED);
            } else if (i % 4 == 0) {
                smallTime.setTimeColor(Color.BLUE);
            } else if (i % 3 == 0) {
                smallTime.setTimeColor(Color.GREEN);
            } else if (i % 2 == 0) {
                smallTime.setTimeColor(Color.YELLOW);
            } else {
                smallTime.setTimeColor(Color.LTGRAY);
            }
            smallTimes.add(smallTime);
        }
        //设置刻度最小值(默认当天0点毫秒值)
        main_scaletimebar2.setScaleStartValue(startTime);
        //设置刻度最大值(默认当天23:59:59对应毫秒值)
        main_scaletimebar2.setScaleEndValue(endTime);
        //设置颜色刻度时间戳
        main_scaletimebar2.setSmallTimeList(smallTimes);
        //设置游标时间(当前值)
        main_scaletimebar2.setCurrTime(startTime + 1000 * 60 * 60 * 5);
        //设置一个刻度代表30分钟(默认一个刻度代表５分钟)
        main_scaletimebar2.setModel(ScaleModel.UnitModel.UNITVALUE_30_MIN);
    }

    private void initTimebar1() {
        main_scaletimebar.setOnBarMoveListener(new ScaleTimeBar.OnBarMoveListener() {
            @SuppressLint("SimpleDateFormat")
            @Override
            public void onBarMove(long time) {
//                Log.e("TAG", "**************** onBarMove");
                main_tv_show.setText(simpleDateFormat.format(time));
            }

            @Override
            public void onBarMoveFinish(long time) {
//                Log.e("TAG", "**************** onBarMoveFinish");
                main_tv_show.setText(simpleDateFormat.format(time));
            }
        });

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        long startTime = instance.getTimeInMillis();
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);
        long endTime = instance.getTimeInMillis();

        ArrayList<SmallTime> smallTimes = new ArrayList<>();
        SmallTime smallTime = null;
        long time_1_50 = (endTime - startTime) / 100;
        for (int i = 0; i < 100; i++) {
            smallTime = new SmallTime();
            smallTime.setStartValue(startTime + time_1_50 * i);
            smallTime.setEndValue(startTime + time_1_50 * (i + 1));
            if (i % 5 == 0) {
                smallTime.setTimeColor(Color.RED);
            } else if (i % 4 == 0) {
                smallTime.setTimeColor(Color.BLUE);
            } else if (i % 3 == 0) {
                smallTime.setTimeColor(Color.GREEN);
            } else if (i % 2 == 0) {
                smallTime.setTimeColor(Color.YELLOW);
            } else {
                smallTime.setTimeColor(Color.LTGRAY);
            }
            smallTimes.add(smallTime);
        }
        main_scaletimebar.setScaleStartValue(startTime + 1000 * 60 * 10);
        main_scaletimebar.setScaleEndValue(endTime - 1000 * 60 * 10);
        main_scaletimebar.setSmallTimeList(smallTimes);
        main_scaletimebar.setCurrTime(startTime + 1000 * 60 * 20);
        main_tv_show.setText(simpleDateFormat.format(main_scaletimebar.getTime()));
    }

}
