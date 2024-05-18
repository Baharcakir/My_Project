package com.example.myproject;

public class synonymquestions {
    private int id;
    private String question;
    private int image;
    private String optionOne;
    private String optionTwo;
    private String optionThree;
    private String optionFour;
    private int correctAnswer;

    public synonymquestions(int id, String question, int image, String optionOne, String optionTwo, String optionThree, String optionFour, int correctAnswer) {
        this.id = id;
        this.question = question;
        this.image = image;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getImage() {
        return image;
    }

    public String getOptionOne() {
        return optionOne;
    }

    public String getOptionTwo() {
        return optionTwo;
    }

    public String getOptionThree() {
        return optionThree;
    }

    public String getOptionFour() {
        return optionFour;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
