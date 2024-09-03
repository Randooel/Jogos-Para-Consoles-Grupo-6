package programa.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produtor {

    private String nome;
    private double velocidadeProducao;
    private List<Recurso.RecursoBase> recursosDisponiveis;
    private Random random;
    private Armazen armazem;

    public Produtor(String nome, double velocidadeProducao, Armazen armazem) {
        this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        this.armazem = armazem;
        recursosDisponiveis = new ArrayList<>();
        random = new Random();

        recursosDisponiveis.add(new Recurso.Madeira(nome));
        recursosDisponiveis.add(new Recurso.Pedra(nome));
        recursosDisponiveis.add(new Recurso.Ferro(nome));
    }

    public String getNome() {
        return nome;
    }

    public Recurso.RecursoBase coletarRecurso() {
        if (recursosDisponiveis.isEmpty()) {
            throw new IllegalStateException("Nenhum recurso disponível para coleta.");
        }
        int idAleatorio = random.nextInt(recursosDisponiveis.size());
        return recursosDisponiveis.get(idAleatorio);
    }

    public void iniciarProducao() {
        new Thread(() -> {
            while (true) {
                try {
                    if (armazem.isCheio()) {
                        System.out.println("O armazém está cheio. Parando a produção.");
                        break;
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
