package com.example.yasha.sum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    Button Button1;
    EditText opr1, opr2;
    TextView disp;
    int op1;
    int op2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button1 = (Button)findViewById(R.id.Button1);
        opr1 = (EditText) findViewById(R.id.opr1);
        disp = (TextView) findViewById(R.id.disp);
        opr2 = (EditText) findViewById(R.id.opr2);
        //Button1.setOnClickListener(this);


        Button1.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        op2 = Integer.parseInt(opr2.getText().toString());
                        op1 = Integer.parseInt(opr1.getText().toString());
                        op1 = op1 + op2;
                        disp.setText(""+op1);
                        Log.v("EditText",disp.getText().toString());
                    }
                }
        );
    }
}
