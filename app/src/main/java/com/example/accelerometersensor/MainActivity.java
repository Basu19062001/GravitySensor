package com.example.accelerometersensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find id
        textView = findViewById(R.id.textView);

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
          Sensor accelerometerSensor =  sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
          if(accelerometerSensor!=null){
            sensorManager.registerListener(this,accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
          }
        }else {
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();
        }
        getToast();
    }

    public void getToast(){
        Toast.makeText(this, "This is simple toast code", Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textView.setText("X: "+sensorEvent.values[0]+" Y: "+sensorEvent.values[1]+" Z: "+sensorEvent.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}