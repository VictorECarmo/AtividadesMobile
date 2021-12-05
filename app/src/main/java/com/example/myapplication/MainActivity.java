package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editTextValorMin, editTextValorMax;
    TextView textoFinal, textoAlerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextValorMin = findViewById(R.id.editTextValorMin);
        editTextValorMax = findViewById(R.id.editTextValorMax);
        textoFinal = findViewById(R.id.informacao);
        textoAlerta = findViewById(R.id.textAlert);
    }

    public void SortearNumero(View v) {
        Button b = (Button) v;
        int valorMin, valorMax;
        valorMin = parseIntOrZero(editTextValorMin.getText().toString());
        valorMax = parseIntOrZero(editTextValorMax.getText().toString());
        if (valorMin >= 1 && valorMax > valorMin) {
            int result = new Random().nextInt(valorMax - valorMin) + valorMin;
            textoFinal.setText(Integer.toString(result));
            textoAlerta.setText("Sucesso!");
        }else{
            textoAlerta.setText("Campo(s) com informação(ões) inválida(s)");
            }
    }

    public Integer parseIntOrZero(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}