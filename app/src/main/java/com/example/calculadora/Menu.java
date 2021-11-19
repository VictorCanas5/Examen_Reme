package com.example.calculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.calculadora.Adaptadores.AdaptadorOpciones;
import com.example.calculadora.Modelos.Opcion;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    RecyclerView menu;
    String url="https://www.google.com/";
    String urlm="https://www.google.com.mx/maps/preview";
    Intent c= new Intent(Menu.this, MainActivity.class);
    Uri _link= Uri.parse(url);
    Intent n = new Intent(Intent.ACTION_VIEW, _link);
    Intent d = new Intent(Intent.ACTION_DIAL);
    Uri _link2= Uri.parse(urlm);
    Intent m = new Intent(Intent.ACTION_VIEW, _link2);

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu= findViewById(R.id.opcionM);

        List<Opcion> lista= new ArrayList<>();
       lista.add(new Opcion(c));
        lista.add(new Opcion(n));
        lista.add(new Opcion(d));
        lista.add(new Opcion(m));



        AdaptadorOpciones ap= new AdaptadorOpciones(lista);
        RecyclerView.LayoutManager opes= new LinearLayoutManager(this);
        menu.setAdapter(ap);
        menu.setLayoutManager(opes);
        menu.setHasFixedSize(true);





    }


}