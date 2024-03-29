package ru.mirea.kosterevadv.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        editText = (EditText) findViewById(R.id.editText);
        int l = editText.getText().toString().length();
        str = String.format("СТУДЕНТ №12 ГРУППА БИСО-03-19 Количество символов - %d",l);
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}