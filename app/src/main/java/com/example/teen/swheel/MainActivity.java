package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void button_click(View v) {
        TextView signin = findViewById(R.id.textView3);
        EditText login = (EditText) findViewById(R.id.editText);
        EditText password = (EditText) findViewById(R.id.editText4);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
        Person person = db.personDao().getByLogin(login.getText().toString());
        try {
            if (person.password.equals(password.getText().toString())) {
                signin.setText("Успешный вход!");
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                //intent.putExtra("login", login.getText().toString());
                startActivity(intent);
            } else {
                signin.setText("Неправильный пароль!");
            }
        } catch (Exception e) {
            signin.setText("Неправильный логин или пароль");
            return;
        }

    }


}
