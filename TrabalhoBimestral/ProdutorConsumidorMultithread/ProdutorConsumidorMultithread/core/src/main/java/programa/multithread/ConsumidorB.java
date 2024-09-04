package programa.multithread;

public class ConsumidorB extends Consumidor {

    public ConsumidorB(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo, 3000.0);
    }

    @Override
    public void utilizarRecurso(String recurso) {
        if (recurso.equals("Madeira") || recurso.equals("Ferro")) {
            super.utilizarRecurso(recurso);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + recurso);
        }
    }
}
