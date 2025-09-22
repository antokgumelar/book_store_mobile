package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.VideoView2);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);

        // Atur MediaController untuk mengontrol pemutaran video
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}