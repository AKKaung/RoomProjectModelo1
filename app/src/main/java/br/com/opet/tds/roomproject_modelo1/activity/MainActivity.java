package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.adapter.FilmeAdapter;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;


public class MainActivity extends Activity {

    private ListView listaFilmes;
    private FilmeRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFilmes = findViewById(R.id.listaFilmes);
        repository = new FilmeRepository(getApplicationContext());
        ArrayAdapter<Filme> adapter = new FilmeAdapter(this,R.layout.filme_item,repository.getAllFilmes());
        listaFilmes.setAdapter(adapter);
    }

    public void novoFilme(View view){
        Intent novoFilme = new Intent(MainActivity.this,NovoFilmeActivity.class);
        startActivity(novoFilme);
    }
}
