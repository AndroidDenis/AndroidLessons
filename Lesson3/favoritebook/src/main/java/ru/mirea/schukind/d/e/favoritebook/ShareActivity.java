package ru.mirea.schukind.d.e.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textView);
            String university = extras.getString(MainActivity.KEY);
            ageView.setText(String.format("My favorite book: %s", university));
        }
    }
    public void onClick(View view)
    {
        Intent data = new Intent();
        EditText FindName = findViewById(R.id.EditBook);
        String text = FindName.getText().toString();
        data.putExtra(MainActivity.USER_MESSAGE, text);
        setResult(MainActivity.RESULT_OK, data);
        finish();
    }

}