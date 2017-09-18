package com.target.androidaula3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Max Porto", "Descrição 1", R.drawable.downloadimg));
        pessoas.add(new Pessoa("João Vitor", "Descrição 2", R.drawable.imginstagram));
        pessoas.add(new Pessoa("Ana Paula", "Descrição 3", R.drawable.downloadimg));
        pessoas.add(new Pessoa("Sandro", "Descrição 4", R.drawable.imginstagram));


        ListView  list = (ListView) findViewById(R.id.listview);
        list.setAdapter(new CustomListAdapter(pessoas, this));

       // list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        //    @Override
        //    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
         //       Toast.makeText(getBaseContext(), "Show ", Toast.LENGTH_LONG).show();
         //   }
        //});

        GridView grid = (GridView) findViewById(R.id.grid_View);
        grid.setAdapter(new CustomListAdapter(pessoas, this));
    }
}
