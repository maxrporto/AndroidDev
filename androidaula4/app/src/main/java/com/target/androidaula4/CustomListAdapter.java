package com.target.androidaula4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomListAdapter extends BaseAdapter {

    List<Amigo> amigos = new ArrayList<>();
    Context context;
    public CustomListAdapter(List<Amigo> amigos, Context context) {
        this.amigos = amigos;
        this.context = context;
    }

    //itens da view que precisam ser instanciadas
    private  class ViewHolder{
        TextView nome;
        CircleImageView foto;
        //ImageButton botao;

        public ViewHolder(View view){

            nome = (TextView) view.findViewById(R.id.item_amigos_nome);
            foto = (CircleImageView) view.findViewById(R.id.item_amigos);
            //botao = (ImageButton) view.findViewById(R.id.item_botao_dinamico);
        }
    }
    @Override
    public int getCount() {
        return amigos.size(); //retorna total de itens na lista
    }

    @Override
    public Object getItem(int position){
        return amigos.get(position); //retorna item da lista na posição especificada
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

        Amigo amigo = amigos.get(position);
        viewHolder.nome.setText(amigo.get_nome());
        viewHolder.foto.setImageBitmap(amigo.getBitmap());
        //viewHolder.foto.setImageResource(amigo.getImgFoto());

        return convertView;
    }
}
