package com.ElyAdam.AELY6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Lab 6.1
 * 10/07/15
 * @author Adam Ely
 */
public class MainActivity extends AppCompatActivity {

    //Creating a variable for each view
    Button mNextButton;
    TextView mPageNumberLabel;
    TextView mQuestionText;
    ToggleButton mToggleButton;
    TextView mAnswerText;
    Button mPreviousButton;

    //Create instance variables
    int mCurrentIndex = 0;
    int question = 0;
    int page = 0;
    int answer = 0;
    int toggleAnswer = 0;

    //Create the array of labels
    final TextInformation[] mCurrentPageNumber = new TextInformation[]{
            new TextInformation(R.string.page_1, R.string.question_alaska, R.string.answer_alaska),
            new TextInformation(R.string.page_2, R.string.question_iowa, R.string.answer_iowa),
            new TextInformation(R.string.page_3, R.string.question_minnesota, R.string.answer_minnesota),
            new TextInformation(R.string.page_4, R.string.question_indiana, R.string.answer_indiana),
            new TextInformation(R.string.page_5, R.string.question_michigan, R.string.answer_michigan),
            new TextInformation(R.string.page_6, R.string.question_ohio, R.string.answer_ohio),
            new TextInformation(R.string.page_7, R.string.question_illinois, R.string.answer_illinois),
            new TextInformation(R.string.page_8, R.string.question_missouri, R.string.answer_missouri),
            new TextInformation(R.string.page_9, R.string.question_northDakota, R.string.answer_northDakota),
            new TextInformation(R.string.page_10, R.string.question_southDakota, R.string.answer_southDakota),
            new TextInformation(R.string.page_11, R.string.question_kentucky, R.string.answer_kentucky),
            new TextInformation(R.string.page_12, R.string.question_tennessee, R.string.answer_tennessee),
            new TextInformation(R.string.page_13, R.string.question_maryland, R.string.answer_maryland),
    };

    /**
     * This method saves all the information at the time you changed the view of
     * your phone.
     * @param savedInstanceState
     */
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("currentPage", page);
        savedInstanceState.putInt("currentQuestion", question);
        savedInstanceState.putInt("currentAnswer", answer);
        savedInstanceState.putInt("currentIndex", mCurrentIndex);
        savedInstanceState.putInt("currentToggle", toggleAnswer);
    }

    /**
     * This method restores all the information at the time you changed the view of
     * your phone.
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        page = savedInstanceState.getInt("currentPage");
        mPageNumberLabel.setText(page);

        question = savedInstanceState.getInt("currentQuestion");
        mQuestionText.setText(question);

        answer = savedInstanceState.getInt("currentAnswer");

        mCurrentIndex = savedInstanceState.getInt("currentIndex");

        toggleAnswer = savedInstanceState.getInt("currentToggle");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Wire up the widgets
        mNextButton = (Button) findViewById(R.id.nextButton);
        mPageNumberLabel = (TextView) findViewById(R.id.pageNumberLabel);
        mQuestionText = (TextView) findViewById(R.id.questionText);
        mToggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        mAnswerText = (TextView) findViewById(R.id.answerText);
        mPreviousButton = (Button) findViewById(R.id.previousButton);

        if (savedInstanceState != null) {
            page = savedInstanceState.getInt("currentPage");
            mPageNumberLabel.setText(page);

            question = savedInstanceState.getInt("currentQuestion");
            mQuestionText.setText(question);

            answer = savedInstanceState.getInt("currentAnswer");

            mCurrentIndex = savedInstanceState.getInt("currentIndex");

            toggleAnswer = savedInstanceState.getInt("currentToggle");
        }

            displayTextInformation();
        /**
         * This method is for the next button.  If the user presses it it go forward one position
         * in the array and display the information accordingly.
         */
        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                clearToggle();

                if(mCurrentIndex != (mCurrentPageNumber.length-1)) {
                    mCurrentIndex++;
                } else {
                    mCurrentIndex = 0;
                }

                displayTextInformation();
            }
        });

        /**
         * This method is for the next button.  If the user presses it it go back one position
         * in the array and display the information accordingly.
         */
        mPreviousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                clearToggle();

                if(mCurrentIndex == 0) {
                    mCurrentIndex = 13;
                    mCurrentIndex = mCurrentIndex -1;
                } else {
                    mCurrentIndex = mCurrentIndex -1;
                }

                displayTextInformation();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method sets the toggle button to off.
     */
    private void clearToggle() {
        mToggleButton.setChecked(false);
    }

    /**
     * This method is for the toggle button.  If the user presses it, it will display
     * the answer to that question. If the user presses it again, the answer will then
     * be hidden.
     */
    private void displayToggleButton() {
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                toggleAnswer = mCurrentPageNumber[mCurrentIndex].getmAnswerTextInt();
                if (isChecked) {
                    mAnswerText.setText(toggleAnswer);
                } else {
                    mAnswerText.setText(null);
                }
            }
        });
    }
    /**
     * This method is used to display the text information to the app after the user presses a
     * chosen button.
     */
    private void displayTextInformation() {
        page = mCurrentPageNumber[mCurrentIndex].getPageLabel();
        mPageNumberLabel.setText(page);

        question = mCurrentPageNumber[mCurrentIndex].getQuestionTextInt();
        mQuestionText.setText(question);

        answer = mCurrentPageNumber[mCurrentIndex].getmAnswerTextInt();

        mAnswerText.setText(null);

        displayToggleButton();
    }
}