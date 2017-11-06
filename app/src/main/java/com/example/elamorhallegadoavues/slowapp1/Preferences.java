package com.example.elamorhallegadoavues.slowapp1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by elamorhallegadoavues on 02/11/2017.
 */

public class Preferences {
    SharedPreferences sharedpreferences;

    public Preferences(Context context) {
        this.sharedpreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void PreferenceString(String variable, String valor) {
        SharedPreferences.Editor sharedPreferencesEditor = sharedpreferences.edit();
        sharedPreferencesEditor.putString(variable, valor);
        sharedPreferencesEditor.commit();

    }
    public void setPreferenceInt(String variable, int valor) {
        SharedPreferences.Editor sharedPreferencesEditor = sharedpreferences.edit();
        sharedPreferencesEditor.putInt(variable, valor);
        sharedPreferencesEditor.commit();

    }

    public String getPreferenceString(String variable){
        return sharedpreferences.getString(variable,"ERROR");

    }
    public int getPreferenceInt(String variable){
        Log.d("rrrrrrrrrrrrrr", variable);

        sharedpreferences.getInt(variable, -1);
        int valor = sharedpreferences.getInt(variable, -1);
        return valor;
    }


}
