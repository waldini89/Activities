package com.example.waldo_personal.activities;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText etnombre,ettelefono,etemail,etdescripcion,etfecha;
    private int mYearIni, mMonthIni, mDayIni, sYearIni, sMonthIni, sDayIni;
    static final int DATE_ID = 0;
    Calendar C = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnombre=(EditText)findViewById(R.id.etNombre);
        etfecha=(EditText) findViewById(R.id.etFecha);
        ettelefono=(EditText)findViewById(R.id.etTelefono);
        etemail=(EditText)findViewById(R.id.etEmail);
        etdescripcion=(EditText)findViewById(R.id.etDescripcion);

        sMonthIni = C.get(Calendar.MONTH);
        sDayIni = C.get(Calendar.DAY_OF_MONTH);
        sYearIni = C.get(Calendar.YEAR);
        etfecha = (EditText) findViewById(R.id.etFecha);

        etfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(DATE_ID);
            }
        });

    }

    private void colocar_fecha() {
        etfecha.setText((mMonthIni + 1) + "-" + mDayIni + "-" + mYearIni+" ");
    }



    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYearIni = year;
                    mMonthIni = monthOfYear;
                    mDayIni = dayOfMonth;
                    colocar_fecha();

                }

            };

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYearIni, sMonthIni, sDayIni);


        }


        return null;
    }

    public void onClickSiguiente(View v)
    {
        Intent intent  = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("Nombre", etnombre.getText().toString());
        intent.putExtra("Fecha", etfecha.getText().toString());
        intent.putExtra("Telefono", ettelefono.getText().toString());
        intent.putExtra("Email", etemail.getText().toString());
        intent.putExtra("Descripcion", etdescripcion.getText().toString());
        startActivity(intent);
    }


}
