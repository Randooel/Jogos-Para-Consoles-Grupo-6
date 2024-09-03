package programa.multithread;

public abstract class Recurso {

    public static abstract class RecursoBase {
        private String tipo;
        private String produtorNome;

        public RecursoBase(String tipo, String produtorNome) {
            this.tipo = tipo;
            this.produtorNome = produtorNome;
        }

        public String getTipo() {
            return tipo;
        }

        public String getProdutorNome() {
            return produtorNome;
        }
    }

    public static class Madeira extends RecursoBase {
        public Madeira(String produtorNome) {
            super("Madeira", produtorNome);
        }
    }

    public static class Pedra extends RecursoBase {
        public Pedra(String produtorNome) {
            super("Pedra", produtorNome);
        }
    }

    public static class Ferro extends RecursoBase {
        public Ferro(String produtorNome) {
            super("Ferro", produtorNome);
        }
    }
}
