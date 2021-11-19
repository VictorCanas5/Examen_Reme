package com.example.calculadora.Adaptadores;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.calculadora.Modelos.Contacto;
import com.example.calculadora.Modelos.Opcion;
import com.example.calculadora.R;

import java.util.List;

public class AdaptadorContactos  extends RecyclerView.Adapter<AdaptadorContactos.ViewHolder> {

    private List<Contacto> Lista;
    private List<Opcion> opcion;

    public AdaptadorContactos(List<Contacto> lista) {
        Lista = lista;
    }

    @NonNull
    @Override
    public AdaptadorContactos.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup, false));


    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Contacto c= Lista.get(position);
        viewHolder.bind(c);
    }

    @Override
    public int getItemCount() {
        return Lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView Nombre;
        TextView Telefono;
        Contacto cont;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //asignacion de valores a los textview para actualizarlos
            Nombre=itemView.findViewById(R.id.txt1);
            Telefono=itemView.findViewById(R.id.txt2);

            itemView.setOnClickListener(this);
        }
        public void bind(Contacto c){
            Nombre.setText(c.getNombre());
            Telefono.setText(c.getTel().getNumeroCompleto());
             cont=c;

        }

        @Override
        public void onClick(View view) {

            Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ cont.getTel().getNumeroCompleto()));

            view.getContext().startActivity(i);

        }
    }

}
