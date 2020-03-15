package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv;
    String name;
    String surName;
    int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.textView);
        Bundle value=getIntent().getExtras();
        height=(int)value.get("height");
        name=(String)value.get("name");
        surName=(String)value.get("surName");
        if (value != null) {

            if(height>=110 && height<=150)tv.setText(name+" "+surName+", "+getString(R.string.optimalWeight)+" 50 кг");
            if(height>=151&&height<=180)tv.setText(name+" "+surName+", "+getString(R.string.optimalWeight)+" 70 кг");
            if(height>=181&&height<=210)tv.setText(name+" "+surName+", "+getString(R.string.optimalWeight)+" 90 кг");

        }

    }
}
