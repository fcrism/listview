package com.example.contact;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ViewContactFragment extends Fragment {
    private static final String TAG = "ViewContactsFragments";

    private static final int STANDARD_APPBAR = 0;
    private static final int SEARCH_APPBAR = 1;
    private int mAppBarState;

    private AppBarLayout viewContactsBar, searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: view started");

        //Inicialização das views
        View view = inflater.inflate(R.layout.fragment_viewcontacts, container,false);
        viewContactsBar = (AppBarLayout) view.findViewById(R.id.viewContactsToolbar);
        searchBar = (AppBarLayout) view.findViewById(R.id.searchToolbar);
        setAPPBarState(STANDARD_APPBAR);

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
                toggleToolBarState();
            }
        });

        ImageView ivBackArrow = (ImageView) view.findViewById(R.id.ivBackArrow);
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked back arrow.");
                toggleToolBarState();
            }
        });
        return view;

    }
    // alterna estados da barra search
    private void toggleToolBarState() {
        Log.d(TAG, "toggleToolBarState: toggling appbar state");
        if(mAppBarState == STANDARD_APPBAR){
            setAPPBarState(SEARCH_APPBAR);
        } else {
            setAPPBarState(STANDARD_APPBAR);
        }
    }

    private void setAPPBarState(int state) {
        
        Log.d(TAG, "setAPPBarState: Changing app bar state to: " + state);

        mAppBarState = state;

        if(mAppBarState == STANDARD_APPBAR){
            searchBar.setVisibility(View.GONE);
            viewContactsBar.setVisibility(View.VISIBLE);

            // metodo para esconder o teclado
            View view = getView();
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            // exceção caso o teclado já esteja aberto
            try {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (NullPointerException e){
                Log.d(TAG, "setAPPBarState:  NullPointerExecption " + e.getMessage());
            }
        }
        else if(mAppBarState == SEARCH_APPBAR){
            viewContactsBar.setVisibility(View.GONE);
            searchBar.setVisibility(View.VISIBLE);

            // metodo para abrir o teclado
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }

    // Ao sair e voltar do app a barra de busca volta para o estado inicial
    @Override
    public void onResume() {
        super.onResume();
        setAPPBarState(STANDARD_APPBAR);
    }
}