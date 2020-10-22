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
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 1;
                    break;
                }

            case 2:
                if(mDisplayValue == 0){
                    mDisplayValue = 2;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 2;
                    break;
                }

            case 3:
                if(mDisplayValue == 0){
                    mDisplayValue = 3;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 3;
                    break;
                }

            case 4:
                if(mDisplayValue == 0){
                    mDisplayValue = 4;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 4;
                    break;
                }

            case 5:
                if(mDisplayValue == 0){
                    mDisplayValue = 5;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 5;
                    break;
                }

            case 6:
                if(mDisplayValue == 0){
                    mDisplayValue = 6;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 6;
                    break;
                }

            case 7:
                if(mDisplayValue == 0){
                    mDisplayValue = 7;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 7;
                    break;
                }

            case 8:
                if(mDisplayValue == 0){
                    mDisplayValue = 8;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 8;
                    break;
                }

            case 9:
                if(mDisplayValue == 0){
                    mDisplayValue = 9;
                    break;
                }else{
                    mDisplayValue = mDisplayValue * 10 + 9;
                    break;
                }
        }

        return mDisplayValue;
    }
}
