package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mynotes.controller.NotaController;
import com.example.mynotes.model.Nota;

public class CadastrarActivity extends AppCompatActivity {

    EditText edTitulo, edTxt;
    Nota mNote;
    NotaController mNoteController;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        edTitulo = findViewById(R.id.edTitulo);
        edTxt = findViewById(R.id.edtxt);
        btnSalvar = findViewById(R.id.btnCadastrar);
        mNoteController = new NotaController(getApplicationContext());
        mNote = new Nota(edTitulo.getText().toString(), edTxt.getText().toString());
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastrarNota();
            }
        });
    }

    private void cadastrarNota() {
        mNote.setTitulo(edTitulo.getText().toString());
        mNote.setTxt(edTxt.getText().toString());
        mNoteController.cadastrarNota(mNote);
        finish();
    }
}