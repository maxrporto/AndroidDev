package com.target.androidaula3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sala01 on 13/09/2017.
 */

public class CustomListAdapter extends BaseAdapter{

    List<Pessoa> pessoas = new ArrayList<>();
    Context context;
    public CustomListAdapter(List<Pessoa> pessoas, Context context) {
        this.pessoas = pessoas;
        this.context = context;
    }

    //itens da view que precisam ser instanciadas
    private  class ViewHolder{
        TextView nome;
        TextView descricao;
        ImageView foto;
        ImageButton botao;

        public ViewHolder(View view){

            nome = (TextView) view.findViewById(R.id.item_nome_dinamico);
            descricao = (TextView) view.findViewById(R.id.item_descricao_dinamico);
            foto = (ImageView) view.findViewById(R.id.item_foto_dinamico);
            botao = (ImageButton) view.findViewById(R.id.item_botao_dinamico);


        }
    }
    @Override
    public int getCount() {
        return pessoas.size(); //retorna total de itens na lista
    }

    @Override
    public Object getItem(int position){
        return pessoas.get(position); //retorna item da lista na posição especificada
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Pessoa pessoa = pessoas.get(position);
        viewHolder.nome.setText(pessoa.get_nome());
        viewHolder.foto.setImageResource(pessoa.getImgRef());
        viewHolder.descricao.setText(pessoa.get_descricao());

        viewHolder.botao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = "teste item " + position;
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            }
        });
        return convertView;
    }

}

