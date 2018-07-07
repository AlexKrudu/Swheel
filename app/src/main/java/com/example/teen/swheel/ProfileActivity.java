package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String login = getIntent().getStringExtra("login");
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
        Person person = db.personDao().getByLogin(login);
        String name = person.getName();
        String surname = person.getSurname();
        int year = person.getYear();
        TextView NameView = findViewById(R.id.textView10);
        TextView SurnameView = findViewById(R.id.textView11);
        TextView YearView = findViewById(R.id.textView21);

        NameView.setText(name);
        SurnameView.setText(surname);
        YearView.setText(String.valueOf(year) + "года");




    }

    public void onClick(View view) {
    }


}
