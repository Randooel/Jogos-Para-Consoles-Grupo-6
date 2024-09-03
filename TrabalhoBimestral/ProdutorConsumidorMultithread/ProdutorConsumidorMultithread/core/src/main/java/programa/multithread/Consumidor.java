package programa.multithread;

import java.util.Random;

public class Consumidor extends Thread {

    private String nome;
    private double velocidadeConsumo;
    private Random random;
    private Armazen armazem;

    // Construtor
    public Consumidor(Armazen armazen, String nome, double velocidadeConsumo) {
        this.armazem = armazen;
    	this.nome = nome;
        this.velocidadeConsumo = velocidadeConsumo;
        this.random = new Random();
    }

    @Override
    public void run() {
    	while (true) {
            try {
                // Simula o tempo necessário para consumir um recurso com base na velocidade de consumo
                Thread.sleep((long) (velocidadeConsumo * 1000));

                if (!armazem.getItens().isEmpty()) {
                    // Remove o recurso mais antigo ou pode fazer uma lógica de prioridade
                    String recurso = armazem.getItens().remove(0);
                    System.out.println(nome + " consumiu o recurso: " + recurso);

                    // Aqui você pode adicionar lógica para usar o recurso consumido, por exemplo, construir um item
                    utilizarRecurso(recurso);
                } else {
                    System.out.println("Armazém vazio! " + nome + " está esperando por novos recursos.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    // Método para utilizar o recurso consumido
    public void utilizarRecurso(String recurso) {
        System.out.println(nome + " está utilizando o recurso: " + recurso);
    }

    // Método para definir a velocidade de consumo
    public void setVelocidadeConsumo(double velocidade) {
        this.velocidadeConsumo = velocidade;
    }

    // Método para obter a velocidade de consumo
    public double getVelocidadeConsumo() {
        return velocidadeConsumo;
    }

    // Adicionado método getNome()
    public String getNome() {
        return nome;
    }
}
