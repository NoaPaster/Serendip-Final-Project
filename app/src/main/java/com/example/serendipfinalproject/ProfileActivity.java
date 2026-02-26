package com.example.serendipfinalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView name = findViewById(R.id.profileNameText);
        TextView email = findViewById(R.id.profileEmailText);
        TextView phone = findViewById(R.id.profilePhoneText);
        TextView initials = findViewById(R.id.profileInitialsText);
        ImageView back = findViewById(R.id.backBtn);

        name.setText(getIntent().getStringExtra("name"));
        email.setText(getIntent().getStringExtra("email"));
        phone.setText(getIntent().getStringExtra("phone"));
        initials.setText(getIntent().getStringExtra("initials"));

        back.setOnClickListener(v -> finish());
    }
}
