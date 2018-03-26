package bossini.com.br.servicedeskads3anmca;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListarChamadosActivity extends AppCompatActivity {

    public static final String DESCRICAO =
            "br.usjt.servicedesk.descricao";
    private List<Chamado> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_chamados);
        Intent origemIntent = getIntent();
        String chave = origemIntent.getStringExtra (MainActivity.NOME);
        lista = buscaChamados (chave);
        //ArrayAdapter <String> adapter =
        //        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        ChamadoAdapter <Chamado> adapter =
                new ChamadoAdapter<>(this, lista);
        ListView listView =
                (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent = new Intent (ListarChamadosActivity.this, DetalheChamadoActivity.class);
                intent.putExtra(DESCRICAO, lista.get(pos));
                startActivity(intent);
            }
        });

    }

    public ArrayList<Chamado> geraListaChamados(){
        ArrayList<Chamado> lista = new ArrayList<>();
        Chamado c1 = new Chamado (1, new Date (), null, "aberto",
                "computador da secretária quebrado", new Fila(
                  1, "desktops", "Desktops"));
        lista.add(c1);

        Chamado c2 = new Chamado (2, new Date (), null, "aberto",
                "Telefone não funciona", new Fila(
                2, "telefonia", "Telefonia"));
        lista.add(c2);
        return lista;
        /*lista.add("Telefonia: Telefone não funciona.");
        lista.add();
        lista.add("Servidores: Lentidão generalizada.");
        lista.add("Novos Projetos: CRM");
        lista.add("Manutenção Sistema ERP: atualizar versão.");
        lista.add("Novos Projetos: Rede MPLS");
        lista.add("Manutenção Sistema de Vendas: incluir pipeline.");
        lista.add("Manutenção Sistema ERP: erro contábil");
        lista.add("Novos Projetos: Gestão de Orçamento");
        lista.add("Novos Projetos: Big Data");
        lista.add("Manoel de Barros");
        lista.add("Redes: Internet com lentidão");
        lista.add("Novos Projetos: Chatbot");
        lista.add("Desktops: troca de senha");
        lista.add("Desktops: falha no Windows");
        lista.add("Novos Projetos: ITIL V3");
        lista.add("Telefonia: liberar celular");
        lista.add("Telefonia: mover ramal");
        lista.add("Redes: ponto com defeito");
        lista.add("Novos Projetos: ferramenta EMM");*/

    }

    public ArrayList<Chamado> buscaChamados(String chave){
        ArrayList<Chamado> lista = geraListaChamados();
        if (chave == null || chave.length() == 0){
            return lista;
        } else {
            ArrayList<Chamado> subLista = new ArrayList<>();
            for(Chamado chamado :lista){
                if(chamado.getDescricao().toUpperCase().contains(chave.toUpperCase())){
                    subLista.add(chamado);
                }
            }
            return subLista;
        }
    }
}
