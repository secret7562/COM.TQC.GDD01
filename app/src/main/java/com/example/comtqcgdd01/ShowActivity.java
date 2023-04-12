package com.example.comtqcgdd01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView Mes = findViewById(R.id.tSuggestion);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showpage);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String msg = bundle.getString("Msg");

        double bmi = getIntent().getDoubleExtra("bmi", 0.0);
        TextView showbmi = findViewById(R.id.tShowBMI);
        showbmi.setText("BMI結果:"+bmi);
        Mes.setText(msg);

    }

    public void Gohome(View view) {
//        Intent intent  = new Intent(this, MainActivity.class);
//        startActivity(intent);
        finish();
    }

}
