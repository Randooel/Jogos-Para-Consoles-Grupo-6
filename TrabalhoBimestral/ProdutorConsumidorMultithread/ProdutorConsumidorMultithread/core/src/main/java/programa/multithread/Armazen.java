package programa.multithread;

import java.util.ArrayList;
import java.util.List;

public class Armazen {
    private List<String> itens;
    private double capacidadeMaxima;
    private String ultimoRecurso;
    private String ultimoProdutor;
    private String ultimaMensagem;

    public Armazen(double capacidadeMaxima) {
        this.itens = new ArrayList<>();
        this.capacidadeMaxima = capacidadeMaxima;
        this.ultimoRecurso = "";
        this.ultimoProdutor = "";
        this.ultimaMensagem = "";
    }

    public void adicionarRecurso(String novoItem, String produtorNome) {
        if (this.itens.size() < capacidadeMaxima) {
            this.itens.add(novoItem);
            this.ultimoRecurso = novoItem;
            this.ultimoProdutor = produtorNome;
            this.ultimaMensagem = "Recurso " + novoItem + " foi adicionado ao armazém por " + produtorNome + ".";
        } else {
            this.ultimaMensagem = "Armazém cheio! Não é possível adicionar mais recursos.";
        }
    }

    public List<String> getItens() {
        return this.itens;
    }

    public String getUltimoRecurso() {
        return ultimoRecurso;
    }

    public String getUltimoProdutor() {
        return ultimoProdutor;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public boolean isCheio() {
        return itens.size() >= capacidadeMaxima;
    }

    public void setUltimaMensagem(String mensagem) {
        this.ultimaMensagem = mensagem;
    }
}
