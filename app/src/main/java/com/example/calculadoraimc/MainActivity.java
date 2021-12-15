package com.example.calculadoraimc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editPeso;
    EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editPeso = findViewById(R.id.peso);
        editAltura = findViewById(R.id.altura);
        Button b = findViewById(R.id.botaoCalcular);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AbreNovaTela(v);
            }
        });
    }
    public void AbreNovaTela(View b){
        double peso, altura, calculo;
        Intent intent = new Intent(getApplicationContext(), RecebeResultado.class);
        peso = Integer.parseInt(editPeso.getText().toString());
        altura = Integer.parseInt(editAltura.getText().toString());
        calculo = peso/(StrictMath.pow(altura/100, 2));
        intent.putExtra("calculo", calculo);
        startActivity(intent);
    }
}