package com.example.teen.swheel;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    public void submittionClick(View v)
    {
        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();
//        AppDatabase db = App.getInstance().getDatabase();

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
