package com.example.oblig1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class DeletePhoto extends AppCompatActivity implements View.OnClickListener{
    Button deleteButton;
    String namePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_photo);

         deleteButton = (Button) findViewById(R.id.DeleteButton);
    }

    @Override
    public void onClick(View view){
        if(view == deleteButton){
            DataHolder data = (DataHolder) getApplicationContext();
            List<Image> imageList = data.getList();
            EditText deleteNameText = findViewById(R.id.deleteNameText);
            namePic = deleteNameText.getText().toString();
            for (Image i : imageList){
                if(namePic.equals(i.name)){
                    imageList.remove(i);
                    Toast.makeText(this, "Picture removed", Toast.LENGTH_LONG).show();
                    return;
                }
            }
            Toast.makeText(this, "Picture wasn't removed, the name must be spelled correctly", Toast.LENGTH_LONG).show();
        }
    }

    public void navigation(View view){
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }
}