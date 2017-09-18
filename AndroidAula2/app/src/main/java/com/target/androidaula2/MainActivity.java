package com.target.androidaula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textEdit, textBio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEdit = (TextView) findViewById(R.id.id_edit_text);
        textBio = (TextView) findViewById(R.id.id_text_bio);

        textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Main2Activity.class);

                intent.putExtra("tag_bio", textBio.getText().toString());

                //startActivity(intent); apenas envia os dados para outra activity

                startActivityForResult(intent, 101); //requestcod = 101
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 101){
            if(resultCode == RESULT_OK){
                String bio = intent.getStringExtra("new_bio");

                //Log.d("tag_debug", bio);
                textBio.setText(bio);
            }
        }

    }
}
