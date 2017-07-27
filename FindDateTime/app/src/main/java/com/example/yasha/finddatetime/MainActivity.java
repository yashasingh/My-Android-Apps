package com.example.yasha.finddatetime;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar c = Calendar.getInstance();                  //
        System.out.println("Current time =>"+c.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //
        String formattedDate = df.format(c.getTime());  //
        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT);

        TextView txtView = new TextView(this);
        txtView.setText(formattedDate);
        txtView.setTextSize(20);
        setContentView(txtView);
    }
}
