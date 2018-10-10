package br.com.opet.tds.roomproject_modelo1.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.opet.tds.roomproject_modelo1.R;

public class AtualizarFilmeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar_filme);
        long extra_id = getIntent().getLongExtra("ID",0);
        Toast.makeText(this, "ID = " + extra_id, Toast.LENGTH_SHORT).show();
    }

    public void atualizarFilme(View view){

    }
}
