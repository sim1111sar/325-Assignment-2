package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void change () {
        SharedPreferences preferences = getSharedPreferences("save", Context.MODE_PRIVATE);
        String list = preferences.getString("store", "Bonfire");

        ConstraintLayout layout = findViewById(R.id.mainlayout);
        if (list.equals("Castlevania")) {
            layout.setBackgroundResource(R.drawable.castlevania);
        }
        if (list.equals("Bonfire")) {
            layout.setBackgroundResource(R.drawable.bonfire);
        }
        if (list.equals("Metal Gear Solid")) {
            layout.setBackgroundResource(R.drawable.mgs);
        }
        if (list.equals("Fight Club")) {
            layout.setBackgroundResource(R.drawable.fight_club);
        }
    }

    public void settings(View view){
        Intent themesmenu = new Intent (this, SettingsMenu.class);
        startActivity(themesmenu);
    }

    @Override
    public void onResume(){
        super.onResume();

       change();

    }
}