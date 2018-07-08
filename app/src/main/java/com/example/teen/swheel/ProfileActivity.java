package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String login = getIntent().getStringExtra("name");
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
        RandomPerson person = db.randomPersonDao().getOneByName(login);
        String name = person.getName();
        String surname = person.getSurname();
        int year = new Random().nextInt(24) + 16;
        TextView NameView = findViewById(R.id.textView10);
        TextView SurnameView = findViewById(R.id.textView11);
        TextView YearView = findViewById(R.id.textView21);

        NameView.setText(name);
        SurnameView.setText(surname);
        YearView.setText(String.valueOf(year) + " года");


    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (Integer.parseInt(android.os.Build.VERSION.SDK) > 5
                && keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            Log.d("CDA", "onKeyDown Called");
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        Log.d("CDA", "onBackPressed Called");
        Intent intent = new Intent(ProfileActivity.this, MapsActivity.class);
        startActivity(intent);
    }
    public void backClick(View view) {
        Intent intent = new Intent(ProfileActivity.this, MapsActivity.class);
        startActivity(intent);
    }

    public void onClick(View view) {

    }


}
