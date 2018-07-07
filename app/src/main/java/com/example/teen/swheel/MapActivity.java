package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Geometry;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.geometry.geo.XYPoint;
import com.yandex.mapkit.layers.ObjectEvent;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.Rect;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.user_location.UserLocationLayer;
import com.yandex.mapkit.user_location.UserLocationObjectListener;
import com.yandex.mapkit.user_location.UserLocationView;
import com.yandex.runtime.image.ImageProvider;

import java.util.Random;


public class MapActivity extends AppCompatActivity implements UserLocationObjectListener {

    private MapView mapview;
    private UserLocationLayer userLocationLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String[] names = {"Василий", "Александр", "Иван", "Ефрем", "Сергей", "Даниил", "Валерий", "Владислав"};
        String[] surnames = {"Петров", "Иванов", "Сергеев", "Пупкин", "Петряев", "Данилов", "Митрофанов", "Коновалов"};
        double[] lattitudes = {53.238921, 53.225325, 53.213785, 53.210076, 53.204098, 53.198738, 53.188532, 53.197810};
        double[] longitudes = {44.956853, 44.978483, 44.999082, 45.011270, 45.026290, 45.036805, 45.043521, 45.048241};
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
        RandomPersonDao randomPersonDao = db.randomPersonDao();
        RandomPerson randomPerson = new RandomPerson();
        for (int x = 0; x < 8; x++) {
            randomPerson.setName(names[x]);
            randomPerson.setSurname(surnames[x]);
            randomPerson.setLattitude(lattitudes[x]);
            randomPerson.setLongitude(longitudes[x]);
            randomPersonDao.insert(randomPerson);
        }


        super.onCreate(savedInstanceState);
        MapKitFactory.setApiKey("59ac5e3f-0809-43e6-90be-94f6c4ec8742");
        MapKitFactory.initialize(this);
        setContentView(R.layout.activity_map);


        // Укажите имя activity вместо map.
        final Random random = new Random();
        mapview = findViewById(R.id.mapview);
        mapview.getMap().setRotateGesturesEnabled(false);
        mapview.getMap().move(new CameraPosition(new Point(0, 0), 14, 0, 0));
        MapObjectCollection mapObjects = mapview.getMap().getMapObjects();
        for (int i = 0; i < 8; i++) {
            Point point = new Point(lattitudes[i], longitudes[i]);
            mapObjects.addPlacemark(point, ImageProvider.fromResource(this, R.drawable.user_1337));
        }
        mapObjects.addTapListener(new MapObjectTapListener() {
            @Override
            public boolean onMapObjectTap(MapObject mapObject, Point point) {
                Intent intent = new Intent(MapActivity.this, ProfileActivity.class);
                String bullshit = names[random.nextInt(8) + 1];
                intent.putExtra("name", bullshit);
                startActivity(intent);

                return true;
            }
        });


        userLocationLayer = mapview.getMap().getUserLocationLayer();
        userLocationLayer.setEnabled(true);
        userLocationLayer.setHeadingEnabled(true);

        userLocationLayer.setObjectListener(this);
    }

    @Override
    protected void onStop() {
        // Activity onStop call must be passed to both MapView and MapKit instance.
        mapview.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Activity onStart call must be passed to both MapView and MapKit instance.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapview.onStart();
    }

    @Override
    public void onObjectAdded(UserLocationView userLocationView) {
        userLocationLayer.setAnchor(
                new PointF((float) (mapview.getWidth() * 0.5), (float) (mapview.getHeight() * 0.5)),
                new PointF((float) (mapview.getWidth() * 0.5), (float) (mapview.getHeight() * 0.83)));

        userLocationView.getPin().setIcon(ImageProvider.fromResource(
                this, R.drawable.user_arrow));
        userLocationView.getArrow().setIcon(ImageProvider.fromResource(
                this, R.drawable.user_arrow));
        //userLocationView.getAccuracyCircle().setFillColor(Color.BLUE);
    }

    @Override
    public void onObjectRemoved(UserLocationView view) {
    }

    @Override
    public void onObjectUpdated(UserLocationView view, ObjectEvent event) {
    }

}


