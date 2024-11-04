package com.example.myapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements DataEntryFragment.OnDataPass {
    private DisplayFragment displayFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        if (savedInstanceState == null) {
            displayFragment = new DisplayFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new DataEntryFragment())
                    .add(R.id.fragment_container, displayFragment)
                    .commit();
        }
    }

    @Override
    public void onDataPass(Student student) {
        displayFragment.updateStudentInfo(student);
    }
}
