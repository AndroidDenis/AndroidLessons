package ru.mirea.schukind.d.e.mireaproject;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import ru.mirea.schukind.d.e.mireaproject.databinding.ActivityOpenMapBinding;
import android.graphics.PointF;
import android.os.Bundle;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

import androidx.appcompat.app.AppCompatActivity;

public class OpenMapActivity extends AppCompatActivity {

    private ActivityOpenMapBinding binding;
    private final String MAPKIT_API_KEY = "e8fde506-f137-409d-ad2f-7b6f13ee9d28";
    private final Point ROUTE_START_LOCATION = new Point(55.584777, 37.903695);
    private final Point ROUTE_END_LOCATION = new Point(55.769008, 37.644612);
    private final Point SCREEN_CENTER = new Point(
            (ROUTE_START_LOCATION.getLatitude() + ROUTE_END_LOCATION.getLatitude()) / 2,
            (ROUTE_START_LOCATION.getLongitude() + ROUTE_END_LOCATION.getLongitude()) /
                    2);
    private MapView mapView;
    private int[] colors = {0xFFFF0000, 0xFF00FF00, 0x00FFBBBB, 0xFF0000FF};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
        MapKitFactory.initialize(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_map);
        mapView = findViewById(R.id.mapView);
        Map map = mapView.getMap();


        PlacemarkMapObject vhMarker = map.getMapObjects().addPlacemark(new Point(55.669994354,37.480457306));
        vhMarker.setIcon(ImageProvider.fromResource(this,  org.osmdroid.library.R.drawable.osm_ic_follow_me_on));
        vhMarker.setText("МИРЭА");


        PlacemarkMapObject redSquareMarker = map.getMapObjects().addPlacemark(new Point(55.831388, 37.629277));
        redSquareMarker.setIcon(ImageProvider.fromResource(this,  org.osmdroid.library.R.drawable.osm_ic_follow_me_on));
        redSquareMarker.setText("ВДНХ");

    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }
    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }
}