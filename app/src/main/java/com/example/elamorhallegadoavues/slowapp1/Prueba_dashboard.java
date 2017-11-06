package com.example.elamorhallegadoavues.slowapp1;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Prueba_dashboard extends AppCompatActivity{
    private GoogleMap mMap;
    private EditText hola;
    Intent home ;
    private TextView mTextMessage;
    private ImageView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_dashboard);

        /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);*/
    }














  /*  public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(41.3863900,2.1687300 );
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in madrid"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

    }
    public void aBuscar(View v){
       // hola = (EditText) findViewById(R.id.dios);
        Log.d("traza",hola.getText().toString());
        getLocationFromAddress(hola.getText().toString());
    }
    public void getLocationFromAddress(String strAddress)
    {
        //Create coder with Activity context - this
        Geocoder coder = new Geocoder(this);
        List<Address> address;

        try {
            //Get latLng from String
            address = coder.getFromLocationName(strAddress,5);

            //check for null
            if (address == null) {
                return;
            }

            //Lets take first possibility from the all possibilities.
            Address location=address.get(0);
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());

            //Put marker on map on that LatLng
            Marker srchMarker = mMap.addMarker(new MarkerOptions().position(latLng).title("Destination").draggable(true));

            //Animate and Zoon on that map location
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
            LatLng sydney = new LatLng(41.3863900,2.1687300 );
            hola = (EditText) findViewById(R.id.dios);
            hola.setText(getDistance(latLng,sydney));


        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String getDistance(LatLng my_latlong, LatLng frnd_latlong) {
        Location l1 = new Location("One");
        l1.setLatitude(my_latlong.latitude);
        l1.setLongitude(my_latlong.longitude);

        Location l2 = new Location("Two");
        l2.setLatitude(frnd_latlong.latitude);
        l2.setLongitude(frnd_latlong.longitude);

        float distance = l1.distanceTo(l2);
        String dist = distance + " M";
        Log.d("traza",dist);
        if (distance > 1000.0f) {
            distance = distance / 1000.0f;
            dist = distance + " KM";
        }
        return dist;
    }
*/


}
