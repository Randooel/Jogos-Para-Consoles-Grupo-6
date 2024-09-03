package programa.multithread;

public class ProdutorCarinaldo extends Produtor {

    public ProdutorCarinaldo(Armazen armazem) {
        super("Carinaldo", 2.0, armazem);
    }

    @Override
    public Recurso.RecursoBase coletarRecurso() {
        return new Recurso.Madeira(getNome());
    }
}