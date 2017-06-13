package com.hufs.dev.yongjin.multimediapt;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout lec8 = (LinearLayout)findViewById(R.id.lec8);
        LinearLayout lec9 = (LinearLayout)findViewById(R.id.lec9);
        LinearLayout lec10 = (LinearLayout)findViewById(R.id.lec10);
        LinearLayout lec11 = (LinearLayout)findViewById(R.id.lec11);
        LinearLayout lec12 = (LinearLayout)findViewById(R.id.lec12);
        LinearLayout wordQuiz = (LinearLayout)findViewById(R.id.wordquiz);

        lec8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lecture8Activity.class);
                startActivity(intent);
            }
        });

        lec9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lecture9Activity.class);
                startActivity(intent);
            }
        });

        lec10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lecture10Activity.class);
                startActivity(intent);
            }
        });

        lec11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lecture11Activity.class);
                startActivity(intent);
            }
        });
        lec12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, lecture12Activity.class);
                startActivity(intent);
            }
        });
        wordQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });






    }


}
