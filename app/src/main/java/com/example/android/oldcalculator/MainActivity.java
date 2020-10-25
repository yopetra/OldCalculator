package com.example.android.oldcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;

import com.example.android.oldcalculator.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Presenter presenter = new Presenter();
    ActivityMainBinding binding;
    ArrayList<ImageView> digitsViews = new ArrayList<>();
    ArrayList<ImageView> decimalViews = new ArrayList<>();
    int displaySize = 7; // 7 digits

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        digitsViews.add(binding.ivD0);
        digitsViews.add(binding.ivD1);
        digitsViews.add(binding.ivD2);
        digitsViews.add(binding.ivD3);
        digitsViews.add(binding.ivD4);
        digitsViews.add(binding.ivD5);
        digitsViews.add(binding.ivD6);
        digitsViews.add(binding.ivD7);

        decimalViews.add(binding.ivDec0);
        decimalViews.add(binding.ivDec1);
        decimalViews.add(binding.ivDec2);
        decimalViews.add(binding.ivDec3);
        decimalViews.add(binding.ivDec4);
        decimalViews.add(binding.ivDec5);
        decimalViews.add(binding.ivDec6);
        decimalViews.add(binding.ivDec7);

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
                showResult(result);
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
                showResult(result);
            }
        });

        binding.btMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.minusOperation();
                showResult(result);
            }
        });

        binding.btMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.multiplyOperation();
                showResult(result);
            }
        });

        binding.btDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.divideOperation();
                showResult(result);
            }
        });

        binding.btEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.equalOperation();
                showResult(result);
            }
        });

        binding.btSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("sqr");
                showResult(result);
            }
        });

        binding.btProcent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("procent");
                showResult(result);
            }
        });

        binding.btC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("c");
                showResult(result);
            }
        });

        binding.btMPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("m+");
                binding.ivMemoryLamp.setVisibility(View.VISIBLE);
            }
        });

        binding.btMMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("m-");
                binding.ivMemoryLamp.setVisibility(View.VISIBLE);
            }
        });

        binding.btMr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = presenter.clickOpetationButton("mr");
                showResult(result);
            }
        });

        binding.btMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clickOpetationButton("mc");
                binding.ivMemoryLamp.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void numberActions(int nmAction){
        String result =  presenter.clickedNumberButton(nmAction);
        showResult(result);
    }

    private void showResult(String result){
        double dbResult = Double.parseDouble(result);
        if(dbResult < 0){
            binding.ivMinusLamp.setVisibility(View.VISIBLE);
        }else{
            binding.ivMinusLamp.setVisibility(View.INVISIBLE);
        }
        clearAllDecimals();
        char[] ch = new char[result.length()];

        int chId = 0;
        for(int i = result.length()-1; i > -1; i--){
            if(result.charAt(i) != '.'){
                ch[chId] = result.charAt(i);
                chId++;
            }else{
                decimalViews.get(chId).setVisibility(View.VISIBLE);
            }
        }


        for(int i = displaySize; i > -1; i--){

            char currentDigit = 'n';
            if(i < ch.length){
                currentDigit = ch[i];
            }


            Drawable mDrawable = getResources().getDrawable(R.drawable.dn);

            switch(currentDigit){
                case '0':
                    mDrawable = getResources().getDrawable(R.drawable.d0);
                    break;

                case '1':
                    mDrawable = getResources().getDrawable(R.drawable.d1);
                    break;

                case '2':
                    mDrawable = getResources().getDrawable(R.drawable.d2);
                    break;

                case '3':
                    mDrawable = getResources().getDrawable(R.drawable.d3);
                    break;

                case '4':
                    mDrawable = getResources().getDrawable(R.drawable.d4);
                    break;

                case '5':
                    mDrawable = getResources().getDrawable(R.drawable.d5);
                    break;

                case '6':
                    mDrawable = getResources().getDrawable(R.drawable.d6);
                    break;

                case '7':
                    mDrawable = getResources().getDrawable(R.drawable.d7);
                    break;

                case '8':
                    mDrawable = getResources().getDrawable(R.drawable.d8);
                    break;

                case '9':
                    mDrawable = getResources().getDrawable(R.drawable.d9);
                    break;

                default:
                    mDrawable = getResources().getDrawable(R.drawable.dn);
            }

            digitsViews.get(i).setImageDrawable(mDrawable);

        }
    }

    private void clearAllDecimals() {
        for(int i = 0; i < displaySize; i++){
            decimalViews.get(i).setVisibility(View.INVISIBLE);
        }
    }
}