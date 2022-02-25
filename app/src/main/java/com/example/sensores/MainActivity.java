package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensornManager;
    Button sensorButton;
    TextView mTvLight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvLight = findViewById(R.id.tvSensorLight);
        sensorButton = findViewById(R.id.gyroscope);
        sensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i);
            }
        });

        mSensornManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

        List<Sensor> listSensor = mSensornManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder sensorListTxt = new StringBuilder();

        for (Sensor s : listSensor) {
            sensorListTxt.append(s.getName()).append(System.getProperty("line.separator"));
        }
        mTvLight.setText(sensorListTxt);
    }
}
