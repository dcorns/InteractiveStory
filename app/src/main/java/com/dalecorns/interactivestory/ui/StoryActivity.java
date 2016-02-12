package com.dalecorns.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalecorns.interactivestory.R;
import com.dalecorns.interactivestory.model.Choice;
import com.dalecorns.interactivestory.model.Page;
import com.dalecorns.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mChoice1;
    private Button mChoice2;
    private Page mCurrrentPage;
    private String mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if(mName == null){
            mName = "no Data!";
        }
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);
        loadPage(0);
        Log.d(TAG, mName);
    }

    private void loadPage(int choice){
        mCurrrentPage = mStory.getPage(choice);
        Drawable drawable = getResources().getDrawable(mCurrrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText = mCurrrentPage.getText();
        //String.format takes a string with place holders and replaces the holders with the arguments that follow
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        if (mCurrrentPage.getFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
        else {
            mChoice1.setText(mCurrrentPage.getChoice1().getText());
            mChoice2.setText(mCurrrentPage.getChoice2().getText());
            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = mCurrrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }

    }

}
