package vn.edu.huflit.yogadaily;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

import com.agrawalsuneet.dotsloader.loaders.TashieLoader;

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
              @Override
              public void run() {
                  Intent intent = new Intent(WelcomeActivity.this, StartActivity.class);
                  startActivity(intent);
              }
          },5000
        );

    }
}