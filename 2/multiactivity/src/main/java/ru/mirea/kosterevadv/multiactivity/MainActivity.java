package ru.mirea.kosterevadv.multiactivity;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "MainActivity_onCreate()");

        TextView tvView = (TextView) findViewById(R.id.editTextText);
        tvView.setText("MIREA - Костерева Дарья Викторовна");
    }

    public void onClickNewActivity(View view) {
        Log.i(TAG, "MainActivity_onClickNewActivity()");
        Intent intent = new Intent(this, SecondActivity.class);
        EditText editTextText = (EditText) findViewById(R.id.editTextText);
        String message = editTextText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);

//        intent.putExtra("key", "MIREA - Костерева Дарья Викторовна");
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "MainActivity_onStart()");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        Log.i(TAG,"MainActivity_onRestoreInstanceState()");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"MainActivity_onRestart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"MainActivity_onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"MainActivity_onPause()");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"MainActivity_onSaveInstanceState()");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"MainActivity_onStop()");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MainActivity_onDestroy()");
    }
}