package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myintent = new Intent(HelloActivity.this, LoginActivity.class);
                startActivity(myintent);
                finish();
            }
        }, 3000);
    }
}