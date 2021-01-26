package com.example.oblig1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
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

        DateHolder1 data = (DateHolder1) getApplicationContext();
        List<Image1> imageList = data.getList();


        myListView = findViewById(R.id.simpleListView);

        CustomeAdapter customeAdapter = new CustomeAdapter();
        myListView.setAdapter(customeAdapter);

    }
    public class CustomeAdapter extends BaseAdapter {
        ListView myListView;

        DateHolder1 data = (DateHolder1) getApplicationContext();
        List<Image1> imageList = data.getList();

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

            imgView.setImageResource(imageList.get(position).image);
            mTextView.setText(imageList.get(position).name);

            return view;
        }
    }


}