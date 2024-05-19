package com.example.myproject;

import java.util.ArrayList;

public class FlagConstants {

    public static final String USER_NAME = "user_name";
    public static final String TOTAL_QUESTIONS = "total_questions";
    public static final String CORRECT_ANSWER = "correct_answers";

    public static ArrayList<FlagQuestions> getQuestions() {
        ArrayList<FlagQuestions> questionsList = new ArrayList<>();

        // 1
        FlagQuestions que1 = new FlagQuestions(
                1, "What country does this flag belong to?",
                R.drawable.ic_flag_of_argentina,
                "Argentina", "Australia",
                "Armenia", "Austria", 1
        );
        questionsList.add(que1);

        // 2
        FlagQuestions que2 = new FlagQuestions(
                2, "What country does this flag belong to?",
                R.drawable.ic_flag_of_australia,
                "Angola", "Austria",
                "Australia", "Armenia", 3
        );
        questionsList.add(que2);

        // 3
        FlagQuestions que3= new FlagQuestions(
                3, "What country does this flag belong to?",
                R.drawable.ic_flag_of_brazil,
                "Belarus", "Belize",
                "Brunei", "Brazil", 4
        );
        questionsList.add(que3);

        // 4
        FlagQuestions que4 = new FlagQuestions(
                4, "What country does this flag belong to?",
                R.drawable.ic_flag_of_belgium,
                "Bahamas", "Belgium",
                "Barbados", "Belize", 2
        );
        questionsList.add(que4);

        // 5
        FlagQuestions que5 = new FlagQuestions(
                5, "What country does this flag belong to?",
                R.drawable.ic_flag_of_america,
                "Gabon", "France",
                "Amerika", "Finland", 3
        );
        questionsList.add(que5);

        // 6
        FlagQuestions que6 = new FlagQuestions(
                6, "What country does this flag belong to?",
                R.drawable.ic_flag_of_germany,
                "Germany", "Georgia",
                "Greece", "none of these", 1
        );
        questionsList.add(que6);

        // 7
        FlagQuestions que7 = new FlagQuestions(
                7, "What country does this flag belong to?",
                R.drawable.ic_flag_of_denmark,
                "Dominica", "Egypt",
                "Denmark", "Ethiopia", 3
        );
        questionsList.add(que7);

        // 8
        FlagQuestions que8 = new FlagQuestions(
                8, "What country does this flag belong to?",
                R.drawable.ic_flag_of_turkey,
                "Ireland", "Iran",
                "Hungary", "Türkiye", 4
        );
        questionsList.add(que8);

        // 9
        FlagQuestions que9= new FlagQuestions(
                9, "What country does this flag belong to?",
                R.drawable.ic_flag_of_italy,
                "Australia", "İtalya",
                "Tuvalu", "United States of America", 2
        );
        questionsList.add(que9);

        // 10
        FlagQuestions que10 = new FlagQuestions(
                10, "What country does this flag belong to?",
                R.drawable.ic_flag_of_canada,
                "Kanada", "Jordan",
                "Sudan", "Palestine", 1
        );
        questionsList.add(que10);

        return questionsList;
    }

    public static int MAX_PROGRESS_VALUE = 10;
}
