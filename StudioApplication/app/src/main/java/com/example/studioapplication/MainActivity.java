package com.example.studioapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.studioapplication.databinding.ActivityMainBinding;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private static int MICROPHONE_PERMISSION_CODE = 200;
    MediaRecorder mediaRecorder;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main); TODO IDK WHAT HE DID BUT HE REMOVED THE PARAMETERS HERE I DIDNT WANT TO DELETE :)
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        if(isMicrophonePresent()) {
            getMicrophonePermission();
        }
        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home_button:
                    replaceFragment(new HomeFragment());
//                    setContentView(R.layout.fragment_home);
                    break;
                case R.id.person_button:
                    replaceFragment(new PersonFragment());
//                    setContentView(R.layout.fragment_person);
                    break;
                case R.id.settings_button:
                    replaceFragment(new SettingsFragment());
//                    setContentView(R.layout.fragment_home);
                    break;



            }
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_id,fragment);
        fragmentTransaction.commit();
    }

    //CODE FOR SETTINGS FRAGMENT

    public void btnRecordPressed(View v) {

        try{
            mediaRecorder = new MediaRecorder();
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); //TODO DID STRING VALUE OF {ORIGINALLY IS NOT SUPPOSED TO BE HERE}
            mediaRecorder.setOutputFile(getRecordingFilePath());
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();
            Toast.makeText(this,"Recording",Toast.LENGTH_SHORT).show();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void btnStopPressed(View v) {
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;

        Toast.makeText(this,"Recording Stopped",Toast.LENGTH_SHORT).show();

    }
    public void btnPlayPressed(View v) {
        try{
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(getRecordingFilePath());
            mediaPlayer.prepare();
            mediaPlayer.start();
            Toast.makeText(this,"Recording Playing",Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private boolean isMicrophonePresent() {
        if(this.getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            return true;
        } else {
            return false;
        }
    }

    private void getMicrophonePermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.RECORD_AUDIO},MICROPHONE_PERMISSION_CODE);
        }
    }

    private String getRecordingFilePath() {
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());
        File musicDirectory = contextWrapper.getExternalFilesDir(".");
        Log.d("D", Environment.DIRECTORY_MUSIC);
        File file = new File(musicDirectory,"testRecordingFile"+".mp3");
        return file.getPath();
//        return Environment.getExternalStorageDirectory().getAbsolutePath()+"/"+
//                CreateRandomName(5) + ".mp3";
    }

    String RandomAudioFileName = "ABCDEFGHIJKLMNOP";
    public String CreateRandomName(int length){
        StringBuilder stringBuilder = new StringBuilder( length );
        Random random = new Random();
        for(int i = 0; i < length; i++ ) {
            stringBuilder.append(RandomAudioFileName.
                    charAt(random.nextInt(RandomAudioFileName.length())));
        }
        return stringBuilder.toString();
    }
}