package ru.mirea.schukind.d.e.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        editText = findViewById(R.id.editTextTextPersonName);
        String text = editText.getText().toString();

        Toast toast = Toast.makeText(getApplicationContext(),
                text + "Кол-во символов в строке: " + text.length(),
                Toast.LENGTH_LONG);
        toast.show();
    }
}