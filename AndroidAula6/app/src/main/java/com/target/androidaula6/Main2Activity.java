package com.target.androidaula6;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.target.androidaula6.json.User;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String json = getIntent().getStringExtra("user_tag");

        User user = new Gson().fromJson(json, User.class);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.textView);

        textView.setText(user.getName().getFirst());

       WebGetImageAsync webGetImageAsync = new WebGetImageAsync(this, user.getPicture().getLarge(), new WebGetImageAsync.GetImageListener() {
            @Override
            public void GetImage(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        });

        webGetImageAsync.execute();
    }
}
