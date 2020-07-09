package com.example.contact;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewContactFragment extends Fragment {
    private static final String TAG = "ViewContactsFragments";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: view started");
        View view = inflater.inflate(R.layout.fragment_viewcontacts, container,false);

        // Navegar ate add contacts
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked fab.");
            }
        });

        ImageView ivSearchContact = (ImageView) view.findViewById((R.id.ivSearchIcon));
        ivSearchContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked search icon.");
            }
        });

        return view;

    }
}