package programa.multithread;

public class ProdutorPedronildo extends Produtor {

    public ProdutorPedronildo(Armazen armazem) {
        super("Pedronildo", 1.5, 2000.0, armazem);
    }

    @Override
    public Recurso.RecursoBase coletarRecurso() {
        return new Recurso.Pedra(getNome());
    }
}