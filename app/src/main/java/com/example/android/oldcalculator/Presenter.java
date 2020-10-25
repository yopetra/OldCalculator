package com.example.android.oldcalculator;

import android.app.VoiceInteractor;

public class Presenter {

    private String mDisplayValue = "0";
    private double mTotalResult = 0;
    private boolean mIsInteger = true;
    private boolean mClearScreen = false;
    private String mLastoperator = "";
    private Model model;
    private int mDisplaySize = 8;

    public Presenter(){
        model = new Model();
    }

    public String clickedNumberButton(int btnName){

        if(mClearScreen){
            mDisplayValue = "0";
        }

        int stringSize = mDisplayValue.length();
        if(mDisplayValue.contains(".")){stringSize--;}

        if(stringSize < mDisplaySize){
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
                mLastoperator = "";
                MainActivity.setErrorLamp(false);
                break;

            case "sqr":
                mTotalResult = Math.sqrt(Double.parseDouble(mDisplayValue));

                mDisplayValue = Double.toString(mTotalResult);
                if(mDisplayValue.length() > 8){
                    mDisplayValue = mDisplayValue.substring(0, 8);
                    MainActivity.setErrorLamp(true);
                }
                mTotalResult = 0;
                mIsInteger = true;
                mLastoperator = "";
                break;

            case "procent":
                if(mLastoperator == "+"){

                    Double a =  Double.parseDouble(mDisplayValue);
                    Double b = mTotalResult;
                    Double result = b + ((b / 100) * a);
                    mDisplayValue = Double.toString(result);
                }else{
                    if(mLastoperator == "-"){
                    Double a =  Double.parseDouble(mDisplayValue);
                    Double b = mTotalResult;
                    Double result = b - ((b / 100) * a);
                    mDisplayValue = Double.toString(result);
                }else{
                        if(mLastoperator == "*"){
                            Double a =  Double.parseDouble(mDisplayValue);
                            Double b = mTotalResult;
                            Double result = b * ((b / 100) * a);
                            mDisplayValue = Double.toString(result);
                        }else{
                            Double a =  Double.parseDouble(mDisplayValue);
                            Double b = mTotalResult;
                            Double result = b / ((b / 100) * a);
                            mDisplayValue = Double.toString(result);
                        }
                    }
                }

                if(mDisplayValue.length() > 8){
                    mDisplayValue = mDisplayValue.substring(0, 8);
                    MainActivity.setErrorLamp(true);
                }
                break;

            case "c":
                mDisplayValue = "0";
                MainActivity.setErrorLamp(false);
                break;

            case "m+":
                Double resultPlus = model.getValue();
                resultPlus = resultPlus + Double.parseDouble(mDisplayValue);
                model.setValue(resultPlus);
                break;

            case "m-":
                Double resultMinus = model.getValue();
                resultMinus = resultMinus - Double.parseDouble(mDisplayValue);
                model.setValue(resultMinus);
                break;

            case "mr":
                mDisplayValue = Double.toString(model.getValue());
                break;

            case "mc":
                model.clearValue();
        }

        removeZero();

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
            if(result.length() > 8){
                result = result.substring(0, 8);
                MainActivity.setErrorLamp(true);
            }
            result = removeZero(result);
            return result;
    }

    public String minusOperation() {
            performMathematic("-");

        String result = Double.toString(mTotalResult);
        if(result.length() > 8){
            result = result.substring(0, 8);
            MainActivity.setErrorLamp(true);
        }
        result = removeZero(result);
        return result;
    }

    public String multiplyOperation() {
        performMathematic("*");

        String result = Double.toString(mTotalResult);
        if(result.length() > 8){
            result = result.substring(0, 8);
            MainActivity.setErrorLamp(true);
        }
        result = removeZero(result);
        return result;
    }

    public String divideOperation() {
        performMathematic("/");

        String result = Double.toString(mTotalResult);
        if(result.length() > 8){
            result = result.substring(0, 8);
            MainActivity.setErrorLamp(true);
        }
        result = removeZero(result);
        return result;
    }

    public String equalOperation() {
        performMathematic(mLastoperator);
        mLastoperator = "";

        String result = Double.toString(mTotalResult);
        if(result.length() > 8 || result.matches("Nan") || result.matches("Infinity")){
            result = result.substring(0, 8);
            MainActivity.setErrorLamp(true);
        }
        result = removeZero(result);
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
                case "/":
                    mTotalResult = mTotalResult / Double.parseDouble(mDisplayValue);
                    break;
            }
        }

        mLastoperator = operator;
        mDisplayValue = Double.toString(mTotalResult);
//        removeZero();
        mIsInteger = true;
        mClearScreen = true;
    }

    private void removeZero() {
        int sizeOfValueOnDisplay = mDisplayValue.length();
        if(sizeOfValueOnDisplay > 2){
            String firstCharFromRight =  mDisplayValue.substring(sizeOfValueOnDisplay-1, sizeOfValueOnDisplay);
            String secondCharFromRight =  mDisplayValue.substring(sizeOfValueOnDisplay-2, sizeOfValueOnDisplay-1);

            if(firstCharFromRight.matches("0")){
                if(secondCharFromRight.matches(".")){
                    mDisplayValue = mDisplayValue.substring(0, sizeOfValueOnDisplay-1);
                }
            }
        }
    }

    private String removeZero(String value) {
        int sizeOfValueOnDisplay = value.length();
        if(sizeOfValueOnDisplay > 2){
            String firstCharFromRight =  value.substring(sizeOfValueOnDisplay-1, sizeOfValueOnDisplay);
            String secondCharFromRight =  value.substring(sizeOfValueOnDisplay-2, sizeOfValueOnDisplay-1);

            if(firstCharFromRight.matches("0")){
                if(secondCharFromRight.matches(".")){
                    value = value.substring(0, sizeOfValueOnDisplay-1);
                }
            }
        }

        return value;
    }
}
