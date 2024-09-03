package programa.multithread;

import java.util.Random;

public abstract class Produtor {

    private String nome;
    private double velocidadeProducao;
    private Armazen armazem;
    private Random random;

    public Produtor(String nome, double velocidadeProducao, Armazen armazem) {
        this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        this.armazem = armazem;
        this.random = new Random();
    }

    public String getNome() {
        return nome;
    }

    public abstract Recurso.RecursoBase coletarRecurso();  // Cada produtor define o recurso específico

    public void iniciarProducao() {
        new Thread(() -> {
            while (true) {
                try {
                    if (armazem.isCheio()) {
                        System.out.println("O armazém está cheio. Aguardando espaço para continuar a produção...");
                        Thread.sleep(1000);
                        continue;
                    }

                    long startTime = System.currentTimeMillis();
                    Thread.sleep((long) (velocidadeProducao * 1000));
                    Recurso.RecursoBase recurso = coletarRecurso();
                    armazem.adicionarRecurso(recurso.getTipo(), recurso.getProdutorNome());
                    long endTime = System.currentTimeMillis();

                    long timeTaken = endTime - startTime;
                    String mensagem = "Produtor " + getNome() + " produziu " + recurso.getTipo() + " em " + timeTaken + " milissegundos.";
                    System.out.println(mensagem);
                    armazem.setUltimaMensagem(mensagem);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    public void setVelocidadeProducao(double velocidade) {
        this.velocidadeProducao = velocidade;
    }

    public double getVelocidadeProducao() {
        return velocidadeProducao;
    }
}
