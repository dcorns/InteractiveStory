package com.dalecorns.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null){
            name = "no Data!";
        }
        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mChoice1 = (Button) findViewById(R.id.choiceButton1);
        mChoice2 = (Button) findViewById(R.id.choiceButton2);
        loadPage(name);
        Log.d(TAG, name);
    }

    private void loadPage(String name){
       Page page = mStory.getPage(0);
        Drawable drawable = getResources().getDrawable(page.getImageId());
        mImageView.setImageDrawable(drawable);
        String pageText = page.getText();
        //String.format takes a string with place holders and replaces the holders with the arguments that follow
        pageText = String.format(pageText, name);
        mTextView.setText(pageText);
        mChoice1.setText(page.getChoice1().getText());
        mChoice2.setText(page.getChoice2().getText());


    }

}
