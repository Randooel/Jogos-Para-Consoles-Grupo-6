package programa.multithread;

public class Consumidor implements Runnable {
    private final String nome;
    private final double velocidadeConsumo;
    private final Armazen armazem;

    public Consumidor(String nome, double velocidadeConsumo, Armazen armazem) {
        this.nome = nome;
        this.velocidadeConsumo = velocidadeConsumo;
        this.armazem = armazem;
    }

    public void iniciarConsumo() {
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            while (!armazem.isVazio()) {
                Thread.sleep((long) (velocidadeConsumo * 1000));
                String recurso = armazem.removerRecurso();
                System.out.println("Consumidor " + nome + " consumiu: " + recurso);
            }
            System.out.println("O armazém está vazio. Consumidor parando o consumo.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
