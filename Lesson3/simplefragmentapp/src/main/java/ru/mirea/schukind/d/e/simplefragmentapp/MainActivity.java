package ru.mirea.schukind.d.e.simplefragmentapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Fragment Fragment1, Fragment2;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 = new FirstFragment();
        Fragment2 = new SecondFragment();
    }
    public void onClick(View view) {
        fragmentManager = getSupportFragmentManager();
        switch (view.getId()){
            case R.id.fragment1:

                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, Fragment1).commit();

                break;
            case R.id.fragment2:

                fragmentManager.beginTransaction().replace(R.id.fragmentContainer, Fragment2).commit();

                break;
            default:
                break;
        }
    }
}