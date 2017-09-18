package com.target.androidaula4;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sala01 on 14/09/2017.
 */

public class FragmentList extends Fragment {
    ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){

        // especifica qual o layout quer inflar
        return  inflater.inflate(R.layout.fragment_list, viewGroup, false);
    }

    //instancias as views
    @Override
    public void onViewCreated(View view, Bundle saveInstance){
        listView = (ListView) view.findViewById(R.id.list_view);
    }

    // nos garente que a Activity já foi criada
    @Override
    public  void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);

        final List<Amigo> amigos = new ArrayList<>();

    /*
       amigos.add(new Amigo("Max Porto",  R.drawable.perfil));

        amigos.add(new Amigo("João Vitor",  R.drawable.perfil));
        amigos.add(new Amigo("Ana Paula",  R.drawable.perfil));
        amigos.add(new Amigo("Sandro",  R.drawable.perfil));
    */
        final String urls[] = {
                "https://i.pinimg.com/originals/33/b8/69/33b869f90619e81763dbf1fccc896d8d.jpg",
                "http://logok.org/wp-content/uploads/2014/04/Apple-Logo-black.png",
                "http://img.freepik.com/icones-gratis/twitter-logo-botao_318-85053.jpg?size=338c&ext=jpg",
                "http://img.futbox.com/v1/de8/6ff/f64/a7e/54b00d634ee026a8e24c_zoom.png"};

        final String[] nomes = {"homer",
                                "lisa",
                                "bob",
                                "Max"};

        for (int i =0; i< urls.length; i++  ){
            final int index = i;
            WebGetImageAsync webGetImageAsync = new WebGetImageAsync(getContext(), urls[i],
                    new WebGetImageAsync.GetImageListener() {
                        @Override
                        public void GetImage(Bitmap bitmap) {
                            amigos.add(new Amigo(nomes[index], bitmap));

                            if(urls.length -1 == index){
                                listView.setAdapter(new CustomListAdapter(amigos, getContext()));
                            }
                        }
                    });
                webGetImageAsync.execute();
        }

        //ListView  list = (ListView) listView.findViewById(R.id.list_view);
        //

    }
}
