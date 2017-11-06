package com.example.elamorhallegadoavues.slowapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Form_register extends AppCompatActivity {

    String host_register ="http://46.105.28.25:3020";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_register);
    }

    public void Registrarse(View view){
        EditText email = (EditText) findViewById(R.id.Email);
        EditText nombre = (EditText) findViewById(R.id.Name);
        EditText password = (EditText) findViewById(R.id.Pass);
        String peticion = host_register+"/crear";

        Log.d("llego1",peticion);
        new MyAsyncTask(this).execute(peticion,"nombre",nombre.getText().toString(),"password",password.getText().toString(),"email",email.getText().toString());
        Log.d("llego2","traza2");

    }


}
