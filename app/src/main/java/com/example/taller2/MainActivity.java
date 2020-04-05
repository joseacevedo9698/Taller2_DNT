package com.example.taller2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText nombre, director;
    Spinner spinner_ciudad;
    Button btnGuardar, btnListar, btnCancelar;
    NumberPicker numberPicker;
    Equipo aux;
    ArrayList<Equipo> equipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        numberPicker=findViewById(R.id.numberPicker);
        numberPicker.setMaxValue(23);
        numberPicker.setMinValue(0);
        nombre=(EditText)findViewById((R.id.nombre));
        director=(EditText)findViewById((R.id.director));
        spinner_ciudad=(Spinner) findViewById((R.id.spinner_ciudad));

        equipo = new ArrayList<>();
        btnGuardar=(Button)findViewById((R.id.btnGuardar));
        btnListar=(Button)findViewById((R.id.btnListar));
        btnCancelar=(Button)findViewById((R.id.btnCancelar));





        btnGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(validar()){
                    Toast.makeText(MainActivity.this, "Se guardo correctamente", Toast.LENGTH_SHORT).show();

                    aux = new Equipo();
                    aux.setNombre( nombre.getText().toString() );
                    aux.setDirector( director.getText().toString() );
                    aux.setCiudad( spinner_ciudad.getSelectedItem().toString() );
                    aux.setCampeonatos( numberPicker.getValue() );
                    equipo.add(aux);

                }
            }
        });

        btnListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final Intent intent = new Intent(MainActivity.this,SecundaryActivity.class);
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("lista",equipo);
                intent.putExtra("equipo",aux);
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                /*intent.addCategory(intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*/
            }
        });

    }


    public boolean validar(){
        boolean retorno=true;
        String c1=nombre.getText().toString();
        String c2=director.getText().toString();
        if(c1.isEmpty()){
            nombre.setError("ESTE CAMPO NO PUEDE ESTAR VACIO");
            retorno=false;

        }
        if(c2.isEmpty()){
            director.setError("ESTE CAMPO NO PUEDE ESTAR VACIO");
            retorno=false;
        }
        return retorno;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
