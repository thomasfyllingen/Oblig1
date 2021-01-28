package com.example.oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Generates "the database"
    public void generateList(List<Image> imageList){
            Image image1 = new Image(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.kiwi), 70, 70, true), "kiwi");
            Image image2 = new Image(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pineapple), 70, 70, true), "pineapple");
            Image image3 = new Image(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.apple), 70, 70, true), "apple");
            imageList.add(image1);
            imageList.add(image2);
            imageList.add(image3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataHolder data = (DataHolder) getApplicationContext();
        List<Image> imageList = data.getList();
        if(imageList.isEmpty()){
            generateList(imageList);
        }
    }
    //Starts actvity InfoActivity
    public void infoButton(View view){
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
    //Starts activity QuizActivity
    public void takeQuiz(View view){
        Intent i = new Intent(this, QuizActivity.class);
        startActivity(i);
    }
}