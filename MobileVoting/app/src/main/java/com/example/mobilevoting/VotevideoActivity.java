package com.example.mobilevoting;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.mobilevoting.R;

public class VotevideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votevideo);
        String fileName="voterr";

        String filePlace ="android.resource://"+getPackageName()+"/raw/"+fileName;
        VideoView videoView=(VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(filePlace));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView.setMediaController(new MediaController(this));
        videoView.start();
    }
}
