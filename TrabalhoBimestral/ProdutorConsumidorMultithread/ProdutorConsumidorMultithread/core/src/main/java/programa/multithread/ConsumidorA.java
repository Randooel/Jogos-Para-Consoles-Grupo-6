package programa.multithread;

public class ConsumidorA extends Consumidor {

    public ConsumidorA(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo, 4000.0);
    }

    @Override
    public void utilizarRecurso(String recurso) {
        if (recurso.equals("Madeira") || recurso.equals("Pedra")) {
            super.utilizarRecurso(recurso);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + recurso);
        }
    }
}
