package vn.edu.huflit.yogadaily;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class InfoActivity extends AppCompatActivity {

    Button btnContinute;
    EditText edtName, edtHeight, edtWeight, edtAge;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnContinute = findViewById(R.id.btnContinute);
        edtName = findViewById(R.id.edtName);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        edtAge = findViewById(R.id.edtAge);
        radioGroup = findViewById(R.id.radioGroup);



        btnContinute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(edtHeight.getText().toString().isEmpty()){
                    edtHeight.setError("You have to fill this information");
                }
                if(edtWeight.getText().toString().isEmpty()){
                    edtWeight.setError("You have to fill this information");
                }
                if(edtAge.getText().toString().isEmpty()){
                    edtAge.setError("You have to fill this information");
                    return;
                }
                if(edtName.getText().toString().isEmpty()){
                    edtName.setError("You have to fill this information");
                    return;
                }
                else {
                    editor.putString("height", edtHeight.getText().toString());
                    editor.putString("weight", edtWeight.getText().toString());
                    editor.putString("name", edtName.getText().toString());
                    editor.putString("age", edtAge.getText().toString());
                    editor.putBoolean("radio", true);
                    editor.apply();
                    editor.commit();
                    Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                    intent.putExtra("name", edtName.getText().toString());
                    startActivity(intent);
                    return;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
        String height  = sharedPreferences.getString("height", "");
        String weight = sharedPreferences.getString("weight", "");
        String name  = sharedPreferences.getString("name", "Gorgeous");
        String age = sharedPreferences.getString("age", "");
        boolean radiogr = sharedPreferences.getBoolean("radio",true);
        if (!height.isEmpty() && !weight.isEmpty() && !name.isEmpty() && !age.isEmpty()){
            edtName.setText(sharedPreferences.getString("name", ""));
            Intent intent = new Intent(InfoActivity.this, MainActivity.class);
            intent.putExtra("name", edtName.getText().toString());
            startActivity(intent);
        }

    }
}