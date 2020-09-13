package com.example.labschecker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.labschecker.R;
import com.example.labschecker.Student;
import com.example.labschecker.StudentBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Student> students;
    EditText editName;
    EditText editLastName;
    EditText editGroop;
    EditText editZachValue;
    EditText editMakeLabs;
    Student student;
    Student student1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = findViewById(R.id.editName);
        editLastName = findViewById(R.id.editLastName);
        editGroop = findViewById(R.id.editGroop);
        editZachValue = findViewById(R.id.editNumberZach);
        editMakeLabs = findViewById(R.id.editMakeLabs);
    }

    public void toSecondActivity(View view) {
        Student student= new Student();
        Student student1 =  new StudentBuilder(student).setLastName(editLastName.getText().toString())
        .setName(editName.getText().toString()).setGroop(editGroop.getText().toString())
                .setZachValue(Integer.parseInt(editZachValue.getText().toString()))
                .setMakeLabs(Integer.parseInt(editMakeLabs.getText().toString())).make();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(Student.class.getSimpleName(),student1);
        startActivity(intent);
    }
}