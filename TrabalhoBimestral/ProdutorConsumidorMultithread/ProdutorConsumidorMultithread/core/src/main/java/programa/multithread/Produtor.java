package programa.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Produtor {

    private final String nome;
    private final double velocidadeProducao;
    private final List<Recurso.RecursoBase> recursosDisponiveis;
    private final Random random;
    private final Armazen armazem;

    public Produtor(String nome, double velocidadeProducao, Armazen armazem) {
        this.nome = nome;
        this.velocidadeProducao = velocidadeProducao;
        this.armazem = armazem;
        this.recursosDisponiveis = new ArrayList<>();
        this.random = new Random();

        recursosDisponiveis.add(new Recurso.Madeira(nome));
        recursosDisponiveis.add(new Recurso.Pedra(nome));
        recursosDisponiveis.add(new Recurso.Ferro(nome));
    }

    public String getNome() {
        return nome;
    }

    // Método para coletar um recurso aleatório
    public Recurso.RecursoBase coletarRecurso() {
        if (recursosDisponiveis.isEmpty()) {
            throw new IllegalStateException("Nenhum recurso disponível para coleta.");
        }
        int idAleatorio = random.nextInt(recursosDisponiveis.size());
        return recursosDisponiveis.get(idAleatorio);
    }

    // Novo método para produzir um recurso
    public void produzirRecurso() {
        if (armazem.isCheio()) {
            System.out.println("O armazém está cheio. Parando a produção.");
            return;
        }

        long startTime = System.currentTimeMillis();
        Recurso.RecursoBase recurso = coletarRecurso();
        armazem.adicionarRecurso(recurso.getTipo(), recurso.getProdutorNome());
        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;
        String mensagem = "Produtor " + getNome() + " produziu " + recurso.getTipo() + " em " + timeTaken + " milissegundos.";
        System.out.println(mensagem);
        armazem.setUltimaMensagem(mensagem);
    }
}
