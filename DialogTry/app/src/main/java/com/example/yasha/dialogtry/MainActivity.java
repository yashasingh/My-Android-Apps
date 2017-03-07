package com.example.yasha.dialogtry;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Dialog dialog;
    boolean q,w,e,r;
    CheckBox a,b,c,d;
    Button x,y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.anything);
        dialog.setTitle("My title!");
        a = (CheckBox)dialog.findViewById(R.id.cb1);
        b = (CheckBox)dialog.findViewById(R.id.cb2);
        c = (CheckBox)dialog.findViewById(R.id.cb3);
        d = (CheckBox)dialog.findViewById(R.id.cb4);
        x = (Button)dialog.findViewById(R.id.b1);
        y = (Button)dialog.findViewById(R.id.b2);
        dialog.show();
        x.setOnClickListener(this);
        y.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.b1) {
            dialog.dismiss();
        }
        else if (v.getId() == R.id.b2) {
            q = a.isChecked();
            w = b.isChecked();
            e = c.isChecked();
            r = d.isChecked();
            Log.d("---->", String.valueOf(q)+String.valueOf(w)+String.valueOf(e)+String.valueOf(r));
            dialog.dismiss();
        }
    }
}
