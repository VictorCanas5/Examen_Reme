package com.example.calculadora;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button contactos;
    Button navegador;
    Button dialer;
    Button mapa;
    String url="https://www.google.com/";
    String urlm="https://www.google.com.mx/maps/preview";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        contactos=(Button) findViewById(R.id.esContactos);
        navegador=(Button) findViewById(R.id.abrirnav);
        dialer=(Button)findViewById(R.id.dialer);
        mapa=(Button)findViewById(R.id.mapa);

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link= Uri.parse(urlm);
                Intent m = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(m);
            }
        });

        dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent d = new Intent(Intent.ACTION_DIAL);
                    startActivity(d);
            }
        });


        navegador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri _link= Uri.parse(url);
                Intent n = new Intent(Intent.ACTION_VIEW, _link);
                startActivity(n);

            }
        });

        contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent c= new Intent(Menu.this, MainActivity.class);
                startActivity(c);
            }
        });

    }
}