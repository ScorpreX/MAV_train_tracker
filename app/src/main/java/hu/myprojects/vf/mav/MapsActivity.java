package hu.myprojects.vf.mav;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import hu.myprojects.vf.mav.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        List<Address> destinationCityAddressInfo;
        List<Address> startCityAddressInfo;

        String destinationCity = getIntent().getStringExtra(getString(R.string.to));
        String startCity = getIntent().getStringExtra(getString(R.string.from));

        try {
            destinationCityAddressInfo = new Geocoder(this).getFromLocationName(destinationCity, 1);
            startCityAddressInfo = new Geocoder(this).getFromLocationName(startCity, 1);

            double destLatitude = destinationCityAddressInfo.get(0).getLatitude();
            double destLongitude = destinationCityAddressInfo.get(0).getLongitude();

            double startLatitude = destinationCityAddressInfo.get(0).getLatitude();
            double startLongitude = startCityAddressInfo.get(0).getLongitude();

            LatLng destinationCityLatLang = new LatLng(destLatitude, destLongitude);
            LatLng startCityLatLang = new LatLng(startLatitude, startLongitude);


            mMap.addMarker(new MarkerOptions().position(destinationCityLatLang).title(destinationCity));
            mMap.addMarker(new MarkerOptions().position(startCityLatLang).title(startCity));

            mMap.moveCamera(CameraUpdateFactory.zoomTo(6));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(destinationCityLatLang));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}