package programa.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Consumidor {

    private String nome;
    private double velocidadeConsumo;
    private Random random;

    private List<String> produtos;
    private List<String> recursosConsumidos;

    public Consumidor(String nome, double velocidadeConsumo) {
        this.nome = nome;
        this.velocidadeConsumo = velocidadeConsumo;
        this.random = new Random();
        this.produtos = new ArrayList<>();
        this.recursosConsumidos = new ArrayList<>();
    }

    public void consumirRecurso(Armazen armazem) {
        while (true) {
            try {
                Thread.sleep((long) (velocidadeConsumo * 1000));

                if (!armazem.getItens().isEmpty()) {
                    String recurso = armazem.getItens().remove(0);
                    System.out.println(nome + " consumiu o recurso: " + recurso);

                    recursosConsumidos.add(recurso);

                    construirProduto();
                } else {
                    System.out.println("Armazém vazio! " + nome + " está esperando por novos recursos.");
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void construirProduto() {
        if (recursosConsumidos.contains("Madeira") && recursosConsumidos.contains("Pedra")) {
            produtos.add("Parede de Madeira e Pedra");
            System.out.println(nome + " construiu: Parede de Madeira e Pedra");
            recursosConsumidos.remove("Madeira");
            recursosConsumidos.remove("Pedra");
        } else if (recursosConsumidos.contains("Madeira") && recursosConsumidos.contains("Ferro")) {
            produtos.add("Parede de Madeira e Ferro");
            System.out.println(nome + " construiu: Parede de Madeira e Ferro");
            recursosConsumidos.remove("Madeira");
            recursosConsumidos.remove("Ferro");
        } else if (recursosConsumidos.contains("Pedra")) {
            produtos.add("Parede de Pedra");
            System.out.println(nome + " construiu: Parede de Pedra");
            recursosConsumidos.remove("Pedra");
        } else if (recursosConsumidos.contains("Ferro")) {
            produtos.add("Parede de Ferro");
            System.out.println(nome + " construiu: Parede de Ferro");
            recursosConsumidos.remove("Ferro");
        } else if (recursosConsumidos.contains("Madeira")) {
            produtos.add("Parede de Madeira");
            System.out.println(nome + " construiu: Parede de Madeira");
            recursosConsumidos.remove("Madeira");
        } else {
            System.out.println(nome + " não conseguiu construir nenhum produto com os materiais disponíveis.");
        }
    }

    public void setVelocidadeConsumo(double velocidade) {
        this.velocidadeConsumo = velocidade;
    }

    public double getVelocidadeConsumo() {
        return velocidadeConsumo;
    }

    public String getNome() {
        return nome;
    }
}
