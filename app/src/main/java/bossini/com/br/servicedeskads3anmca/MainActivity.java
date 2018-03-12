package bossini.com.br.servicedeskads3anmca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText buscaFilaEditText;
    public static final String NOME = "br.usjt.servicedesk.nome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buscaFilaEditText = (EditText)
                findViewById(R.id.buscaFilaEditText);
    }

    public void buscarChamados (View view){
        Intent intent = new Intent (this, ListarChamadosActivity.class);
        String nome = buscaFilaEditText.getText().toString();
        intent.putExtra(NOME, nome);
        startActivity(intent);
    }
}
