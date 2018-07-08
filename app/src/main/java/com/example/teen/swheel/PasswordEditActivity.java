package com.example.teen.swheel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PasswordEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_edit);
    }

    public void backButton(View view) {
        Intent intent = new Intent(PasswordEditActivity.this, ProfileEditActivity.class);
        startActivity(intent);
    }

    public void acceptButtonClick(View view) {

    }
}
