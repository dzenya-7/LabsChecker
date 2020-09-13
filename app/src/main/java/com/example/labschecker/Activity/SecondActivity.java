package com.example.labschecker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labschecker.R;
import com.example.labschecker.Student;
import com.example.labschecker.StudentBuilder;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

    public Student student;
    public Student student1;
    TextView textView;
    Calendar dateAndTime= Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle arguments = getIntent().getExtras();
        textView = findViewById(R.id.textView2);
        if(arguments!=null){
            Bundle bundle = new Bundle();
            student = arguments.getParcelable(Student.class.getSimpleName());
            TextView textViewName = findViewById(R.id.Name);
            String s = student.getName();
            textViewName.setText(s);
            TextView textViewLastName = findViewById(R.id.LastName);
            textViewLastName.setText(student.getLastName());
            TextView textViewGroop = findViewById(R.id.Groop);
            textViewGroop.setText(student.getGroup());

        }
    }

    public void toThirdActivity(View view) {
        if(student.getDate_protect_other()==null){
            callDialog(findViewById(R.id.button));
        }
        else {
            startActivity(new Intent(this,ThirdActivity.class).putExtra(Student.class.getSimpleName(),student));
        }
    }

    public void callDialog(View v) {
        new DatePickerDialog(SecondActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }
    public void setDate() {
        String s = DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME);
        student = new StudentBuilder(student).setDateProtectOther(s).make();
    }



    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setDate();
        }
    };


}