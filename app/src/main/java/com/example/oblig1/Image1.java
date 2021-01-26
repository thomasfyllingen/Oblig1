package com.example.oblig1;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import javax.xml.namespace.QName;

public class Image1 extends Application {
    int image;
    String name;

    public Image1(int image , String name){
        this.image = image;
        this.name = name;
    }
}
