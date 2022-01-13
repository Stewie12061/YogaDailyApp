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

public class DetailppActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLISpp = 120000;
    TextView detailNamepp, txtminutepp, txtsecondpp;
    ImageView detailImgpp;
    Button bunttonStartPausepp, buttonResetpp;
    boolean timerRunningpp;
    long timeLeftInMillispp = START_TIME_IN_MILLISpp;
    CountDownTimer countDownTimerpp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpp);

        Intent intent = getIntent();
        PopularPoses popularPoses = (PopularPoses) intent.getSerializableExtra("popularPoses");


        detailImgpp = findViewById(R.id.detailppImg);
        detailNamepp = findViewById(R.id.detailppName);

        detailImgpp.setImageResource(popularPoses.image);
        detailNamepp.setText(popularPoses.name);

        bunttonStartPausepp = findViewById(R.id.button_start_pausepp);
        buttonResetpp = findViewById(R.id.button_resetpp);
        txtminutepp = findViewById(R.id.minutepp);
        txtsecondpp = findViewById(R.id.secondpp);

        bunttonStartPausepp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (timerRunningpp){
                    pauseTimer();
                }else {
                    startTimer();
                }
            }
        });

        buttonResetpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    private void startTimer(){
        countDownTimerpp = new CountDownTimer(timeLeftInMillispp, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillispp = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timerRunningpp = false;
                bunttonStartPausepp.setText("Start");
                bunttonStartPausepp.setVisibility(View.VISIBLE);
                buttonResetpp.setVisibility(View.INVISIBLE);
            }
        }.start();

        timerRunningpp = true;
        bunttonStartPausepp.setText("Pause");
        buttonResetpp.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        countDownTimerpp.cancel();
        timerRunningpp = false;
        bunttonStartPausepp.setText("Start");
        buttonResetpp.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        timeLeftInMillispp = START_TIME_IN_MILLISpp;
        updateCountDownText();
        bunttonStartPausepp.setVisibility(View.VISIBLE);
        buttonResetpp.setVisibility(View.INVISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (timeLeftInMillispp / 1000) / 60;
        int seconds = (int) (timeLeftInMillispp / 1000) % 60;

        String timeLeftFormattedMinute = String.format(Locale.getDefault(),"%02d", minutes);
        String timeLeftFormattedSecond = String.format(Locale.getDefault(),"%02d", seconds);
        txtminutepp.setText(timeLeftFormattedMinute);
        txtsecondpp.setText(timeLeftFormattedSecond);
    }
}