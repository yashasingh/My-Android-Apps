package com.example.yasha.custom_listview;

/*import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgName;

    public static int prgmImages []= {R.drawable.images1,R.drawable.images2,R.drawable.images2 };
    public static String [] prgmNameList={"","",""};
    context = this;

    lv=(ListView) findViewById(R.id.listView);
    lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.c,R.drawable.cplus,R.drawable.jva,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c,R.drawable.c};
    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(android.,menu);
        return true;
    }

}