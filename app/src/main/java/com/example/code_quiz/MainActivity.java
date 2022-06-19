package com.example.code_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV, questionNumberTv;
    private Button option1btn, option2btn,option3btn,option4btn;
    private ArrayList<Quizmodal> quizmodalArrayList;
    Random random;
    int currScore = 0,questionAttempted=1, currPos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTV = findViewById(R.id.idTvQuestion);
        questionNumberTv = findViewById(R.id.idTVQuestionAttempted);
        option1btn = findViewById(R.id.Btnoption1);
        option2btn = findViewById(R.id.Btnoption2);
        option3btn = findViewById(R.id.Btnoption3);
        option4btn = findViewById(R.id.Btnoption4);

        quizmodalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestions(quizmodalArrayList);

    }
    private void getQuizQuestions(ArrayList<Quizmodal> quizmodalArrayList) {
        quizmodalArrayList.add(new Quizmodal("Who invented Java Programming?",""))

    }
}