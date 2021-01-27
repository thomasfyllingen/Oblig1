package com.example.oblig1;

import android.app.Application;
import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class DataHolder extends Application {

    List<Image> imageList = new ArrayList<>();



    List<Image> getList(){
        return imageList;
    }
    public void add(Bitmap image, String name){
        Image img1 = new Image(image, name);
        imageList.add(img1);
    }
    public void addImage(Image image){
        imageList.add(image);
    }
}
