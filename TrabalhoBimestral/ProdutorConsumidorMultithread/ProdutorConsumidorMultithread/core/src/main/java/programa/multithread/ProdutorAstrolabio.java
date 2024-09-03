package programa.multithread;

public class ProdutorAstrolabio extends Produtor{

    public ProdutorAstrolabio(Armazen armazem) {
        super("Astrolabio", 2.5, armazem);
    }

    @Override
    public Recurso.RecursoBase coletarRecurso() {
        return new Recurso.Ferro(getNome());
    }
}