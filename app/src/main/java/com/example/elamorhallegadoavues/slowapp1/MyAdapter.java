package com.example.elamorhallegadoavues.slowapp1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by elamorhallegadoavues on 05/10/2017.
 */

public class MyAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
 /*   ArrayList<Oferta> ofertas;
    Context context = null;

    public MyAdapter(ArrayList<Oferta> amantes, Context context) {
        super();
        this.context = context;
        this.amantes = amantes;
    }



    @Override
    public int getCount() {
        return amantes.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //MyAdapter llama automáticamente al método getView para cargar la lista con información
//Dicho método se va llamar muchas veces (una cada vez que tenga que pintar una posición de la lista)
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = View.inflate(context, R.layout.activity_listado__primero, null);
        TextView tv = (TextView) row.findViewById(R.id.textView);
        TextView tv2 = (TextView) row.findViewById(R.id.textView2);
        tv.setText(amantes.get(position).getNombre());
        tv2.setText(amantes.get(position).getEdadToSring());
        return row;
    }*/
}