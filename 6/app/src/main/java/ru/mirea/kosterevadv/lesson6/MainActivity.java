package ru.mirea.kosterevadv.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    EditText groupEditText, numberEditText, movieEditText;
    Button saveButton;
    private static final String PREFS_FILE = "Preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupEditText = findViewById(R.id.groupEditText);
        numberEditText = findViewById(R.id.numberEditText);
        movieEditText = findViewById(R.id.movieEditText);
        saveButton = findViewById(R.id.saveButton);

        // Загрузка сохраненных значений из SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        groupEditText.setText(sharedPreferences.getString("Group", ""));
        numberEditText.setText(sharedPreferences.getString("Number", ""));
        movieEditText.setText(sharedPreferences.getString("Favorite movie", ""));

        // Обработчик нажатия кнопки сохранения
        saveButton.setOnClickListener(v -> saveData());
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("groupNumber", groupEditText.getText().toString());
        editor.putString("listNumber", numberEditText.getText().toString());
        editor.putString("favoriteMovie", movieEditText.getText().toString());
        editor.apply();
    }
}