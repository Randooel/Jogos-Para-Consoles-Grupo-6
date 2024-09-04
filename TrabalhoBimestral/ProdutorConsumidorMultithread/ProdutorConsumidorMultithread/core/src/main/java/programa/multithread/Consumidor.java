package programa.multithread;

import java.util.Random;

public class Consumidor {

    private String nome;
    private double velocidadeConsumo;
    private Random random;
    private double tempo; // Tempo acumulado para controle de delay
    private double delayConsumo;

    public Consumidor(String nome, double velocidadeConsumo, double delayConsumo) {
        this.nome = nome;
        this.velocidadeConsumo = velocidadeConsumo;
        this.random = new Random();
        this.tempo = 0;
        this.delayConsumo = delayConsumo;
    }

    public void consumirRecurso(Armazen armazem, double deltaTime) {
        tempo += deltaTime;

        if (tempo >= delayConsumo) {
            if (!armazem.getItens().isEmpty()) {
                String recurso = armazem.getItens().remove(0);
                System.out.println(nome + " consumiu o recurso: " + recurso);
                utilizarRecurso(recurso);
            } else {
                System.out.println("Armazém vazio! " + nome + " está esperando por novos recursos.");
            }

            tempo = 0; // Resetar o tempo após consumir o recurso
        }
    }

    public void utilizarRecurso(String recurso) {
        System.out.println(nome + " está utilizando o recurso: " + recurso);
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
