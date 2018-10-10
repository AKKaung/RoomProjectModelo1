package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.opet.tds.roomproject_modelo1.R;
import br.com.opet.tds.roomproject_modelo1.model.Filme;
import br.com.opet.tds.roomproject_modelo1.repository.FilmeRepository;

public class AtualizarFilmeActivity extends Activity {
    private EditText editTitulo, editAno;
    private Spinner spinnerGenero;
    private RatingBar ratingFilme;
    private FilmeRepository repository;
    private Filme filme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_filme);

        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();

        editTitulo = findViewById(R.id.editTitulo);
        editAno = findViewById(R.id.editAno);
        spinnerGenero = findViewById(R.id.spinnerGenero);
        ratingFilme = findViewById(R.id.ratingNotaFilme);
        repository = new FilmeRepository(getApplicationContext());
        loadFilme(extra_id);
    }

    private void loadFilme(long extra_id) {
        filme = repository.loadFilmeByID(extra_id);
        editAno.setText(String.valueOf(filme.getAno_producao()));
        editTitulo.setText(filme.getTitulo());
        String[] generos = getResources().getStringArray(R.array.generos_array);
        for(int i = 0; i < generos.length; i++){
            if(filme.getGenero().equals(generos[i])){
                spinnerGenero.setSelection(i);
                break;
            }
        }
        ratingFilme.setRating((float)filme.getAvaliacao());
    }

    public void atualizarFilme(View view){
        filme.setTitulo(editTitulo.getText().toString());
        filme.setGenero(spinnerGenero.getSelectedItem().toString());
        filme.setAno_producao(Integer.parseInt(editAno.getText().toString()));
        filme.setAvaliacao((int)ratingFilme.getRating());
        repository.update(filme);
        callMainActivity();
    }

    private void callMainActivity() {
        Intent mainActivity = new Intent(AtualizarFilmeActivity.this,MainActivity.class);
        startActivity(mainActivity);
        finish();
    }
}
