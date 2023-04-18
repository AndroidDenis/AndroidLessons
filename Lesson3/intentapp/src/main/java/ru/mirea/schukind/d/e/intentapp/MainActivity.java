package ru.mirea.schukind.d.e.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.text3);
    }
    public void onClickButton(View view){
        long dateInMillis = System.currentTimeMillis();
        String format = "yyyy-MM-dd HH:mm:ss";
        final SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateString = sdf.format(new Date(dateInMillis));

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("key", String.format("Квадрат значения моего номера по списку в группе составляет 841; Время на данный момент %s", dateString));
        startActivity(intent);
    }
}