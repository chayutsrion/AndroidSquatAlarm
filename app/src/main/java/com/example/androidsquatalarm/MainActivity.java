package com.example.androidsquatalarm;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.os.Vibrator;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity {

    private Timer _timer;
    private TextView txtTextView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTextView1 = (TextView) findViewById(R.id.txtTextMain);
        txtTextView1.setText("Squat 4");

        _timer = new Timer();
        _timer.schedule(new TimerTask() {
            public void run() {
                timerTick();
            }
        },0,20000);




    }

    private void timerTick()
    {
        LocalDateTime lolDt = LocalDateTime.now();
        if(lolDt.getHour() > 9 && lolDt.getHour() < 18 )
        {
            int iminute = lolDt.getMinute();
            if (iminute == 0/* || iminute == 30 || iminute == 33 */) {
                Vibrator v = (Vibrator) getSystemService(this.VIBRATOR_SERVICE);
                for ( int i =0;i <5 ;i++) {
                    MediaPlayer ring = MediaPlayer.create(MainActivity.this, R.raw.beep01a);
                    ring.start();
                    v.vibrate(500);
                    try{Thread.sleep(2000);}catch(InterruptedException e){System.out.println(e);}
                }
                long sleepTime = 60000;
                try{Thread.sleep(sleepTime);_timer.wait(sleepTime);}catch(InterruptedException e){System.out.println(e);}


            }
        }
    }
}
