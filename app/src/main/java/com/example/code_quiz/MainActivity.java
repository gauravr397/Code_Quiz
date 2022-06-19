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
        currPos = random.nextInt(quizmodalArrayList.size());


    }
    private void setdataToView(int currPos){

    }
    private void getQuizQuestions(ArrayList<Quizmodal> quizmodalArrayList) {
        quizmodalArrayList.add(new Quizmodal("Who invented Java Programming?","Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling"));
        quizmodalArrayList.add(new Quizmodal(" Which statement is true about Java?","Java is a sequence-dependent programming language","Java is a code dependent programming language","Java is a platform-dependent programming language","Java is a platform-independent programming language","Java is a platform-independent programming language"));
        quizmodalArrayList.add(new Quizmodal("Which component is used to compile, debug and execute the java programs?","JRE","JIT"," JDK","JVM"," JDK"));
        quizmodalArrayList.add(new Quizmodal("Which one of the following is not a Java feature?"," Object-oriented"," Use of pointers","Portable","Dynamic and Extensible"," Use of pointers"));

    }
}