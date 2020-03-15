package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surName;
    EditText height1;
    TextView exc;
    TextView excN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editText1);
        surName=findViewById(R.id.editText2);
        height1=findViewById(R.id.editText3);
        exc=findViewById(R.id.textView4);
        excN=findViewById(R.id.textView6);


    }
    // Метод обработки нажатия на кнопку и перехода на SecondActivity
    public void goToSecondActivity(View v){
        Intent intent=new Intent(this,SecondActivity.class);
        if(name.getText().toString().equals("")){
            excN.setVisibility(View.VISIBLE);
            return;
        }else {
            excN.setVisibility(View.INVISIBLE);

        }
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("surName",surName.getText().toString());
        try {
            int height= Integer.parseInt(height1.getText().toString());
            if(height<110||height>210){
                exc.setVisibility(View.VISIBLE);
                exc.setText(getString(R.string.uncorrectHeight) );
            }else {
                exc.setVisibility(View.INVISIBLE);
                intent.putExtra("height", height);
                startActivity(intent);
            }
        }catch (NumberFormatException e) {
            if (!exc.getText().toString().equals("")) exc.setText(getString(R.string.ecxept));
                else exc.setText(getString(R.string.uncorrectHeight) );
            exc.setVisibility(View.VISIBLE);
        }


    }
}
