package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;

public class NovoFilmeActivity extends Activity {

    private EditText editTitulo, editAno;
    private Spinner spinnerGenero;
    private RatingBar ratingFilme;
    private FilmeRepository repository;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_filme);

        editTitulo = findViewById(R.id.editTitulo);
        editAno = findViewById(R.id.editAno);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        ratingFilme = findViewById(R.id.ratingNotaFilme);
        repository = new FilmeRepository(getApplicationContext());
    }

    public void salvarFilme(View view){
        Filme filme = new Filme();
        filme.setTitulo(editTitulo.getText().toString());
        filme.setGenero(spinnerGenero.getSelectedItem().toString());
        filme.setAno_producao(Integer.parseInt(editAno.getText().toString()));
        filme.setAvaliacao((int)ratingFilme.getRating());

        repository.insert(filme);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(NovoFilmeActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
