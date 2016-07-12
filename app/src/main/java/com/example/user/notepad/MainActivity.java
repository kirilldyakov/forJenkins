package com.example.user.notepad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final int IDM_OPEN = 101;
    public static final int IDM_SAVE = 102;
    public static final int IDM_EXIT = 103;

    public static final String FILENAME = "file.txt";

    private EditText edNotepad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNotepad = (EditText)findViewById(R.id.edNotepad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(menu.NONE, IDM_OPEN, menu.NONE, "Open")
                .setIcon(R.drawable.ic_menu_open)
                .setAlphabeticShortcut('o');

        menu.add(menu.NONE, IDM_SAVE, menu.NONE, "Save")
                .setIcon(R.drawable.ic_menu_save)
                .setAlphabeticShortcut('s');

        menu.add(menu.NONE, IDM_EXIT, menu.NONE, "Exit")
                .setIcon(R.drawable.ic_menu_exit)
                .setAlphabeticShortcut('x');

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case IDM_OPEN:
                openFile(FILENAME);
                break;
            case IDM_SAVE:
                saveFile(FILENAME);
                break;
            case IDM_EXIT:
                finish();
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void openFile(String fileName){

        try{
            InputStream inStream = openFileInput(fileName);

            if(inStream != null){
                InputStreamReader tmp = new InputStreamReader(inStream);
                BufferedReader buffer = new BufferedReader(tmp)
            }
        }
        catch (Throwable t){
            Toast.makeText(getApplicationContext()
                        , "Exception: " +t.toString()
                        ,Toast.LENGTH_LONG);
        }

    }

    public void saveFile(String fileName){

    }


}
