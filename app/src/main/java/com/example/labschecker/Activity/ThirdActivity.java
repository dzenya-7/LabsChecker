package com.example.labschecker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.labschecker.R;
import com.example.labschecker.Student;
import com.example.labschecker.StudentBuilder;

import java.util.Calendar;

public class ThirdActivity extends AppCompatActivity {

    public Student student;
    Calendar dateAndTime= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            Bundle bundle = new Bundle();
            student = arguments.getParcelable(Student.class.getSimpleName());
            TextView textViewName = findViewById(R.id.Name2);
            String s = student.getName();
            textViewName.setText(s);
            TextView textViewLastName = findViewById(R.id.LastName2);
            textViewLastName.setText(student.getLastName());
            TextView textViewGroup = findViewById(R.id.Groop2);
            textViewGroup.setText(student.getGroup());

        }
    }

    public void setDate() {
        String s = DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        );
        student = new StudentBuilder(student).setDateLastLabs(s).make();
    }



    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setDate();
        }
    };

    public void callDateOfOtherZachDialog(View view) {
        new DatePickerDialog(ThirdActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    public void toFourActivity(View view) {

        if(student.getDate_last_labs()==null){
            callDateOfOtherZachDialog(findViewById(R.id.button4));
        }
        else {
            startActivity(new Intent(this,FourActivity.class).putExtra(Student.class.getSimpleName(),student));
        }
    }

}