package programa.multithread;

public class ConsumidorA extends Consumidor {

    public ConsumidorA(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo);
    }

    @Override
    public void consumirRecurso(Armazen armazem) {
        if (armazem.equals("Madeira") || armazem.equals("Pedra")) {
            super.consumirRecurso(armazem);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + armazem);
        }
    }
}
