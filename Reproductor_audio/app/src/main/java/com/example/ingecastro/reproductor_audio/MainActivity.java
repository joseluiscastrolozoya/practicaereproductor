package com.example.ingecastro.reproductor_audio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button ini,pau,con,det,rep;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ini=(Button)findViewById(R.id.button);
        pau=(Button)findViewById(R.id.button2);
        con=(Button)findViewById(R.id.button3);
        det=(Button)findViewById(R.id.button4);


        ini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                destruir();
                mp=MediaPlayer.create(MainActivity.this,R.raw.queen);
                mp.start();

            }
        });
        pau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null && mp.isPlaying()) {
                    posicion = mp.getCurrentPosition();
                    mp.pause();
                }
            }
        });
        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null && mp.isPlaying() == false) {
                    mp.seekTo(posicion);
                    mp.start();
                }
            }
        });
        det.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null) {
                    mp.stop();
                    posicion = 0;
                }

            }
        });
    }

    public void destruir() {
        if (mp != null)
            mp.release();}

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
