package ru.mirea.kosterevadv.data_thread;

import androidx.appcompat.app.AppCompatActivity;
import ru.mirea.kosterevadv.data_thread.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.widget.TextView;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        text = findViewById(R.id.textView);

        final Runnable runn1 = new Runnable() {
            public void run() {
                binding.textView.setText("runn1");
            }
        };
        final Runnable runn2 = new Runnable() {
            public void run() {
                binding.textView.setText("runn2");
            }
        };
        final Runnable runn3 = new Runnable() {
            public void run() {
                binding.textView.setText("runn3");
            }
        };
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    runOnUiThread(runn1);
                    TimeUnit.SECONDS.sleep(1);
                    binding.textView.postDelayed(runn3, 2000);
                    binding.textView.post(runn2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        text.setText("Запуск процессов: runn1 -> runn2 -> runn3");
        text.append("runOnUiThread, post отправляют Runnable на немедленную обработку; postDelayed позволяет указать задержку выполнения Runnable.");
        text.append("runOnUiThread - метод принимает объект Runnable в качестве параметра; post - метод принимает объект Runnable и задержку в миллисекундах в качестве параметров; postDelayed - метод принимает объект Runnable в качестве параметра.");
    }
}