package com.example.elamorhallegadoavues.slowapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener {



    private GoogleApiClient googleApiClient;
    private SignInButton signInButton;
    private int SIGN_IN_CODE;
    String host_register ="http://46.105.28.25:3020";
    GoogleSignInOptions gso;
    int id_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //confirmar si esta logeado
        id_login = new Preferences(getApplicationContext()).getPreferenceInt("texto");
        if (id_login > 0){
            Intent intento = new Intent(this, Navigation_test.class);
            startActivity(intento);
        }

/*         gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("545781173452-h0gsn1g07f6n5et1gjak001qo0ffjtqv.apps.googleusercontent.com")
               // .requestIdToken(this.getResources().getString(R.string.default_web_client_id))
                .requestEmail() //Esta línea es opcional, por si quiero el mail del usuario
                .build();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.PLUS_LOGIN))
                .requestScopes(new Scope(Scopes.PLUS_ME))
                .requestIdToken("545781173452-h0gsn1g07f6n5et1gjak001qo0ffjtqv.apps.googleusercontent.com")

                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                // .addApi(Plus.API, null)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                // .addScope(Plus.SCOPE_PLUS_LOGIN)
                .build();
*/
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();

        signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent,SIGN_IN_CODE);
            }
        });
    }
    // Mirar si los datos estan correctos
    public void Login(View view){
        EditText mail = (EditText) findViewById(R.id.Email);
        EditText password = (EditText) findViewById(R.id.Pass);
        validarLogin(mail,password);
        id_login = new Preferences(getApplicationContext()).getPreferenceInt("texto");
        if(id_login > 0){


            Toast.makeText(this, String.valueOf(id_login),Toast.LENGTH_LONG).show();


        }else if (id_login <= 0){

            //Toast.makeText(this, "HELLO NO BABIES",Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(this, txt,Toast.LENGTH_LONG).show();
    }
    //Registro del usuario
    public void Register(View view){

        Intent in = new Intent(this, Form_register.class);
        startActivity(in);

        //Log.d(email.getText().toString(),password.getText().toString());
        //new MyAsyncTask().execute(host_register);
    }


    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        Log.d("hello1", "hello");
        if(opr.isDone()){
            Log.d("hello2", "hello");
            GoogleSignInResult result = opr.get();
            manejarResult(result);
        }else {
            Log.d("hello3", "hello");
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {


                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    Log.d("hello4", "hello");
                    manejarResult(googleSignInResult);
                }
            });
        }
    }

    private void manejarResult(GoogleSignInResult result) {
        Log.d("hello5", "hello");
        if(result.isSuccess()){
            GoogleSignInAccount account = result.getSignInAccount();
            //String name = account.getEmail();
           //
        }else{

        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SIGN_IN_CODE){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            manejaResultado(result);
        }
    }

    private void manejaResultado( GoogleSignInResult result ){

        if(result.isSuccess()){
           // Toast.makeText(this, "Exito en el Login", Toast.LENGTH_SHORT).show();
            Intent intento = new Intent(this, Navigation_test.class);
            startActivity(intento);
        }else{
            //Toast.makeText(this, "Error en el Login",Toast.LENGTH_SHORT).show();
        }
    }



    // retorna 0 si no encuentra un login correcto
    private void validarLogin(EditText mail,EditText password){
        String peticion = host_register+"/login";
        try{

            new MyAsyncTask(this).execute(peticion,"correo",mail.getText().toString(),"password",password.getText().toString());

            Intent intento = new Intent(this, Navigation_test.class);
            startActivity(intento);
        }catch (Exception e){

        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }


    /*
    public String Concatenar(String... args){
        String cadena = "";
        for(int i = 0; i < args.length-1; i = i +2){
            if (i == 0){
                cadena = "?"+args[i]+"="+args[i+1];
            }else{
                cadena += "&"+args[i]+"="+args[i+1];
            }
        }
        Log.d("Retorno", cadena);
        return cadena;
    }
    */
/*
    @Override
    protected void onPause() {
        super.onPause();
        EditText et = (EditText)findViewById(R.id.editText);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sharedPreferencesEditor = sp.edit();
        sharedPreferencesEditor.putString("texto", et.getText().toString());
        sharedPreferencesEditor.commit();
    }*/
}
