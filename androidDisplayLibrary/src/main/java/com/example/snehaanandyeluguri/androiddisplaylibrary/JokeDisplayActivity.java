package com.example.snehaanandyeluguri.androiddisplaylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {
    TextView displayJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        displayJoke=(TextView)findViewById(R.id.displayJoke);
        displayJoke.setText(getIntent().getStringExtra("Joke"));

    }
}
