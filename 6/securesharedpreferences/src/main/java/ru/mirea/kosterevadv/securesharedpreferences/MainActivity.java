package ru.mirea.kosterevadv.securesharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKeys;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.security.keystore.KeyGenParameterSpec;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {
    private static final String SECURE_PREFS_FILE = "MySecurePrefs";
    private static final String KEY_POET_NAME = "poetName";
    private SharedPreferences secureSharedPreferences;
    private TextView poetNameTextView;
    private ImageView poetImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poetNameTextView = findViewById(R.id.textView);
        poetImageView = findViewById(R.id.imageView);

        KeyGenParameterSpec keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC;
        try {
            String mainKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec);
            secureSharedPreferences = EncryptedSharedPreferences.create(
                    "secret_shared_prefs",
                    mainKeyAlias,
                    getBaseContext(),
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
            secureSharedPreferences.edit().putString("secure", "Джордж Гордон Байрон").apply();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Получаем сохраненное имя поэта из SecureSharedPreferences
        String result = secureSharedPreferences.getString("secure", "");

        // Устанавливаем имя поэта на экран
        poetNameTextView.setText(result);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.byron);
        poetImageView.setImageBitmap(bitmap);
    }
}