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
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class FlagQuiz extends AppCompatActivity implements View.OnClickListener {

    private int CurrentPosition = 1;
    private ArrayList<FlagQuestions> QuestionList = null;
    private int SelectedOptionPosition = 0;
    private boolean isSelectedAnswer = false;
    private String UserName = null;
    private int flagCorrectAnswer = 0;

    private ProgressBar quizProgressBar = null;
    private TextView quizTvProgress = null;
    private TextView quizTvQuestion = null;
    private ImageView quizIvImage = null;
    private TextView quizTvOptionOne = null;
    private TextView quizTvOptionTwo = null;
    private TextView quizTvOptionThree = null;
    private TextView quizTvOptionFour = null;
    private Button quizBtnSubmit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_quiz);

        setPassingRetriveDataIntent();
        setUpView();
        getQuestions();
        setQuestionList();
        defaultOptionsView();
    }

    private void setUpView() {
        quizProgressBar = findViewById(R.id.quiz_progress_bar);
        quizTvProgress = findViewById(R.id.quiz_tv_progress);
        quizTvQuestion = findViewById(R.id.quiz_tv_question);
        quizIvImage = findViewById(R.id.quiz_iv_image);
        quizTvOptionOne = findViewById(R.id.quiz_tv_option_one);
        quizTvOptionTwo = findViewById(R.id.quiz_tv_option_two);
        quizTvOptionThree = findViewById(R.id.quiz_tv_option_three);
        quizTvOptionFour = findViewById(R.id.quiz_tv_option_four);
        quizBtnSubmit = findViewById(R.id.quiz_btn_submit);

        quizTvOptionOne.setOnClickListener(this);
        quizTvOptionTwo.setOnClickListener(this);
        quizTvOptionThree.setOnClickListener(this);
        quizTvOptionFour.setOnClickListener(this);
        quizBtnSubmit.setOnClickListener(this);
    }

    private void setPassingRetriveDataIntent() {
        UserName = getIntent().getStringExtra(FlagConstants.USER_NAME);
    }

    private void getQuestions() {
        QuestionList = FlagConstants.getQuestions();
    }

    private void setQuestionList() {
        defaultOptionsView();
        if (QuestionList != null) {
            final ArrayList<FlagQuestions> questionsList = QuestionList;
            int currentPosition = CurrentPosition;
            final FlagQuestions question = questionsList.get(currentPosition - 1);

            quizIvImage.setImageResource(question.getFlagImage());
            quizProgressBar.setProgress(currentPosition);

            quizTvProgress.setText(currentPosition + "/" + questionsList.size());
            quizTvQuestion.setText(question.getFlagQuestion());
            quizTvOptionOne.setText(question.getquizTvOptionOne());
            quizTvOptionTwo.setText(question.getquizTvOptionTwo());
            quizTvOptionThree.setText(question.getquizTvOptionThree());
            quizTvOptionFour.setText(question.getquizTvOptionFour());

            if (currentPosition > questionsList.size()) {
                quizBtnSubmit.setText("FINISH");
            } else {
                quizBtnSubmit.setText("SUBMIT");
            }
        }
    }

    private void defaultOptionsView() {
        ArrayList<TextView> options = new ArrayList<>();
        if (quizTvOptionOne != null) {
            options.add(0, quizTvOptionOne);
        }
        if (quizTvOptionTwo != null) {
            options.add(1, quizTvOptionTwo);
        }
        if (quizTvOptionThree != null) {
            options.add(2, quizTvOptionThree);
        }
        if (quizTvOptionFour != null) {
            options.add(3, quizTvOptionFour);
        }

        for (TextView option : options) {
            option.setTextColor(Color.parseColor("#7A8089"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(this, R.drawable.default_option_border_bg));
        }
    }
    private void selectedOptionView(TextView tv, int selectedOptionNum) {
        defaultOptionsView();
        SelectedOptionPosition = selectedOptionNum;
        isSelectedAnswer = true;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg));
    }

    public void onClick(View view) {
        boolean isAnswerNotSubmitDone = (quizBtnSubmit != null && quizBtnSubmit.getText().equals("SUBMIT"));
        int viewId = view.getId();
        if (viewId == R.id.quiz_tv_option_one){
            if (isAnswerNotSubmitDone) {
                if (quizTvOptionOne != null) {
                    selectedOptionView(quizTvOptionOne, 1);
                }
            }}
        else if (viewId == R.id.quiz_tv_option_two){
            if (isAnswerNotSubmitDone) {
                if (quizTvOptionTwo != null) {
                    selectedOptionView(quizTvOptionTwo, 2);
                }
            }}
        else if (viewId == R.id.quiz_tv_option_three){
            if (isAnswerNotSubmitDone) {
                if (quizTvOptionThree != null) {
                    selectedOptionView(quizTvOptionThree, 3);
                }
            }}
        else if (viewId == R.id.quiz_tv_option_four){
            if (isAnswerNotSubmitDone) {
                if (quizTvOptionFour != null) {
                    selectedOptionView(quizTvOptionFour, 4);
                }
            }}
        else if (viewId == R.id.quiz_btn_submit){
            if (quizBtnSubmit != null) {
                if (SelectedOptionPosition == 0) {
                    if (isSelectedAnswer) {
                        isSelectedAnswer = false;
                        CurrentPosition++;
                        if (CurrentPosition <= QuestionList.size()) {
                            setQuestionList();
                        } else {
                            Intent intent = new Intent(this, SynonymQuizResult.class);
                            intent.putExtra(FlagConstants.CORRECT_ANSWER, flagCorrectAnswer);
                            intent.putExtra(FlagConstants.TOTAL_QUESTIONS, QuestionList.size());
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Toast.makeText(this, "Please Select Answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    FlagQuestions FlagQuestions = QuestionList.get(CurrentPosition - 1);
                    if (FlagQuestions.getFlagCorrectAnswer() != SelectedOptionPosition) {
                        answerView(SelectedOptionPosition, R.drawable.wrong_option_border_bg);
                    } else {
                        flagCorrectAnswer++;
                    }
                    answerView(FlagQuestions.getFlagCorrectAnswer(), R.drawable.correct_option_border_bg);

                    if (CurrentPosition == QuestionList.size()) {
                        quizBtnSubmit.setText("FINISH");
                    } else {
                        quizBtnSubmit.setText("GO TO NEXT QUESTION");
                    }

                    SelectedOptionPosition = 0;
                }
            }}
    }

    private void answerView(int answer, int drawableView) {
        TextView[] optionViews = {quizTvOptionOne, quizTvOptionTwo, quizTvOptionThree, quizTvOptionFour};

        if (answer >= 1 && answer <= optionViews.length && optionViews[answer - 1] != null) {
            optionViews[answer - 1].setBackground(ContextCompat.getDrawable(this, drawableView));
        }
    }
}