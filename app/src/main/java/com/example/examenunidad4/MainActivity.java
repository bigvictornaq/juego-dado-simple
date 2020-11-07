package com.example.examenunidad4;

import android.content.Intent;
import android.media.MediaParser;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random lados = new Random();
   //Arreglo con las imagenes
    Integer[] images={
           R.drawable.img_1,
           R.drawable.img_2,
           R.drawable.img_3,
           R.drawable.img_4,
           R.drawable.img_5,
           R.drawable.img_6,
    };
    int roll;
    int roll2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }


    public void goMaster(View view){

        TextView txtDado1 = findViewById(R.id.txt_dado1);
        TextView txtDado2 = findViewById(R.id.txt_dado2);

        ImageView dado1 = (ImageView) findViewById(R.id.dado1);
        ImageView dado2 = (ImageView) findViewById(R.id.dado2);

        roll = lados.nextInt(images.length);
        roll2 = lados.nextInt(images.length);

        dado1.setImageResource(images[roll]);
        dado2.setImageResource(images[roll2]);

        int num1 = roll + 1;
        int num2 = roll2 +1;
        txtDado1.setText("N: " + num1 );
        txtDado2.setText("N: " + num2);

        if (roll == roll2){
            Toast.makeText(this, "AAAA GANASTES!!!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,winner.class);
            intent.putExtra("dado1",roll);
            intent.putExtra("dado2",roll2);
            startActivity(intent);
        }else{
            Toast.makeText(this, "JAJAJA perdistes L O S E R", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}