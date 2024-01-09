package com.yudiasmara2355201568.yudiasmara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuCardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_card_view);
    }
    public void profil(View view){
         Intent i = new Intent(this, Profil.class);
         startActivity(i);

     }
     public void sejarah(View view){
        Intent i = new Intent(this, KontenScrolling.class);
        startActivity(i);
     }
     public void github(View view){
        Intent i = new Intent(this, WebViews.class);
        startActivity(i);
     }

     public void kalkulator(View view){
        Intent i = new Intent(this, KalkulatorIcikiwir.class);
        startActivity(i);
     }

     public void sosmed(View view){
        Intent i = new Intent(this, SosialMedia.class);
        startActivity(i);
     }
     public  void biodata(View view){
        Intent i = new Intent(this, TabsActivity.class);
        startActivity(i);
     }
     public void puzzle(View view){
        Intent i = new Intent(this, PuzzleGame.class);
        startActivity(i);
     }
}