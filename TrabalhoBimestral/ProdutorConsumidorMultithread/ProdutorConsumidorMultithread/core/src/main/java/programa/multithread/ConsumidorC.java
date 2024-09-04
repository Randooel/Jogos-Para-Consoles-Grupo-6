package programa.multithread;

public class ConsumidorC extends Consumidor {

    public ConsumidorC(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo, 6000.0);
    }

    @Override
    public void utilizarRecurso(String recurso) {
        if (recurso.equals("Pedra") || recurso.equals("Ferro")) {
            super.utilizarRecurso(recurso);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + recurso);
        }
    }
}
