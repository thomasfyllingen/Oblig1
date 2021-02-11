package com.example.oblig1;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import javax.xml.namespace.QName;

@Entity
public class Image extends Application {
    @NonNull
    @PrimaryKey
    String image;
    String name;

    public Image(String image , String name){
        this.image = image;
        this.name = name;
    }

    @NonNull
    public String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
