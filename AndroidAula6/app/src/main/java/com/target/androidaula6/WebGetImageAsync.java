package com.target.androidaula6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class WebGetImageAsync extends AsyncTask<String, String, Bitmap> {


    private Context context;
    //private ImageView imageView;
    private String url;
    GetImageListener listener;

    public WebGetImageAsync(Context context, String url, GetImageListener listener){
        this.context = context;
        this.url = url;
        this.listener = listener;
    }

    interface GetImageListener{
        public void GetImage(Bitmap bitmap);
    }


    /*
    public WebGetImageAsync(Context context, ImageView imageView){
        this.context = context;
        this.imageView = imageView;
    }
    */

    //antes da thread começar, prepara o terreno, caos tenha que esperar o retorno de um servidor
    @Override
    public void onPreExecute(){
        super.onPreExecute();

        //normalmente usado pra iniciar os loaders
    }

    /*
    * String... params > é um tipo de conteiner de variaveis, que podem ser acessadas como um array
    * adiciona o código
    * */
    @Override
    public Bitmap doInBackground(String... params){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
                //.url("http://s2.glbimg.com/P5KgolkNoBwEiz9x8wkc__lRFTM=/e.glbimg.com/og/ed/f/original/2017/01/04/radio.jpg")
                //.build();
        Response response = null;
        try{
            response = client.newCall(request).execute();

        }catch (IOException e){e.printStackTrace();}

        //transformar essa respostas
        if(response != null){
            InputStream inputStream = response.body().byteStream();

            return BitmapFactory.decodeStream(inputStream);
        }

        return  null;
    }

    @Override
    public void onPostExecute(Bitmap bitmap){
        if(bitmap != null){

            //Toast.makeText(context, "onPost", Toast.LENGTH_SHORT).show();
            //imageView.setImageBitmap(bitmap);

            listener.GetImage(bitmap);
        }
    }
}
