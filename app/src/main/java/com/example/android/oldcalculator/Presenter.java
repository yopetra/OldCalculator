package com.example.android.oldcalculator;

public class Presenter {

    private String mDisplayValue = "0";
    private double mTotalResult = 0;
    private boolean mIsInteger = true;
    private boolean mClearScreen = false;
    private String mLastoperator = "";
//    private int mFractionalCounter = 0;

    public Presenter(){}

    public String clickedNumberButton(int btnName){

        if(mClearScreen){
            mDisplayValue = "0";
        }

        switch(btnName){
            case 0:
                if(mDisplayValue == "0"){
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "0";
                    break;
                }

            case 1:
                if(mDisplayValue == "0"){
                    mDisplayValue = "1";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "1";
                    break;
                }

            case 2:
                if(mDisplayValue == "0"){
                    mDisplayValue = "2";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "2";
                    break;
                }

            case 3:
                if(mDisplayValue == "0"){
                    mDisplayValue = "3";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "3";
                    break;
                }

            case 4:
                if(mDisplayValue == "0"){
                    mDisplayValue = "4";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "4";
                    break;
                }

            case 5:
                if(mDisplayValue == "0"){
                    mDisplayValue = "5";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "5";
                    break;
                }

            case 6:
                if(mDisplayValue == "0"){
                    mDisplayValue = "6";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "6";
                    break;
                }

            case 7:
                if(mDisplayValue == "0"){
                    mDisplayValue = "7";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "7";
                    break;
                }

            case 8:
                if(mDisplayValue == "0"){
                    mDisplayValue = "8";
                    break;
                }else{
                    mDisplayValue = mDisplayValue + "8";
                    break;
                }

            case 9:
                if(mDisplayValue == "0"){
                    mDisplayValue = "9";
                    break;
                }else{
                    mDisplayValue = mDisplayValue+ "9";
                    break;
                }
        }

        mClearScreen = false;

        return mDisplayValue;
    }

    public String clickOpetationButton(String btnName) {

        switch(btnName){
            case "ac":
                mDisplayValue = "0";
                mTotalResult = 0;
                mIsInteger = true;
//                mLastoperator = "";
                break;
        }

        return mDisplayValue;
    }

    public void setFractional() {
        if(mIsInteger){
            mIsInteger = false;
            mDisplayValue = mDisplayValue + ".";
        }
    }

    public String plusOperation() {
            performMathematic("+");

            String result = Double.toString(mTotalResult);
            return result;
    }

    public String minusOperation() {
            performMathematic("-");

        String result = Double.toString(mTotalResult);
        return result;
    }

    public String multiplyOperation() {
        performMathematic("*");

        String result = Double.toString(mTotalResult);
        return result;
    }

    private void performMathematic(String operator){
        if(mLastoperator.matches("")){
            mTotalResult = Double.parseDouble(mDisplayValue);
        }else{
            switch(mLastoperator){
                case "+":
                    mTotalResult = mTotalResult + Double.parseDouble(mDisplayValue);
                    break;
                case "-":
                    mTotalResult = mTotalResult - Double.parseDouble(mDisplayValue);
                    break;
                case "*":
                    mTotalResult = mTotalResult * Double.parseDouble(mDisplayValue);
                    break;
            }
        }

        mLastoperator = operator;
        mDisplayValue = Double.toString(mTotalResult);
        mIsInteger = true;
        mClearScreen = true;
    }


}
