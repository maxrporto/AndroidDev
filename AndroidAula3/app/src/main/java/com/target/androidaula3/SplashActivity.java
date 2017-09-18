package com.target.androidaula3;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by sala01 on 13/09/2017.
 */

public class SplashActivity extends Activity {
    @Override
    public  void onStart(){
        super.onStart();

        //qq código pra iniciar aqui

        startActivity(new Intent(this, MainActivity.class));
        finish(); // remmove da memoria
    }
}
