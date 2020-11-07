package com.example.examenunidad4;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class winner extends AppCompatActivity {

    Integer[] images={
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ponerImagen();
    }
    public void ponerImagen(){
        ImageView dado1 = (ImageView) findViewById(R.id.dad1);
        ImageView dado2 = (ImageView) findViewById(R.id.dad2);
        //obtner el numero de lado para el dado del activy principa;
        int rol1 =  getIntent().getIntExtra("dado1",0);
        int rol2 = getIntent().getIntExtra("dado2",0);
        //Poner la imgaen imageview
        dado1.setImageResource(images[rol1]);
        dado2.setImageResource(images[rol2]);

    }
    public void goBack(View view){
        Intent ite = new Intent(this,MainActivity.class);
        startActivity(ite);
    }
}