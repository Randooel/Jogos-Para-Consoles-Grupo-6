package programa.multithread;

public class ConsumidorB extends Consumidor {

    public ConsumidorB(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo);
    }

    @Override
    public void consumirRecurso(Armazen armazem) {
        if (armazem.equals("Madeira") || armazem.equals("Ferro")) {
            super.consumirRecurso(armazem);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + armazem);
        }
    }
}
