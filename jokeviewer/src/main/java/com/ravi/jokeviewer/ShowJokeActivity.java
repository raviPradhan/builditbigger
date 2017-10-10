package com.ravi.jokeviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        TextView showJoke = (TextView) findViewById(R.id.tv_showJoke);
        showJoke.setText(getIntent().getStringExtra("joke"));
    }
}