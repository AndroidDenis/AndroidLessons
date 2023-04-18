package ru.mirea.schukind.d.e.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1 = findViewById(R.id.text1);
        String text = (String) getIntent().getSerializableExtra("key");
        text1.setText(text);
    }
}

