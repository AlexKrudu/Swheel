package com.example.teen.swheel;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

public class Register2Activity extends AppCompatActivity {

    // Используем объект CalendarView:
    CalendarView mCalendarView;

    Person person;
    String login, name, surname;

    Button buttonNext;
    EditText editName, editSurname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "swheeldb").allowMainThreadQueries().build();


        buttonNext = findViewById(R.id.button2);
        editName = findViewById(R.id.editText7);
        editSurname = findViewById(R.id.editText9);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editName.getText().toString();
                surname = editSurname.getText().toString();
                person.setName(name);
                person.setSurname(surname);
                db.personDao().update(person);
                Intent intent = new Intent(Register2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        login = getIntent().getStringExtra("login");

        person = db.personDao().getByLogin(login);

        // Связываемся с нашим календариком:
        mCalendarView = (CalendarView)findViewById(R.id.calendarView);

        //Настраиваем слушателя смены даты:
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            // Описываем метод выбора даты в календаре:
            @Override
            public void onSelectedDayChange(CalendarView view, int year,int month, int dayOfMonth) {
                person.setYear(2018 - year);
                person.setMonth(month);
                person.setDay(dayOfMonth);
            }});
    }
}



