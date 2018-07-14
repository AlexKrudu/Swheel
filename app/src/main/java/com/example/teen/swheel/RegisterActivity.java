package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterActivity extends AppCompatActivity {
    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://185.221.153.250:3306/swheel";
    private static final String user = "root";
    private static final String password = "Q1Kvvh$efg1";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static PersonApi personApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void submittionClick(View v)
    {
        RegistrationSend registrationSend = new RegistrationSend();

        registrationSend.setDate(1);
        registrationSend.setLogin("1");
        registrationSend.setMonth(1);
        registrationSend.setName("1");
        registrationSend.setPassword("1");
        registrationSend.setSex(1);
        registrationSend.setSurname("1");
        registrationSend.setYear(1);

        personApi = Controller.getApi();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
        PersonDao personDao = db.personDao();
        Person person = new Person();
        EditText login =  (EditText) findViewById(R.id.editText3);
        person.setLogin(login.getText().toString());
        EditText password = (EditText) findViewById(R.id.editText5);
        person.setPassword(password.getText().toString());
        EditText email =  (EditText) findViewById(R.id.editText8);
        person.setEmail(email.getText().toString());
        personDao.insert(person);
        Intent intent = new Intent(RegisterActivity.this, Register2Activity.class);
        intent.putExtra("login", person.login);
        startActivity(intent);

    }
}
