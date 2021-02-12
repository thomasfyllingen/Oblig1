package com.example.oblig1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
import androidx.room.Room;

import java.util.List;
import java.util.Random;

public class QuizActivity  extends AppCompatActivity {

    ImageView imageView;
    Button button;
    Random r;

    int pickedImage;

    TextView poengTextView;
    TextView resulTextView;
    int poeng = 0;
    int resultat;
    List<Image> imageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        imageView =(ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.answerButton);

        ImageDatabase db = ImageDatabase.getDatabase(this);
        imageList = db.imageDAO().getAll();
        r= new Random();
        pickedImage= r.nextInt(imageList.size());
        imageView.setImageURI(Uri.parse(imageList.get(pickedImage).image));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText answerText =(EditText) findViewById(R.id.svarEditText1);
                String answer = answerText.getText().toString();

                // Setter poengsummen
                if (answer.equals(imageList.get(pickedImage).name)){
                    poengTextView = (TextView) findViewById(R.id.poengTextView1);
                    poeng++;
                    poengTextView.setText(Integer.toString(poeng));
                } else{
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));
                    TextView toastl = layout.findViewById(R.id.toastTextView1);
                    String correctAnswer = imageList.get(pickedImage).name;
                    toastl.setText("Correct answer was: " + correctAnswer );
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
                imageView.setImageURI(Uri.parse(imageList.get(pickedImage).image));

                answerText.setText("");
            }

        });
    }
    //Navigate back
    public void navigation(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
