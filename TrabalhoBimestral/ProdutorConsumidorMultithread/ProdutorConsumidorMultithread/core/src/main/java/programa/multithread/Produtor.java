package programa.multithread;

public class Produtor implements Runnable {
    private final String nome;
    private final double velocidadeProducao;
    private final Armazen armazem;

    public Produtor(String nome, double velocidadeProducao, Armazen armazem) {
        this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        this.armazem = armazem;
    }

    public void iniciarProducao() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (!armazem.isCheio()) {
                Thread.sleep((long) (velocidadeProducao * 1000));
                armazem.adicionarRecurso(nome + " produziu um recurso.");
                System.out.println("Produtor " + nome + " produziu um recurso.");
            }
            System.out.println("O armazém está cheio. Produtor parando a produção.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
