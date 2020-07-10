package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.contact.Utils.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");
        initImageLoader();
        init();
    }
    private void init(){

        //primeiro fragment
        ViewContactFragment fragment = new ViewContactFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //Substitui o que esta no container fragment com o fragment atribuido
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); //retorna para o stack quando utiliza voltar
        transaction.commit();
    }
    // Inicializa o imageloader para não dar crash no onCreate do ViewContactFragment

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(MainActivity.this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
}