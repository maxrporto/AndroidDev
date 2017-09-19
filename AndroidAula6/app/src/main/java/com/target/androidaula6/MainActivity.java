package com.target.androidaula6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.target.androidaula6.json.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference  databaseReference;

    List<User> users = new ArrayList<>();
    List<Bitmap> bitmaps = new ArrayList<>();

    ListView listView;
    CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // verifica se tem dados firebase
        database = FireBaseData.getDataBase();
        databaseReference = database.getReference("results");

        listView = (ListView) findViewById(R.id.listview);
        setUsers();

        adapter =  new CustomListAdapter(users, bitmaps, getBaseContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), Main2Activity.class);

                String json = new Gson().toJson(users.get(position));
                intent.putExtra("user_tag", json);

                startActivity(intent);
            }
        });
    }

    private void setUsers(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // achar todos os users
                //DataSnapshot é o objeto pai

                users.clear();
                for(DataSnapshot ds : dataSnapshot.getChildren()){

                   User user = ds.getValue(User.class);

                    users.add(user);

                    WebGetImageAsync webGetImageAsync = new WebGetImageAsync(getBaseContext(),
                                                        user.getPicture().getLarge(),
                                                        new WebGetImageAsync.GetImageListener() {
                        @Override
                        public void GetImage(Bitmap bitmap) {
                            bitmaps.add(bitmap);

                            if(bitmaps.size() == users.size()) {
                                adapter.notifyDataSetChanged();
                            }
                        }
                    });

                    webGetImageAsync.execute();
                }
                //Pega todos os dados de uma vez sem o uso do FOR
                //DataSet dataSet = dataSnapshot.getValue(DataSet.class);
                //String cidade = users.get(1).getLocation().getCity();
                //((TextView) findViewById(R.id.text_firebase)).setText(cidade);

                //listView.setAdapter(new CustomListAdapter(users, getBaseContext()));

               //adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
