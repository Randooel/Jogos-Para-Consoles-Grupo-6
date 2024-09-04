package programa.multithread;

import java.util.Random;

public abstract class Produtor {

    private String nome;
    private double velocidadeProducao;
    private double tempo; // Tempo acumulado para controle de delay
    private Armazen armazem;
    private Random random;
    private double delayProducao;

    public Produtor(String nome, double velocidadeProducao, double delayProducao, Armazen armazem) {
        this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        this.delayProducao = delayProducao;
        this.armazem = armazem;
        this.tempo = 0;
        this.random = new Random();
    }

    public String getNome() {
        return nome;
    }

    public abstract Recurso.RecursoBase coletarRecurso();  // Cada produtor define o recurso específico

    public void produzirRecurso(double deltaTime) {
        tempo += deltaTime;

        if (tempo >= delayProducao) {
            if (armazem.isCheio()) {
                System.out.println("O armazém está cheio. Aguardando espaço para continuar a produção...");
                return;
            }

            Recurso.RecursoBase recurso = coletarRecurso();
            armazem.adicionarRecurso(recurso.getTipo(), recurso.getProdutorNome());

            String mensagem = "Produtor " + getNome() + " produziu " + recurso.getTipo() + ".";
            System.out.println(mensagem);
            armazem.setUltimaMensagem(mensagem);

            tempo = 0; // Resetar o tempo após produzir o recurso
        }
    }

    public void setVelocidadeProducao(double velocidade) {
        this.velocidadeProducao = velocidade;
    }

    public double getVelocidadeProducao() {
        return velocidadeProducao;
    }
}
