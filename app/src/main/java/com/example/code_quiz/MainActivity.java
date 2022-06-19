package com.example.code_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;
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
        setDataToView(currPos);
        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalArrayList.get(currPos).getAnswer().trim().toLowerCase().equals(option1btn.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questionAttempted++;
                currPos= random.nextInt(quizmodalArrayList.size());
                setDataToView(currPos);
            }
        });

        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalArrayList.get(currPos).getAnswer().trim().toLowerCase().equals(option2btn.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questionAttempted++;
                currPos= random.nextInt(quizmodalArrayList.size());
                setDataToView(currPos);
            }
        });

        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalArrayList.get(currPos).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase())){
                    currScore++;
                }
                questionAttempted++;
                currPos= random.nextInt(quizmodalArrayList.size());
                setDataToView(currPos);
            }
        });

        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizmodalArrayList.get(currPos).getAnswer().trim().toLowerCase().equals(option4btn.getText().toString().trim().toLowerCase())) {
                    currScore++;
                }
                questionAttempted++;
                currPos = random.nextInt(quizmodalArrayList.size());
                setDataToView(currPos);

            }

        });

        private void showbottomsheet(){
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
            View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_sheet,(LinearLayout)findViewById(R.id.llscore));
            TextView scoreTV=bottomSheetView.findViewById((R.id.llscore));
            Button restartquizbtn = bottomSheetView.findViewById(R.id.BtnRestart);
            scoreTV.setText("Your Score is \n"+currScore + "/10");
            restartquizbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    currPos= random.nextInt(quizmodalArrayList.size());
                    setDataToView(currPos);
                    questionAttempted=1;
                    currScore=0;
                    bottomSheetDialog.dismiss();
                }
            });
            bottomSheetDialog.setCancelable(false);
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();
        }


    }
    private void setDataToView(int currPos){
        questionNumberTv.setText("Question Attempted : "+questionAttempted+"/10");

        questionTV.setText(quizmodalArrayList.get(currPos).getQuestion());
        option1btn.setText(quizmodalArrayList.get(currPos).getOption1());
        option2btn.setText(quizmodalArrayList.get(currPos).getOption2());
        option3btn.setText(quizmodalArrayList.get(currPos).getOption3());
        option4btn.setText(quizmodalArrayList.get(currPos).getOption4());

    }
    private void getQuizQuestions(ArrayList<Quizmodal> quizmodalArrayList) {
        quizmodalArrayList.add(new Quizmodal("Who invented Java Programming?","Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup","James Gosling"));
        quizmodalArrayList.add(new Quizmodal(" Which statement is true about Java?","Java is a sequence-dependent programming language","Java is a code dependent programming language","Java is a platform-dependent programming language","Java is a platform-independent programming language","Java is a platform-independent programming language"));
        quizmodalArrayList.add(new Quizmodal("Which component is used to compile, debug and execute the java programs?","JRE","JIT"," JDK","JVM"," JDK"));
        quizmodalArrayList.add(new Quizmodal("Which one of the following is not a Java feature?"," Object-oriented"," Use of pointers","Portable","Dynamic and Extensible"," Use of pointers"));
        quizmodalArrayList.add(new Quizmodal("Which of these cannot be used for a variable name in Java?","identifier & keyword","identifier"," keyword","none of the mentioned"," keyword"));
        quizmodalArrayList.add(new Quizmodal("What is the extension of java code files?",".js",".txt",".class",".java",".java"));
        quizmodalArrayList.add(new Quizmodal("Which environment variable is used to set the java path?","MAVEN_Path"," JavaPATH"," JAVA"," JAVA_HOME"," AVA_HOME"));
        quizmodalArrayList.add(new Quizmodal( "Which of the following is not an OOPS concept in Java?","Polymorphism","Inheritance"," Compilation"," Encapsulation"," Compilation"));
        quizmodalArrayList.add(new Quizmodal("What is not the use of “this” keyword in Java?","Referring to the instance variable when a local variable has the same name"," Passing itself to the method of the same class","Passing itself to another method","Calling another constructor in constructor chaining"," Passing itself to the method of the same class"));
        quizmodalArrayList.add(new Quizmodal("What will be the error in the following Java code?\n" +
                "\n" +
                "    byte b = 50;\n" +
                "    b = b * 50;"," b cannot contain value 50"," b cannot contain value 100, limited by its range","No error in this code","* operator has converted b * 50 into int, which can not be converted to byte without casting","* operator has converted b * 50 into int, which can not be converted to byte without casting"));

    }
}