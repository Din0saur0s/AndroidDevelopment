package ru.mirea.kosterevadv.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_2);

        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("time").toString();

        TextView textView = new TextView(this);
        String company = arguments.getString("time");
        textView.setText(company);

        setContentView(textView);
    }
}