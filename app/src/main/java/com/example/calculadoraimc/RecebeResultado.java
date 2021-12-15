package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class RecebeResultado extends AppCompatActivity {
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        textViewResult = findViewById(R.id.resultado);
        Bundle bundle = getIntent().getExtras();
        Double result = bundle.getDouble("calculo");
        DecimalFormat df = new DecimalFormat("###.##");
        textViewResult.setText(df.format(result));
    }
}