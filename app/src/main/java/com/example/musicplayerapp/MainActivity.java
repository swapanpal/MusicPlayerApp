package com.example.musicplayerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button playButton;
    Button pauseButton;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        mMediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ielts);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.start();
                Toast.makeText(getApplicationContext(),"Play",Toast.LENGTH_SHORT).show();
                // To show a pop up toast after completion the music
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(getApplicationContext(),"I'm done",Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMediaPlayer.pause();
                Toast.makeText( getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
