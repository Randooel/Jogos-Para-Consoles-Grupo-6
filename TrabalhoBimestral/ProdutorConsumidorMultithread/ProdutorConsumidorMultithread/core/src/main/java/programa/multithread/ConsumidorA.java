package programa.multithread;

public class ConsumidorA extends Consumidor {

    public ConsumidorA(Armazen armazen, String nome, double velocidadeConsumo) {
        super(armazen, nome, velocidadeConsumo);
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
