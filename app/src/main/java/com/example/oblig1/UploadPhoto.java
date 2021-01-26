package com.example.oblig1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;

public class UploadPhoto extends AppCompatActivity implements View.OnClickListener {

    private Button buttonChoose;
    private ImageView imageView;
    private Button buttonSubmit;
    private String name;
    private Uri filePath;
    private Bitmap bitmap;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private static final int PICK_IMAGE_REQUEST = 234;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_photo);

        requestStoragePermission();

        buttonChoose = (Button) findViewById(R.id.ChooseButton);
        buttonSubmit = (Button) findViewById(R.id.SubmitButton);
        imageView = (ImageView) findViewById(R.id.image1);

        buttonChoose.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);

    }

    private void requestStoragePermission(){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == STORAGE_PERMISSION_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission granted", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show();
        }
    }

    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            try{
                bitmap = MediaStore. Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            }catch(IOException io){

            }
        }
    }

    @Override
    public void onClick(View view){

        if(view == buttonChoose){
        showFileChooser();
        }

    }
}