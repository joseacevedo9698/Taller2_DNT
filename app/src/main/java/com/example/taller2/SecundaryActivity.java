package com.example.taller2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;

public class SecundaryActivity extends AppCompatActivity {

    private ListView listView;
    Adapter adapter;
    String nombre;
    ArrayList<Equipo> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);

        listView = (ListView) findViewById(R.id.listView);

        nombre = getIntent().getStringExtra("nombre");
        final Equipo equipo = getIntent().getParcelableExtra("equipo");
        listado = getIntent().getParcelableArrayListExtra("lista");
        adapter = new Adapter(SecundaryActivity.this, R.layout.item_row, listado);
        listView.setAdapter(adapter);
        //registerForContextMenu(listView);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder adb=new AlertDialog.Builder(SecundaryActivity.this);
                final int positionToRemove = position;
                adb.setTitle("Escoge una accion");
                adb.setNegativeButton("EDITAR", new AlertDialog.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MostrarDialog(listado.get(position),position);
                    }
                });
                adb.setPositiveButton("Eliminar", new AlertDialog.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listado.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();

            }
        });
    }

    private void MostrarDialog(final Equipo equipo, final int position) {
        final Dialog dialog = new Dialog(SecundaryActivity.this);
        dialog.setContentView(R.layout.activity_actualizar_datos);
       final  NumberPicker numberPicker=dialog.findViewById(R.id.numberPickerActualizar);
        numberPicker.setMaxValue(23);
        numberPicker.setMinValue(0);
       final EditText nombre=(EditText)dialog.findViewById((R.id.nombreActualizar));
      final EditText director=(EditText)dialog.findViewById((R.id.directorActualizar));
       final Spinner spinner_ciudad=(Spinner) dialog.findViewById((R.id.spinner_ciudadActualizar));
        Button btnActualizar = (Button)dialog.findViewById(R.id.btnActualizar);


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecundaryActivity.this, "Se actualizo correctamente", Toast.LENGTH_SHORT).show();
                equipo.setNombre(nombre.getText().toString());
                equipo.setCampeonatos(numberPicker.getValue());
                equipo.setDirector(director.getText().toString());
                equipo.setCiudad(spinner_ciudad.getSelectedItem().toString());
                listado.set(position,equipo);
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    /*@Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.editar) {


        } else if (id == R.id.eliminar) {

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    listado.remove(position);
                    adapter.notifyDataSetChanged();
                }
            });
            /*
            for (int i = 0; i < listado.size(); i++) {
                Equipo equipo = listado.get(i);
                if (nombre.equals(equipo.getNombre())) {
                    Toast.makeText(this, "Se ha eliminado correctamente", Toast.LENGTH_SHORT).show();
                    listado.remove(i);
                }

            }*/

               // adapter.notifyDataSetChanged();

            //}
        //return super.onContextItemSelected(item);
       // }*/


}

