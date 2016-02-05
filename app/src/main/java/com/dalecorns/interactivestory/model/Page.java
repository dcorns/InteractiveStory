package com.dalecorns.interactivestory.model;

/**
 * Created by dcorns on 2/5/16.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public String getText() {

        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public int getImageId(){
        return mImageId;
    }
    public void setImageId(int id){
        mImageId = id;
    }
}
