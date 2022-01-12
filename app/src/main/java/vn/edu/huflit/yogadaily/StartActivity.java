package vn.edu.huflit.yogadaily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button btnStart, btnContinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = findViewById(R.id.btnStart);
        btnContinute = findViewById(R.id.btnContinute);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.clear();
                editor.commit();
                Intent intent = new Intent(StartActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

        btnContinute.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}