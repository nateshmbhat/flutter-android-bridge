package com.techy.nateshmbhat.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.button) ;

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(
                        FlutterActivity.createDefaultIntent(MainActivity.this)
                );
            }
        });
    }
}
