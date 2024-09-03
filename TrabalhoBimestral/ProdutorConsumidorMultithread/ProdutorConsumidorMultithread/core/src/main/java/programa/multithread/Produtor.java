package programa.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produtor {
    
	private String nome;
    private double velocidadeProducao;
    private List<Recurso.RecursoBase> recursosDisponiveis;
    private Random random;

    // Construtor
    public Produtor(String nome, double velocidadeProducao) {
    	this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        recursosDisponiveis = new ArrayList<>();
        random = new Random();
        
        // Adiciona recursos disponíveis
        recursosDisponiveis.add(new Recurso.Madeira());
        recursosDisponiveis.add(new Recurso.Pedra());
        recursosDisponiveis.add(new Recurso.Ferro());
    }
    
    public String getNome() {
    	return nome;
    }
    

    // Coleta um recurso aleatório
    public Recurso.RecursoBase coletarRecurso() {
        if (recursosDisponiveis.isEmpty()) {
            throw new IllegalStateException("Nenhum recurso disponível para coleta.");
        }
        int idAleatorio = random.nextInt(recursosDisponiveis.size());
        return recursosDisponiveis.get(idAleatorio);
    }
    
    // Método para simular a produção de recursos
    public void iniciarProducao() {
        new Thread(() -> {
            while (true) {
                try {
                    // Simula a produção de recursos com base na velocidade de produção
                    Thread.sleep((long) (velocidadeProducao * 1000));
                    System.out.println("Novo recurso produzido!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }).start();
    }

    // Método para definir a velocidade de produção (se necessário)
    public void setVelocidadeProducao(double velocidade) {
        this.velocidadeProducao = velocidade;
    }

    // Método para obter a velocidade de produção (se necessário)
    public double getVelocidadeProducao() {
        return velocidadeProducao;
    }
}
