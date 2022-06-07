package com.cst2335.pan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.buttonClickHere);
        btn.setOnClickListener(
                (v) -> Toast.makeText(getApplicationContext(), getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show());


        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch swc = findViewById(R.id.switchOnOff);
        swc = findViewById(R.id.switchOnOff);
        String swcOn = getString(R.string.SwitchOn);
        String swcOff = getString(R.string.SwitchOff);
        String undo = getString(R.string.Undo);

        Switch finalSwc = swc;
        swc.setOnCheckedChangeListener((buttonView, isChecked) ->{
            finalSwc.setText(isChecked?swcOn:swcOff);
            Snackbar.make(btn,(isChecked?swcOn:swcOff),Snackbar.LENGTH_LONG).setAction( undo, click -> finalSwc.setChecked(!isChecked)).show();

        });


    }
}


