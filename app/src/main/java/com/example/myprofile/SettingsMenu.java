package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SettingsMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);

        Spinner spinner = findViewById(R.id.spinner);
        Button confirm = findViewById(R.id.confirm);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String list = adapterView.getItemAtPosition(i).toString();
                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ArrayAdapter adapter = (ArrayAdapter) spinner.getAdapter();
                        int position = adapter.getPosition(list);

                        SharedPreferences preferences = getSharedPreferences("save", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("store", list);
                        editor.putInt("position", position);
                        editor.commit();
                        finish();
                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void last (){
        SharedPreferences sfs = getSharedPreferences("save", MODE_PRIVATE);
        int position =sfs.getInt("position", 0);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setSelection(position);
    }

    @Override
    public void onResume(){
        super.onResume();

        last();
    }

}