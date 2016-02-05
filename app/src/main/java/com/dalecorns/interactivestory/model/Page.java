package com.dalecorns.interactivestory.model;

/**
 * Created by dcorns on 2/5/16.
 */
public class Page {
    private int mImageId;
    private String mText;
    private Choice mChoice1;
    private Choice mChoice2;
    private Boolean mFinal = false;

    public Page(int imageId, String text, Choice choice1, Choice choice2) {
        mImageId = imageId;
        mText = text;
        mChoice1 = choice1;
        mChoice2 = choice2;
    }

    public Page(int imageId, String text) {
        mImageId = imageId;
        mText = text;
        mChoice1 = null;
        mChoice2 = null;
        mFinal = true;
    }

    public Boolean getFinal() {
        return mFinal;
    }

    public void setFinal(Boolean aFinal) {
        mFinal = aFinal;
    }

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
