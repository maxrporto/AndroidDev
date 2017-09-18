package com.target.androidaula4;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

// usar support.v4.app.Fragment (é mais modular)
public class FragmentPerfil extends Fragment {

    TextView textView;
    CircleImageView circleImageView;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle){

        // especifica qual o layout quer inflar
        return  inflater.inflate(R.layout.fragment_perfil, viewGroup, false);
    }

    //instancias as views
    @Override
    public void onViewCreated(View view, Bundle saveInstance){
        textView = (TextView) view.findViewById(R.id.perfil_nome);
        //mudar a imagem do perfil pela web
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        circleImageView = (CircleImageView) view.findViewById(R.id.profile_image);
    }

    // nos garente que a Activity já foi criada
    @Override
    public  void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);

        WebGetImageAsync webGetImageAsync = new WebGetImageAsync(getContext(),
                "https://i.pinimg.com/736x/c1/99/c3/c199c32acddc76afedfc90f076500707--adorable-animals-funny-animals.jpg",
                new WebGetImageAsync.GetImageListener() {
                    @Override
                    public void GetImage(Bitmap bitmap) {
                        circleImageView.setImageBitmap(bitmap);

                        //retira o progressbar
                        progressBar.setVisibility(View.GONE);
                    }
                });

        webGetImageAsync.execute();
        textView.setText("Meu Peril");
    }
}
