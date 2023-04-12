package com.example.comtqcgdd01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText edHeight;
    private EditText edWeight;
    private RadioButton boy;
    private RadioButton girl;
    private Button bt_submit;
    double bmi;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void Sex() {
        if (boy.isChecked()) {
            if (bmi < 20){
                msg = getString(R.string.underweight_msg);
            }
            if (bmi > 25){
                msg = getString(R.string.overweight_msg);
            }
            else{
                msg = getString(R.string.normalweight_msg);
            }
        }
        if (girl.isChecked()) {
            if (bmi < 18){
                msg = getString(R.string.underweight_msg);
            }
            if (bmi > 22){
                msg = getString(R.string.overweight_msg);
            }
            else{
                msg = getString(R.string.normalweight_msg);
            }
        }
    }

    public void submit(View view) {

        double height = Double.parseDouble(edHeight.getText().toString());
        double weight = Double.parseDouble(edWeight.getText().toString());
        double bmi = weight / ((height / 100.0) * (height / 100.0));
        Sex();
        Intent intent = new Intent(this, ShowActivity.class);
        Bundle bundle = new Bundle();
        bundle.putDouble("keybmi",bmi);
        bundle.putString("Msg",msg);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void findViews(){
        edHeight = findViewById(R.id.edHeight);
        edWeight = findViewById(R.id.edWeight);
        girl = findViewById(R.id.btGirl);
        boy = findViewById(R.id.btBoy);
        bt_submit = findViewById(R.id.btSubmit);
        boy.setChecked(true);
    }

}