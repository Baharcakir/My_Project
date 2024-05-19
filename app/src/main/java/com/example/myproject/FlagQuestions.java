package com.example.myproject;

public class FlagQuestions {
    private int flagId;
    private String flagQuestion;
    private int flagImage;
    private String quizTvOptionOne;
    private String quizTvOptionTwo;
    private String quizTvOptionThree;
    private String quizTvOptionFour;
    private int flagCorrectAnswer;

    public FlagQuestions(int flagId, String flagQuestion, int flagImage, String quizTvOptionOne, String quizTvOptionTwo, String quizTvOptionThree, String quizTvOptionFour, int flagCorrectAnswer) {
        this.flagId = flagId;
        this.flagQuestion = flagQuestion;
        this.flagImage = flagImage;
        this.quizTvOptionOne = quizTvOptionOne;
        this.quizTvOptionTwo = quizTvOptionTwo;
        this.quizTvOptionThree = quizTvOptionThree;
        this.quizTvOptionFour = quizTvOptionFour;
        this.flagCorrectAnswer = flagCorrectAnswer;
    }

    public int getFlagId() {
        return flagId;
    }

    public String getFlagQuestion() {
        return flagQuestion;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public String getquizTvOptionOne() {
        return quizTvOptionOne;
    }

    public String getquizTvOptionTwo() {
        return quizTvOptionTwo;
    }

    public String getquizTvOptionThree() {
        return quizTvOptionThree;
    }

    public String getquizTvOptionFour() {
        return quizTvOptionFour;
    }

    public int getFlagCorrectAnswer() {
        return flagCorrectAnswer;
    }
}
