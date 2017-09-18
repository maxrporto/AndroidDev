package com.target.androidaula4;

import android.graphics.Bitmap;

public class Amigo {

    private String _nome;
    private int imgFoto; // referencia da imagem
    private Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Amigo(String _nome, int imgFoto) {
        this._nome = _nome;
        this.imgFoto = imgFoto;
    }

    public Amigo(String _nome, Bitmap bitmap) {
        this._nome = _nome;
        this.bitmap = bitmap;
    }

    public String get_nome() {
        return _nome;
    }

    public void set_nome(String _nome) {
        this._nome = _nome;
    }


    public int getImgFoto() {
        return imgFoto;
    }

    public void setImgFoto(int imgRef) {
        this.imgFoto= imgRef;
    }
}
