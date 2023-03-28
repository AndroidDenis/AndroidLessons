package ru.mirea.schukind.d.e.intentfilter;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onLink(android.view.View view){
        Intent openLinkIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mirea.ru/"));
                startActivity(openLinkIntent);
    }

    public void onSend(android.view.View view){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MIREA");
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Щукин Д.Е.");
        startActivity(Intent.createChooser(shareIntent, "МОИ ФИО"));
    }
}