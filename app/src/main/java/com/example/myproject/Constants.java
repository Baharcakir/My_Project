package com.example.myproject;

import java.util.ArrayList;

public class Constants {

    public static final String TOTAL_QUESTIONS = "total_questions";
    public static final String CORRECT_ANSWER = "correct_answers";

    public static ArrayList<synonymquestions> getQuestions() {
        ArrayList<synonymquestions> questionsList = new ArrayList<>();

        // 1
        synonymquestions que1 = new synonymquestions(
                1, "Öğretmen kelimesinin eş anlamlısı nedir?",
                R.drawable.teacher,
                "Muallim", "Mektep",
                "Talebe", "Austria", 1
        );
        questionsList.add(que1);

        // 2
        synonymquestions que2 = new synonymquestions(
                2, "Siyah kelimesinin eş anlamlısı nedir?",
                R.drawable.black,
                "Beyaz", "Al",
                "Kara", "Turuncu", 3
        );
        questionsList.add(que2);

        // 3
        synonymquestions que3 = new synonymquestions(
                3, "Kırmızı kelimesinin eş anlamlısı nedir?",
                R.drawable.red,
                "Siyah", "Pembe",
                "Kara", "Al", 4
        );
        questionsList.add(que3);

        // 4
        synonymquestions que4 = new synonymquestions(
                4, "Zengin kelimesinin eş anlamlısı nedir?",
                R.drawable.money,
                "Fakir", "Varlıklı",
                "Barbados", "Belize", 2
        );
        questionsList.add(que4);

        // 5
        synonymquestions que5 = new synonymquestions(
                5, "Sınav kelimesinin eş anlamlısı nedir?",
                R.drawable.exam,
                "Gabon", "France",
                "İmtihan", "Finland", 3
        );
        questionsList.add(que5);

        // 6
        synonymquestions que6 = new synonymquestions(
                6, "Hediye kelimesinin eş anlamlısı nedir?",
                R.drawable.gift,
                "Armağan", "Georgia",
                "Greece", "none of these", 1
        );
        questionsList.add(que6);

        // 7
        synonymquestions que7 = new synonymquestions(
                7, "Sonbahar kelimesinin eş anlamlısı nedir?",
                R.drawable.autumn,
                "Dominica", "Egypt",
                "Güz", "Ethiopia", 3
        );
        questionsList.add(que7);

        // 8
        synonymquestions que8 = new synonymquestions(
                8, "Zaman kelimesinin eş anlamlısı nedir?",
                R.drawable.time,
                "Ireland", "Iran",
                "Hungary", "Vakit", 4
        );
        questionsList.add(que8);

        // 9
        synonymquestions que9 = new synonymquestions(
                9, "Okul kelimesinin eş anlamlısı nedir?",
                R.drawable.school,
                "Australia", "Mektep",
                "Tuvalu", "United States of America", 2
        );
        questionsList.add(que9);

        // 10
        synonymquestions que10 = new synonymquestions(
                10, "Ev kelimesinin eş anlamlısı nedir?",
                R.drawable.home,
                "Konut", "Jordan",
                "Sudan", "Palestine", 1
        );
        questionsList.add(que10);

        return questionsList;
    }

    public static int MAX_PROGRESS_VALUE = 10;
}
