package programa.multithread;

import java.util.LinkedList;
import java.util.Queue;

public class Armazen {
    private final Queue<String> recursos;
    private final int capacidade;

    public Armazen(int capacidade) {
        this.recursos = new LinkedList<>();
        this.capacidade = capacidade;
    }

    public synchronized boolean isCheio() {
        return recursos.size() == capacidade;
    }

    public synchronized boolean isVazio() {
        return recursos.isEmpty();
    }

    public synchronized void adicionarRecurso(String recurso) {
        if (!isCheio()) {
            recursos.add(recurso);
        }
    }

    public synchronized String removerRecurso() {
        if (!isVazio()) {
            return recursos.poll();
        }
        return null;
    }

    public synchronized String getUltimoRecurso() {
        return recursos.peek();
    }

    public synchronized Iterable<String> getItens() {
        return recursos;
    }
}
