package com.ElyAdam.AELY6_1;

/**
 * Lab 6.1
 * 10/06/15
 * @author Adam Ely
 */
public class TextInformation {
    private int mPageLabel;
    private int mQuestionTextInt;
    private int mAnswerTextInt;

    public TextInformation(int mPageLabel, int mQuestionTextInt, int mAnswerTextInt) {
        this.mPageLabel = mPageLabel;
        this.mQuestionTextInt = mQuestionTextInt;
        this.mAnswerTextInt = mAnswerTextInt;
    }

    public int getQuestionTextInt() {
        return mQuestionTextInt;
    }

    public void setQuestionTextInt(int mQuestionTextInt) {
        this.mQuestionTextInt = mQuestionTextInt;
    }

    public int getPageLabel() {
        return mPageLabel;
    }

    public void setPageLabel(int mLabels) {
        this.mPageLabel = mPageLabel;
    }

    public int getmAnswerTextInt() {
        return mAnswerTextInt;
    }

    public void setmAnswerTextInt(int mAnswerTextInt) {
        this.mAnswerTextInt = mAnswerTextInt;
    }

}
