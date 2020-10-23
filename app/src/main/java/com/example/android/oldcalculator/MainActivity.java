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
             }
         });

         binding.bt1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 numberActions(1);
             }
         });

         binding.bt2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 numberActions(2);
             }
         });

        binding.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(3);
            }
        });

        binding.bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(4);
            }
        });

        binding.bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(5);
            }
        });

        binding.bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(6);
            }
        });

        binding.bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(7);
            }
        });

        binding.bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(8);
            }
        });

        binding.bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberActions(9);
            }
        });

        binding.btAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  result =  presenter.clickOpetationButton("ac");
                binding.tvDysplay.setText(result);
            }
        });

        binding.btDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setFractional();
            }
        });

        binding.btPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.plusOperation();
                binding.tvDysplay.setText(result);
            }
        });

        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.minusOperation();
                binding.tvDysplay.setText(result);
            }
        });

        binding.btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.multiplyOperation();
                binding.tvDysplay.setText(result);
            }
        });

        binding.btDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.divideOperation();
                binding.tvDysplay.setText(result);
            }
        });

        binding.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.equalOperation();
                binding.tvDysplay.setText(result);
            }
        });

        binding.btSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("sqr");
                binding.tvDysplay.setText(result);
            }
        });

        binding.btProcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("procent");
                binding.tvDysplay.setText(result);
            }
        });

        binding.btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("c");
                binding.tvDysplay.setText(result);
            }
        });

        binding.btMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("m+");
            }
        });

        binding.btMMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("m-");
            }
        });

        binding.btMr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("mr");
                binding.tvDysplay.setText(result);
            }
        });

        binding.btMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("mc");
            }
        });
    }

    private void numberActions(int nmAction){
        String result =  presenter.clickedNumberButton(nmAction);
        binding.tvDysplay.setText(result);
    }
}