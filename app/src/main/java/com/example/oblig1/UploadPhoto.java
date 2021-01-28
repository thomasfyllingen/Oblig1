package com.example.oblig1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class UploadPhoto extends AppCompatActivity implements View.OnClickListener {

    private Button buttonChoose;
    private ImageView imageView;
    private Button buttonSubmit;
    private Uri filePath;
    private Bitmap bitmap;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private static final int PICK_IMAGE_REQUEST = 234;
    String namePic;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_photo);

        buttonChoose = (Button) findViewById(R.id.ChooseButton);
        buttonSubmit = (Button) findViewById(R.id.SubmitButton);
        imageView = (ImageView) findViewById(R.id.image1);

        buttonChoose.setOnClickListener(this);
        buttonSubmit.setOnClickListener(this);
    }

    //Creating the choose file popup
    private void showFileChooser(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    //Deciding what to do with the image from the previous method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            try{
                bitmap = MediaStore. Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
                buttonSubmit.setVisibility(1);
            }catch(IOException io){

            }
        }
    }

    //Starts file chooser if the choose button was pressed
    //or submits the image to the "database" if the submit button was pressed
    @Override
    public void onClick(View view){
        if(view == buttonChoose){
        showFileChooser();
        }
        if (view == buttonSubmit) {
            DataHolder data = (DataHolder) getApplicationContext();
            List<Image> imageList = data.getList();
            EditText editTextName1 = findViewById(R.id.editTextName1);
            namePic = editTextName1.getText().toString();
            imageList.add(new Image(bitmap, namePic ));
            Toast.makeText(this, "Picture added", Toast.LENGTH_LONG).show();
        }

    }
    //Navigating back
    public void navigation(View view){
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
}