package com.example.myproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import android.widget.Toast;
import java.util.ArrayList;

public class SynonymQuiz extends AppCompatActivity implements View.OnClickListener {

    private int mCurrentPosition = 1;
    private ArrayList<synonymquestions> mQuestionList = null;
    private int mSelectedOptionPosition = 0;
    private boolean isSelectedAnswer = false;
    private String mUserName = null;
    private int mCorrectAnswer = 0;

    private ProgressBar progressBar = null;
    private TextView tvProgress = null;
    private TextView tvQuestion = null;
    private ImageView ivImage = null;
    private TextView tvOptionOne = null;
    private TextView tvOptionTwo = null;
    private TextView tvOptionThree = null;
    private TextView tvOptionFour = null;
    private Button btnSubmit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synonym_quiz);

        setUpView();
        getQuestions();
        setQuestionList();
        defaultOptionsView();
    }

    private void setUpView() {
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tv_progress);
        tvQuestion = findViewById(R.id.tv_question);
        ivImage = findViewById(R.id.iv_question);
        tvOptionOne = findViewById(R.id.tv_option_one);
        tvOptionTwo = findViewById(R.id.tv_option_two);
        tvOptionThree = findViewById(R.id.tv_option_three);
        tvOptionFour = findViewById(R.id.tv_option_four);
        btnSubmit = findViewById(R.id.btn_submit);

        tvOptionOne.setOnClickListener(this);
        tvOptionTwo.setOnClickListener(this);
        tvOptionThree.setOnClickListener(this);
        tvOptionFour.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
    }

    private void getQuestions() {
        mQuestionList = Constants.getQuestions();
    }

    private void setQuestionList() {
        defaultOptionsView();
        if (mQuestionList != null) {
            final ArrayList<synonymquestions> questionsList = mQuestionList;
            int currentPosition = mCurrentPosition;
            final synonymquestions question = questionsList.get(currentPosition - 1);

            ivImage.setImageResource(question.getImage());
            progressBar.setProgress(currentPosition);

            tvProgress.setText(currentPosition + "/" + questionsList.size());
            tvQuestion.setText(question.getQuestion());
            tvOptionOne.setText(question.getOptionOne());
            tvOptionTwo.setText(question.getOptionTwo());
            tvOptionThree.setText(question.getOptionThree());
            tvOptionFour.setText(question.getOptionFour());

            if (currentPosition > questionsList.size()) {
                btnSubmit.setText("FINISH");
            } else {
                btnSubmit.setText("SUBMIT");
            }
        }
    }

    private void defaultOptionsView() {
        ArrayList<TextView> options = new ArrayList<>();
        if (tvOptionOne != null) {
            options.add(0, tvOptionOne);
        }
        if (tvOptionTwo != null) {
            options.add(1, tvOptionTwo);
        }
        if (tvOptionThree != null) {
            options.add(2, tvOptionThree);
        }
        if (tvOptionFour != null) {
            options.add(3, tvOptionFour);
        }

        for (TextView option : options) {
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }
    }

    private void selectedOptionView(TextView tv, int selectedOptionNum) {
        defaultOptionsView();
        mSelectedOptionPosition = selectedOptionNum;
        isSelectedAnswer = true;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg));
    }

    @Override
    public void onClick(View view) {
        boolean isAnswerNotSubmitDone = (btnSubmit != null && btnSubmit.getText().equals("SUBMIT"));
        int viewId = view.getId();
            if (viewId == R.id.tv_option_one){
                if (isAnswerNotSubmitDone) {
                    if (tvOptionOne != null) {
                        selectedOptionView(tvOptionOne, 1);
                    }
                }}
            else if (viewId == R.id.tv_option_two){
                if (isAnswerNotSubmitDone) {
                    if (tvOptionTwo != null) {
                        selectedOptionView(tvOptionTwo, 2);
                    }
                }}
            else if (viewId == R.id.tv_option_three){
                if (isAnswerNotSubmitDone) {
                    if (tvOptionThree != null) {
                        selectedOptionView(tvOptionThree, 3);
                    }
                }}
            else if (viewId == R.id.tv_option_four){
                if (isAnswerNotSubmitDone) {
                    if (tvOptionFour != null) {
                        selectedOptionView(tvOptionFour, 4);
                    }
                }}
            else if (viewId == R.id.btn_submit){
                if (btnSubmit != null) {
                    if (mSelectedOptionPosition == 0) {
                        if (isSelectedAnswer) {
                            isSelectedAnswer = false;
                            mCurrentPosition++;
                            if (mCurrentPosition <= mQuestionList.size()) {
                                setQuestionList();
                            } else {
                                Intent intent = new Intent(this, SynonymQuizResult.class);
                                intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer);
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList.size());
                                startActivity(intent);
                                finish();
                            }
                        } else {
                            Toast.makeText(this, "Please Select Answer", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        synonymquestions synonymquestions = mQuestionList.get(mCurrentPosition - 1);
                        if (synonymquestions.getCorrectAnswer() != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg);
                        } else {
                            mCorrectAnswer++;
                        }
                        answerView(synonymquestions.getCorrectAnswer(), R.drawable.correct_option_border_bg);

                        if (mCurrentPosition == mQuestionList.size()) {
                            btnSubmit.setText("FINISH");
                        } else {
                            btnSubmit.setText("GO TO NEXT QUESTION");
                        }

                        mSelectedOptionPosition = 0;
                    }
                }}
        }

    private void answerView(int answer, int drawableView) {
        TextView[] optionViews = {tvOptionOne, tvOptionTwo, tvOptionThree, tvOptionFour};

        if (answer >= 1 && answer <= optionViews.length && optionViews[answer - 1] != null) {
            optionViews[answer - 1].setBackground(ContextCompat.getDrawable(this, drawableView));
        }
    }
}


