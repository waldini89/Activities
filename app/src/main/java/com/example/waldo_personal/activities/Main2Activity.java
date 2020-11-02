package com.example.waldo_personal.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText nombre;
    EditText fecha;
    EditText telefono;
    EditText email;
    EditText descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        String auxnombre = i.getStringExtra("Nombre");
        String auxfecha = i.getStringExtra("Fecha");
        String auxtelefono = i.getStringExtra("Telefono");
        String auxemail = i.getStringExtra("Email");
        String auxdescripcion = i.getStringExtra("Descripcion");

        nombre = (EditText)findViewById(R.id.etNombre);
        fecha = (EditText) findViewById(R.id.etFecha);
        telefono = (EditText)findViewById(R.id.etTelefono);
        email = (EditText)findViewById(R.id.etEmail);
        descripcion = (EditText)findViewById(R.id.etDescripcion);

        nombre.setText(auxnombre);
        fecha.setText(auxfecha);
        telefono.setText(auxtelefono);
        email.setText(auxemail);
        descripcion.setText(auxdescripcion);
    }

    public void onClickEditar(View v)
    {
        Intent intent  = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }
}
