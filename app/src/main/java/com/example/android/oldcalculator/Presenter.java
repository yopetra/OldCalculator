package com.example.android.oldcalculator;

public class Presenter {

    private int mDisplayValue = 0;

    public Presenter(){}

    public int clickedNumberButton(int btnName){

        switch(btnName){
            case 0:
                if(mDisplayValue == 0){
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10;
                    break;
                }

            case 1:
                if(mDisplayValue == 0){
                    mDisplayValue = 1;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 1;
                    break;
                }
        }

        return mDisplayValue;
    }
}
