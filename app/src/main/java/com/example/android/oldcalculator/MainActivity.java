package com.example.android.oldcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.android.oldcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

         binding.bt0.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

             }
         });
    }
}