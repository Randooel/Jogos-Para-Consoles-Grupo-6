package programa.multithread;

import java.util.ArrayList;
import java.util.List;

public class Armazen {

    private List<String> itens;
    private double capacidadeMaxima;

    public Armazen(double capacidadeMaxima) {
        this.itens = new ArrayList<>();
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void adicionarRecurso(String novoItem) {
        if (this.itens.size() < capacidadeMaxima) {
            this.itens.add(novoItem);
            System.out.println("Recurso " + novoItem + " foi adicionado ao armazém.");
        } else {
            System.out.println("Armazém cheio! Não é possível adicionar mais recursos.");
        }
    }

    public List<String> getItens() {
        return this.itens;
    }
}
