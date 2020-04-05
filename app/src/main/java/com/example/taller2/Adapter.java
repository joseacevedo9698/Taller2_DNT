package com.example.taller2;

import android.content.Context;
import android.view.*;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


public class Adapter extends  ArrayAdapter<Equipo> {
    private Context context;
    private ArrayList<Equipo>listItems;
    private int resourceLayout;

    public Adapter(Context context, int resource, ArrayList<Equipo> listItems) {
        super( context, resource, listItems);
        this.context = context;
        this.listItems = listItems;
        this.resourceLayout = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view =convertView;
        String nombre=getItem( position ).getNombre();
        String director=getItem( position ).getDirector();
        String  ciudad=getItem( position ).getCiudad();
        int campeonatos=getItem( position ).getCampeonatos();
        String campeon = String.valueOf(campeonatos);

        if (view == null)
            view = LayoutInflater.from(context).inflate(resourceLayout,null);

        TextView txtnombre= (TextView)view.findViewById(R.id.txtnombre);
        TextView txtdirector=(TextView)view.findViewById(R.id.txtdirector);
        TextView txtciudad=(TextView)view.findViewById(R.id.txtciudad);
        TextView txtcampeonatos=(TextView)view.findViewById(R.id.txtcampeonatos);

        txtnombre.setText(nombre);
        txtdirector.setText(director);
        txtciudad.setText(ciudad);
        txtcampeonatos.setText(campeon);


        return view;
    }
}