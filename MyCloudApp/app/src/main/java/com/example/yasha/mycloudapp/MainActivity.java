package com.example.yasha.mycloudapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button B1;
    EditText Hashtag;
    String sHashtag;
    static String URL = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B1 = (Button)findViewById(R.id.Okbutton);

        //OK button for APIcall
        B1.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        //Search query obtained
                        Hashtag = (EditText)findViewById(R.id.etHashtag);
                        sHashtag = Hashtag.getText().toString();
                        Log.d("-->",sHashtag);
                        ApiCall(sHashtag);
                    }
                }
        );

    }

    //API call using Volley
    public void ApiCall(String hashTag){
        URL = "http://192.168.0.111:5000/wordcloud?query="+hashTag;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        ImageRequest request = new ImageRequest(URL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageBitmap(bitmap);
                        imageView.setVisibility(View.VISIBLE);
                    }
                }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        ImageView imageView = (ImageView) findViewById(R.id.imageView);
                        imageView.setImageResource(R.drawable.image_load_error);
                        imageView.setVisibility(View.VISIBLE);
                    }
                }
        );
        queue.add(request);
    }
}
