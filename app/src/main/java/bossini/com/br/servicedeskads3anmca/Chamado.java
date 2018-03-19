package bossini.com.br.servicedeskads3anmca;


import java.util.Date;

/**
 * Created by rodrigo on 19/03/18.
 */

public class Chamado {

    private int numero;
    private Date dataAbertura, dataFechamento;
    private String descricao, status;
    private Fila fila;

    public Chamado (int numero, Date dataAbertura,
                    Date dataFechamento, String status,
                    String descricao, Fila fila){
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.descricao = descricao;
        this.status = status;
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }
}
