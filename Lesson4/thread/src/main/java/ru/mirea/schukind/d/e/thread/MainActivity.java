package ru.mirea.schukind.d.e.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());

        mainThread.setName("МОЙ НОМЕР ГРУППЫ: БСБО-17-20, НОМЕР ПО СПИСКУ: 29, МОЙ ЛЮБИМЫЙ ФИЛЬМ: Константин Повелитель Тьмы");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));
    }
    public void onCounttreads (View view) {
        Runnable runnable = new Runnable() {
            public void run() {
                int numberThread = counter++;
                Log.d("ThreadProject", String.format("Запущен поток No, студентом группы БСБО-17-20, номер по списку 29 ", numberThread, "БСБО-17-20", -1));
                long endTime = System.currentTimeMillis() + 20 * 1000;
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime - System.currentTimeMillis());
                            Log.d(MainActivity.class.getSimpleName(), "Endtime: " + endTime);
                        } catch (Exception e) {
                        }
                        Log.d("ThreadProject", "Выполнен поток No " + numberThread);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public void onCount (View view) {
        Runnable runnable = () -> {
            EditText editText = findViewById(R.id.Text1);
            float pairs = Float.parseFloat(editText.getText().toString());
            EditText editText2 = findViewById(R.id.Text2);
            float days = Float.parseFloat(editText2.getText().toString());
            TextView textView = findViewById(R.id.textCount);
            textView.setText("Среднее кол-во : " + pairs / days);
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}