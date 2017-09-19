package com.target.androidaula6;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.target.androidaula6.json.User;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomListAdapter extends BaseAdapter {

    List<User> users = new ArrayList<>();
    List<Bitmap> bitmaps = new ArrayList<>();

    Context context;
    public CustomListAdapter(List<User> userss, List<Bitmap> bitmaps, Context context) {
        this.users = userss;
        this.context = context;
        this.bitmaps = bitmaps;
    }

    //itens da view que precisam ser instanciadas
    private  class ViewHolder{
        TextView nome;
        CircleImageView foto;
        //ImageButton botao;

        public ViewHolder(View view){

            nome = (TextView) view.findViewById(R.id.item_userss_nome);
            foto = (CircleImageView) view.findViewById(R.id.item_userss);
            //botao = (ImageButton) view.findViewById(R.id.item_botao_dinamico);
        }
    }
    @Override
    public int getCount() {
        return users.size(); //retorna total de itens na lista
    }

    @Override
    public Object getItem(int position){
        return users.get(position); //retorna item da lista na posição especificada
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        ViewHolder viewHolder;

        //verifica se ainda esta na memória
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.fragment_amigos, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        User user = users.get(position);

        viewHolder.nome.setText(user.getName().getFirst());
        //viewHolder.foto.setImageBitmap(user.getBitmap());
        //viewHolder.foto.setImageResource(users.getImgFoto());
        viewHolder.foto.setImageBitmap(bitmaps.get(position));
        return convertView;
    }
}
