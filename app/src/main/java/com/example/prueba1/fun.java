package com.example.prueba1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class fun extends Fragment {
    private View viewFun;
    private Handler handlerTracking = new Handler();


    public fun() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewFun = inflater.inflate(R.layout.fragment_fun, container, false);
        setHasOptionsMenu(true);

        IniciarFun.run();

        final Button btnProceso = viewFun.findViewById(R.id.buttonProceso);
        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnProceso.getText().equals("Parar Prueba")){
                    ((EditText) viewFun.findViewById(R.id.etfunresult)).setText("Prueba Detenida");
                    btnProceso.setText("Iniciar Prueba");
                    handlerTracking.removeCallbacks(IniciarFun);
                }else{
                    btnProceso.setText("Parar Prueba");
                    IniciarFun.run();
                }
            }
        });


        return viewFun;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
    }


    private Runnable IniciarFun = new Runnable () {
        @Override
        public void run() {
            CalcularFun(50,30);
            handlerTracking.postDelayed(this, 1000);
        }
    };


    public void CalcularFun(int x, int y) {
        EditText etfunresult = viewFun.findViewById(R.id.etfunresult);
        etfunresult.setText("El Resultado Es: " + String.valueOf(x+y));
    }




}
