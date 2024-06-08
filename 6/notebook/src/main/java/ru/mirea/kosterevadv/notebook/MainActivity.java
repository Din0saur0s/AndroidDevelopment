package ru.mirea.kosterevadv.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static String FILE_NAME = "quote_file.txt"; // имя файла по умолчанию
    private EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveFile (View view){
        EditText myEditText = findViewById(R.id.editTextFile);
        FILE_NAME = myEditText.getText().toString();

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, FILE_NAME);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            EditText textBox = findViewById(R.id.editTextQuote);
            String text = textBox.getText().toString();

            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(this, "Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void loadFile(View view){
        EditText mEditText = findViewById(R.id.editTextFile);
        FILE_NAME = mEditText.getText().toString();


        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(path, FILE_NAME);

        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file.getAbsoluteFile());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        TextView textView = findViewById(R.id.editTextQuote);
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            textView.setText(text);
            Toast.makeText(this, "Файл успешно открыт", Toast.LENGTH_SHORT).show();
        }
        catch(IOException ex) {

            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){

                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

}