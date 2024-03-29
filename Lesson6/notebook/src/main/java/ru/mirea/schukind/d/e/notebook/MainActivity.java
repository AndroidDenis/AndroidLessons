package ru.mirea.schukind.d.e.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText filenameEditText;
    private EditText EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filenameEditText = findViewById(R.id.editText1);
        EditText = findViewById(R.id.editText2);

        Button saveButton = findViewById(R.id.button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToFile();
            }
        });

        Button loadButton = findViewById(R.id.button2);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDataFromFile();
            }
        });
    }

    private void saveDataToFile() {
        String filename = filenameEditText.getText().toString();
        String quote = EditText.getText().toString();

        if (!filename.isEmpty() && !quote.isEmpty()) {
            File directory = getExternalFilesDir("Directory_Documents");
            if (directory != null) {
                File file = new File(directory, filename);

                try {
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(quote.getBytes());
                    fos.close();
                    Toast.makeText(this, "Данные сохранены в файл", Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Ошибка при сохранении данных", Toast.LENGTH_SHORT).show();

                }
            }
        } else {
            Toast.makeText(this, "Пожалуйста, введите название файла и цитату", Toast.LENGTH_SHORT).show();
        }
    }
    private void loadDataFromFile() {
        String filename = filenameEditText.getText().toString();

        if (!filename.isEmpty()) {
            File directory = getExternalFilesDir("Directory_Documents");
            if (directory != null) {
                File file = new File(directory, filename);

                if (file.exists()) {
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        StringBuilder sb = new StringBuilder();
                        String line;

                        while ((line = reader.readLine()) != null) {
                            sb.append(line);
                            sb.append("\n");
                        }

                        reader.close();
                        EditText.setText(sb.toString().trim());
                        Toast.makeText(this, "Данные загружены из файла", Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Ошибка при загрузке данных", Toast.LENGTH_SHORT).show();


                    }
                } else {
                    Toast.makeText(this, "Файл не существует", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "Пожалуйста, введите название файла", Toast.LENGTH_SHORT).show();
        }
    }

}