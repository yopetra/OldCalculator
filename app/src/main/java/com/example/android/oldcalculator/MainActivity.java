package com.example.android.oldcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.android.oldcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Presenter presenter = new Presenter();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

         binding.bt0.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 numberActions(0);
//                int result =  presenter.clickedNumberButton(0);
//                binding.tvDysplay.setText(String.valueOf(result));
             }
         });

         binding.bt1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 numberActions(1);
             }
         });
    }

    private void numberActions(int nmAction){
        int result =  presenter.clickedNumberButton(nmAction);
        binding.tvDysplay.setText(String.valueOf(result));
    }
}