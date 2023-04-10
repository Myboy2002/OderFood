package com.example.sairamkrishna.oderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sairamkrishna.oderfood.Database.CreateDatabase;

public class DangKyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);

        CreateDatabase createDatabase = new CreateDatabase(this);
        createDatabase.open();
    }
}