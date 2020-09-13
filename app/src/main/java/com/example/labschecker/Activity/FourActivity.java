package com.example.labschecker.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.labschecker.R;
import com.example.labschecker.Student;

import java.util.Objects;

public class FourActivity extends AppCompatActivity {
    public Student student;
    static final String AGE_KEY = "AGE";
    static final String ACCESS_MESSAGE="ACCESS_MESSAGE";
    private static  final int REQUEST_ACCESS_TYPE=1;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        textView3 = findViewById(R.id.textView3);
        Bundle arguments = getIntent().getExtras();
        if(arguments!=null){
            Bundle bundle = new Bundle();
            student = arguments.getParcelable(Student.class.getSimpleName());

            TextView textViewName = findViewById(R.id.Name3);
            textViewName.setText(student.getName());

            TextView textViewLastName = findViewById(R.id.LastName3);
            textViewLastName.setText(student.getLastName());

            TextView textViewGroup = findViewById(R.id.Groop3);
            textViewGroup.setText(student.getGroup());

            TextView textViewDate1 = findViewById(R.id.Date1);
            textViewDate1.setText(student.getDate_last_labs());

            TextView textViewDate2 = findViewById(R.id.Date2);
            textViewDate2.setText(student.getDate_protect_other());

            TextView textViewValue = findViewById(R.id.value);
            int res = student.getValue_make_labs() - student.getZach_value();
            textViewValue.setText(Integer.toString(res));


        }
    }
    public void toFirstActivity(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

    public void exit(View view) {
        finishAffinity();

    }

    public void saveFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 7);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==REQUEST_ACCESS_TYPE){
                Toast.makeText(this, String.valueOf(Objects.requireNonNull(data.getData()).getEncodedPath()), Toast.LENGTH_SHORT).show();
                String accessMessage = String.valueOf(Objects.requireNonNull(data.getData()).getEncodedPath());
                textView3.setText(accessMessage);
        }
        else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}