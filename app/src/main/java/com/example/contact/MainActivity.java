package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}