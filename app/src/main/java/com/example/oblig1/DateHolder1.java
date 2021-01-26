package com.example.oblig1;

import android.app.Application;
import android.media.Image;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DateHolder1 extends Application {
    Image1 image1= new Image1(R.drawable.kiwi, "kiwi");
    Image1 image2= new Image1(R.drawable.pineapple,"pineapple");
    Image1 image3= new Image1(R.drawable.apple, "apple");
    Image1 image4= new Image1(R.drawable.avacado, "avacado");
    Image1 image5= new Image1(R.drawable.banana, "banana");
    Image1 image6= new Image1(R.drawable.cherry, "cherry");
    Image1 image7= new Image1(R.drawable.grape, "grape");

    List<Image1> imageList = Arrays.asList(image1,image2,image3,image4,image5,image6,image7);

    List<Image1> getList(){
        return imageList;
    }
    public void add(Image1 I){
        imageList.add(I);
    }
}
