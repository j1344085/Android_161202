package com.example.ryun.chronometer;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2;
    RadioButton rbtn1, rbtn2;
    RadioGroup rgroup;
    Chronometer cro1;
    CalendarView calen1;
    TimePicker tp1;
    TextView text1;
    int year=-1;
    int mon=-1;
    int day=-1;
    int hour=-1;
    int min=-1;
    int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*setTitle("시간 예약");*/

        rgroup = (RadioGroup)findViewById(R.id.rgroup);
        calen1 = (CalendarView)findViewById(R.id.calendarView);
        tp1 = (TimePicker)findViewById(R.id.timePicker);
        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button3);
        rbtn1 = (RadioButton)findViewById(R.id.radioButton);
        rbtn2 = (RadioButton)findViewById(R.id.radioButton2);
        cro1 = (Chronometer)findViewById(R.id.chronometer2);
        text1 = (TextView)findViewById(R.id.textView);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag==0) flag=1;
                else if (flag==1) { Toast.makeText(getApplicationContext(),"예약을 해주세요 :)",Toast.LENGTH_SHORT).show(); return; }
                cro1.setBase(SystemClock.elapsedRealtime());
                cro1.start();
                cro1.setTextColor(Color.RED);
            }
        });


        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId==R.id.radioButton) { calen1.setVisibility(View.VISIBLE); tp1.setVisibility(View.GONE); }
                else if(checkedId==R.id.radioButton2) { tp1.setVisibility(View.VISIBLE); calen1.setVisibility(View.GONE); }
            }
        });

        calen1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                year=i; mon=i1; day=i2;
            }
        });

        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour=i; min=i1;
            }
        });

    }
}
