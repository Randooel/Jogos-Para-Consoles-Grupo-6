package programa.multithread;

public class ProdutorAstrolabio extends Produtor{

    public ProdutorAstrolabio(Armazen armazem) {
        super("Astrolabio", 0.5, 5000.0, armazem);
    }

    @Override
    public Recurso.RecursoBase coletarRecurso() {
        return new Recurso.Ferro(getNome());
    }
}