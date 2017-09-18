package com.target.androidaula3;

/**
 * Created by sala01 on 13/09/2017.
 */

public class Pessoa {

    String _nome;
    String _descricao;
    int imgRef; // referencia da imagem

    public Pessoa(String _nome, String _descricao, int imgRef) {
        this._nome = _nome;
        this._descricao = _descricao;
        this.imgRef = imgRef;
    }

    public String get_nome() {
        return _nome;
    }

    public void set_nome(String _nome) {
        this._nome = _nome;
    }

    public String get_descricao() {
        return _descricao;
    }

    public void set_descricao(String _descricao) {
        this._descricao = _descricao;
    }

    public int getImgRef() {
        return imgRef;
    }

    public void setImgRef(int imgRef) {
        this.imgRef = imgRef;
    }
}
