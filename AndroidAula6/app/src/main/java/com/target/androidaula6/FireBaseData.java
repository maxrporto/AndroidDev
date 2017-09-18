package com.target.androidaula6;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sala01 on 18/09/2017.
 */

public class FireBaseData {
    static private FirebaseDatabase database;

    public static FirebaseDatabase getDataBase(){

        if(database == null){
            database =  FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }
        return database;
    }
}
