package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] question = {"Java is oops", "Constructor Name is Same as Class", "Java is developed in the year 1995", "Java is a person", "Java is Platform independent", "Garbage Collection is manual process"};
    boolean[] answer = {true, true, true, false, true, false};
    int index = 0, score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = (TextView) findViewById(R.id.t);
        Button b1 = (Button) findViewById(R.id.b1);
        Button b2 = (Button)findViewById(R.id.b2);
        t.setText(question[index]);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(index < question.length){
                        if(answer[index] == true){
                            score++;
                        }
                        t.setText(question[++index]);
                    }
                    else{
                        t.setText("Your Score is: " + score);
                    }
                }
                catch (Exception e){
                    openActivity2();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(index < question.length){
                        if(answer[index] == false){
                            score++;
                        }
                        t.setText(question[++index]);
                    }
                    else{
                        t.setText("Your Score is: " + Integer.toString(score));
                    }
                }
                catch (Exception e){
                    openActivity2();
                }
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("score", String.valueOf(score));
        startActivity(intent);
    }
}