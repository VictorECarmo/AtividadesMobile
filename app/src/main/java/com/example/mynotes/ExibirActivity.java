package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.controller.NotaController;
import com.example.mynotes.model.Nota;

public class ExibirActivity extends AppCompatActivity {
    NotaController mNotaController;
    Nota mNota;
    EditText edTitulo, edTxt;
    Button btnCadastrar, btnDeletar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir);
        mNotaController = new NotaController(getApplicationContext());
        mNota = mNotaController.getNota(getIntent().getExtras().getInt("id"));
        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnDeletar = findViewById(R.id.btnDeletar);
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirNota();
            }
        });
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void excluirNota() {
        mNotaController.deleteNota(mNota);
        finish();
    }

    private void salvar() {
        mNota.setTitulo(edTitulo.getText().toString());
        mNota.setTxt(edTxt.getText().toString());
        mNotaController.updateNota(mNota);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        edTitulo.setText(mNota.getTitulo());
        edTxt.setText(mNota.getTxt());
    }
}