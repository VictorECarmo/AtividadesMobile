package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mynotes.controller.NotaController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton adicionaNota;
    ListView listView;
    NotaController mNotaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        mNotaController = new NotaController(getApplicationContext());
        adicionaNota = findViewById(R.id.adicionaNota);
        adicionaNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(i);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                exeibirNota(position);
            }
        });
    }

    private void exeibirNota(int position){
        Intent i = new Intent(getApplicationContext(), ExibirActivity.class);
        i.putExtra("id", mNotaController.getAllNotes().get(position).getId());
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                mNotaController.getAllTitlesNotes()

        );
        listView.setAdapter(adapter);
    }
}