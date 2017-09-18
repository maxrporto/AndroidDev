package com.target.androidaula5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void buttonClick(View view){
        // fazer uma Thread Assincrona
        WebGetImageAsync webGetImageAsync = new WebGetImageAsync(this, imageView);

        webGetImageAsync.execute();
    }
}

