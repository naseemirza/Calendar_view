package com.example.naseem.calendar_view;

import android.app.DatePickerDialog;
import android.app.Dialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;

import android.app.usage.UsageEvents;
import android.graphics.Color;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

public class MainActivity extends AppCompatActivity {


    boolean anim = true;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM-yyyy");
    CompactCalendarView calendarView;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = (CompactCalendarView) findViewById(R.id.compactcalendar_view);

        //setting activity title
        getSupportActionBar().setTitle(simpleDateFormat.format(System.currentTimeMillis())+"");

        //adding events
        Event e1 = new Event(Color.GREEN,System.currentTimeMillis()-172800000,"ABSENT");
        Event e2 = new Event(Color.BLUE,System.currentTimeMillis()-(172800000*2),"ABSENT");
        calendarView.addEvent(e1);
        calendarView.addEvent(e2);

        //listner for calender scroll and day click
        calendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                getSupportActionBar().setTitle(simpleDateFormat.format(firstDayOfNewMonth.getTime())+"");
            }
        });
    }


    // calander animation
    public void btn(View v){
        if(!anim){
            calendarView.showCalendarWithAnimation();
        }else{
            calendarView.hideCalendarWithAnimation();
        }
        anim = !anim;
    }

}



