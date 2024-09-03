package programa.multithread;

public class ConsumidorC extends Consumidor {

    public ConsumidorC(String nome, double velocidadeConsumo) {
        super(nome, velocidadeConsumo);
    }

    @Override
    public void consumirRecurso(Armazen armazem) {
        if (armazem.equals("Pedra") || armazem.equals("Ferro")) {
            super.consumirRecurso(armazem);
        } else {
            System.out.println(getNome() + " não pode utilizar o recurso: " + armazem);
        }
    }
}
