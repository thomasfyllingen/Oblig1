package com.example.oblig1;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;

import javax.xml.namespace.QName;

public class Image extends Application {
    Bitmap image;
    String name;

    public Image(Bitmap image , String name){
        this.image = image;
        this.name = name;
    }
}
