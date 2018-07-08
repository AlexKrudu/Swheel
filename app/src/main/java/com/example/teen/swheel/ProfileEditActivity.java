package com.example.teen.swheel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ProfileEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
    }

    public void onClick(View view) {
    }

    public void openMap(View view) {
        Intent intent = new Intent(ProfileEditActivity.this, MapActivity.class);
        startActivity(intent);
    }

    public void uploadAvatar(View view) {

    }
}
