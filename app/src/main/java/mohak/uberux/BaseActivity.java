package mohak.uberux;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public abstract class BaseActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mMap;
    Location userLocation;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        MapStyleOptions style = MapStyleOptions.loadRawResourceStyle(
                this, R.raw.maps_style);
        googleMap.setMapStyle(style);

        if (checkPermission())
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {

                            if (location != null) {

                                userLocation = location;

                                CameraPosition cameraPosition = new CameraPosition.Builder()
                                        .target(new LatLng(userLocation.getLatitude(), userLocation.getLongitude()))
                                        .zoom(16)
                                        .build();

//                                MarkerOptions markerOptions = new MarkerOptions()
//                                        .position(new LatLng(userLocation.getLatitude(),userLocation.getLongitude()))
//                                        .icon();

//                                mMap.addMarker(markerOptions);
                                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                            } else {
                                userLocation = null;
                            }
                        }
                    });


    }

    private boolean checkPermission() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Please give location permission", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public Location getUserLocation() {
        if (userLocation != null)
            return userLocation;

        return null;
    }


}
