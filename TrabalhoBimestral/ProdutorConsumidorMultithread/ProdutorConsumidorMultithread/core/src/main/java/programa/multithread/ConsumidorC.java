package programa.multithread;

public class ConsumidorC extends Consumidor {

    public ConsumidorC(Armazen armazen, String nome, double velocidadeConsumo) {
        super(armazen, nome, velocidadeConsumo);
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
