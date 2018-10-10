package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class SettingOption extends AppCompatActivity implements View.OnClickListener{


    Switch soundSwitch;
    Switch vibratorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_item_setting);

        soundSwitch = (Switch) findViewById (R.id.fis_soundSwitch);
        vibratorSwitch = (Switch) findViewById (R.id.fis_VibratorSwitch);

        soundSwitch.setOnClickListener(this);
        vibratorSwitch = (Switch) findViewById (R.id.fis_VibratorSwitch);

    }

    @Override
    public void onClick(View view){

        if (view == vibratorSwitch){

            Vibrator vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(new long[]{500,1000,500,1000},-1);

        }

        if (view == soundSwitch){

            MediaPlayer player = MediaPlayer.create(this,R.raw.correct1);
            player.start();

        }
    }

}
