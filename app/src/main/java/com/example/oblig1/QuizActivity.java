package com.example.oblig1;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;

public class QuizActivity  extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Random r;

    int pickedImage;

    TextView poengTextView;
    TextView resulTextView;
    TextView cheatTextView;
    TextView answerTextView;
    int poeng;
    int resultat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        imageView =(ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.answerButton);

        DateHolder1 data = (DateHolder1) getApplicationContext();
        List<Image1> imageList = data.getList();

        r= new Random();
        pickedImage= r.nextInt(imageList.size());
        imageView.setImageResource(imageList.get(pickedImage).image);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText answerText =(EditText) findViewById(R.id.svarEditText1);
                String answer = answerText.getText().toString();

                answerTextView=(TextView) findViewById(R.id.answereTextID);
                answerTextView.setText(answer);

                // Setter poengsummen

                if (answer.equals(imageList.get(pickedImage).name)){
                    poengTextView = (TextView) findViewById(R.id.poengTextView1);
                    poeng++;
                    poengTextView.setText(Integer.toString(poeng));
                } else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
                    TextView toastl = layout.findViewById(R.id.toastTextView1);
                    String correctAnswere = imageList.get(pickedImage).name;
                    toastl.setText("Correct answere was: " + correctAnswere );
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER, 0 , 350 );
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

                }


                // setter antall forsøk
                resulTextView =(TextView) findViewById(R.id.resultatTextView1);
                resultat ++;
                resulTextView.setText(Integer.toString(resultat));
                // Finnet ut hva som ble svart

                // setter tilfeldig bilde
                pickedImage= r.nextInt(imageList.size());
                imageView.setImageResource(imageList.get(pickedImage).image);
                // se riktig svar
                cheatTextView = (TextView) findViewById(R.id.cheatTextView1);
                cheatTextView.setText(imageList.get(pickedImage).name);

            }
        });


    }



}
