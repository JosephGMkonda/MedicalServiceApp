package com.example.medicalserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {
    EditText edit1,edit2,edit3,edit4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    Button pickDate,pickTime;
    Button BookBtn,Backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.DrTitle);
        edit1 = findViewById(R.id.fullname);
        edit2 = findViewById(R.id.address);
        edit3 = findViewById(R.id.contact);
        edit4 = findViewById(R.id.fees);
        pickDate = findViewById(R.id.pickDate);
        pickTime = findViewById(R.id.Time);

        BookBtn = findViewById(R.id.Book);
        Backbtn = findViewById(R.id.backBtn);

        edit1.setKeyListener(null);
        edit2.setKeyListener(null);
        edit3.setKeyListener(null);
        edit4.setKeyListener(null);

        Intent intent = getIntent();
        String title = intent.getStringExtra("text1");
        String fullname = intent.getStringExtra("text2");
        String address = intent.getStringExtra("text3");
        String contact = intent.getStringExtra("text4");
        String fees = intent.getStringExtra("text5");

        tv.setText(title);
        edit1.setText(fullname);
        edit2.setText(address);
        edit3.setText(contact);
        edit4.setText(fees);

     //Date Picker
        initDatePicker();
        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog.show();
            }
        });

        initTimePicker();
        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

        //back button
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this, DoctorDetailsActivity.class));
            }
        });

        //Book Appointment
        BookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetLister = new DatePickerDialog.OnDateSetListener(){
         @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2){
             i1 = i1 + 1;
            pickDate.setText(i2+"/"+i1+"/"+i2);

         }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_DARK;
        datePickerDialog = new DatePickerDialog(this,style,dateSetLister,year,month,day);
        datePickerDialog.getDatePicker().setMaxDate(cal.getTimeInMillis() + 8640000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker timePicker,int i, int i1){
                pickTime.setText(i+":"+i1);

            }

        };
        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR);
        int min = cal.get(Calendar.MINUTE);

        int style = AlertDialog.THEME_HOLO_DARK;
        timePickerDialog = new TimePickerDialog(this,style,timeListener,hrs,min,true);

    }
}