package bossini.com.br.servicedeskads3anmca;

import java.io.Serializable;

/**
 * Created by rodrigo on 19/03/18.
 */

public class Fila implements Serializable{
    private int id;
    private String icone, nome;

    public Fila (int id, String icone, String nome){
        this.id = id;
        this.icone = icone;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
