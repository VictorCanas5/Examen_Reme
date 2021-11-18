package com.example.calculadora;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.calculadora.Adaptadores.AdaptadorContactos;
import com.example.calculadora.Modelos.Contacto;
import com.example.calculadora.Modelos.Telefono;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista=findViewById(R.id.lista);
        String[] PermisoNecesarios= new String[1];
        PermisoNecesarios[0]= Manifest.permission.CALL_PHONE;

        List<Contacto> l= new ArrayList<>();
        l.add(new Contacto("Victor", new Telefono("201259","871")));
        l.add(new Contacto("Diego", new Telefono("3600176","871")));
        l.add(new Contacto("Cajero", new Telefono("2621333","871")));
        l.add(new Contacto("Victor", new Telefono("201259","871")));

        AdaptadorContactos Ac= new AdaptadorContactos(l);
        lista.setAdapter(Ac);
        RecyclerView.LayoutManager le= new LinearLayoutManager(this);
        lista.setLayoutManager(le);
        lista.setHasFixedSize(true);

        verificarPermiso(PermisoNecesarios);


    }

    private void verificarPermiso(String[] permisoNecesarios) {
    String[] permisoDenegados= new String[1];

        for (int x=0; x<permisoNecesarios.length; x++)
        {
            if (ContextCompat.checkSelfPermission(this,permisoNecesarios[x])== PackageManager.PERMISSION_DENIED){
                permisoDenegados[x]= permisoNecesarios[x];

            }
        }
        requestPermissions(permisoDenegados,300);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case 300:
                if (permissions.length>0){
                    if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        //ejecutar la accion que se iba a hacer

                    }
                    else {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this,permissions[0])){

                        }
                    }
                }
                break;
        }

    }
}