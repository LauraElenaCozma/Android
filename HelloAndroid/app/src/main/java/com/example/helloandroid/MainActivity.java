package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random random = new Random();
        try {
            int number = random.nextInt(100);
            if(number >= 10) {
                throw new Exception(number + " is not a digit");
            }
        }
        catch(Exception e) {
            Logging.show(this, e.getMessage());
        }
    }
}