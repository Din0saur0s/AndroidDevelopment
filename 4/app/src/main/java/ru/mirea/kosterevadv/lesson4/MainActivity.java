package ru.mirea.kosterevadv.lesson4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.mirea.kosterevadv.lesson4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private	ActivityMainBinding	binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	=	ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(R.layout.activity_main);

        binding.editTextMirea.setText("Мой	номер	по	списку	№12");
        binding.buttonMirea.setOnClickListener(new	View.OnClickListener()	{
            @Override
            public	void onClick(View v)	{
                Log.d(MainActivity.class.getSimpleName(),"onClickListener");
            }
        });
    }
}