package com.mtech.parttimeone.photolearn.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mtech.parttimeone.photolearn.R;

public class CreateQuizTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz_title);

        this.setTitle("Create Learning Title");
    }
}