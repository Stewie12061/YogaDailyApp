package vn.edu.huflit.yogadaily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class DetailActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 120000;
    TextView detailName, txtminute, txtsecond;
    ImageView detailImg;
    Button bunttonStartPause, buttonReset;
    boolean timerRunning;
    long timeLeftInMillis = START_TIME_IN_MILLIS;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Items items = (Items) intent.getSerializableExtra("item");


        detailImg = findViewById(R.id.detailImg);
        detailName = findViewById(R.id.detailName);

        detailImg.setImageResource(items.itemImg);
        detailName.setText(items.itemName);

        bunttonStartPause = findViewById(R.id.button_start_pause);
        buttonReset = findViewById(R.id.button_reset);
        txtminute = findViewById(R.id.minute);
        txtsecond = findViewById(R.id.second);

        bunttonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunning){
                    pauseTimer();
                }else {
                    startTimer();
                }
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                bunttonStartPause.setText("Start");
                bunttonStartPause.setVisibility(View.VISIBLE);
                buttonReset.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunning = true;
        bunttonStartPause.setText("Pause");
        buttonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        countDownTimer.cancel();
        timerRunning = false;
        bunttonStartPause.setText("Start");
        buttonReset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        timeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        bunttonStartPause.setVisibility(View.VISIBLE);
        buttonReset.setVisibility(View.INVISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormattedMinute = String.format(Locale.getDefault(),"%02d", minutes);
        String timeLeftFormattedSecond = String.format(Locale.getDefault(),"%02d", seconds);
        txtminute.setText(timeLeftFormattedMinute);
        txtsecond.setText(timeLeftFormattedSecond);
    }
}