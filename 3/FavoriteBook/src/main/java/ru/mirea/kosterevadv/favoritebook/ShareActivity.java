package ru.mirea.kosterevadv.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

public class ShareActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        editText = findViewById(R.id.editTextText);
        // Получение данных из MainActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView ageView = findViewById(R.id.textView);
            String university = extras.getString(MainActivity.KEY);
        }
    }
    public void onButtonClick(View view) {
// Отправка введенных пользователем данных по нажатию на кнопку
        Intent data = new Intent();
        //ageView.setText(String.format("Мой любимая книга: %s", university));
        String book = "Моя любимая книга: " + editText.getText().toString();
        data.putExtra(MainActivity.USER_MESSAGE, book );
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}