package com.example.oblig1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class InfoActivity extends Activity {

    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);

        DataHolder data = (DataHolder) getApplicationContext();
        List<Image> imageList = data.getList();


        myListView = findViewById(R.id.simpleListView);

        CustomAdapter customAdapter = new CustomAdapter();
        myListView.setAdapter(customAdapter);

    }
    public class CustomAdapter extends BaseAdapter {
        ListView myListView;

        DataHolder data = (DataHolder) getApplicationContext();
        List<Image> imageList = data.getList();

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.list_row, null);

            ImageView imgView = (ImageView) view.findViewById(R.id.imageviewLL);
            TextView mTextView = (TextView) view.findViewById(R.id.textViewLL);

            imgView.setImageBitmap(imageList.get(position).image);
            mTextView.setText(imageList.get(position).name);

            return view;
        }
    }
    public void addPicture(View view){
        Intent i = new Intent(this, UploadPhoto.class);
        startActivity(i);
    }
    public void removePicture(View view){
        Intent i = new Intent(this, DeletePhoto.class);
        startActivity(i);
    }
    public void navigation(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }


}