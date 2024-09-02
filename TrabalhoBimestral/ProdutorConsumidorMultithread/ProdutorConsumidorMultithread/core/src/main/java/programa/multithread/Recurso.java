package programa.multithread;

import java.util.ArrayList;
import java.util.List;

public class Recurso {
	// Classe de referência para as outras
	public abstract static class RecursoBase {
		public abstract String getTipo();
	}
	
	// Subclasse de tipo de recurso
	public static class Madeira extends RecursoBase {
		@Override
		public String getTipo() {
			return "Madeira";
		}
	}
	
	// Subclasse de tipo de recurso
	public static class Pedra extends RecursoBase {
		@Override
		public String getTipo() {
			return "Pedra";
		}
	}
	
	// Subclasse de tipo de recurso
	public static class Ferro extends RecursoBase {
		@Override
		public String getTipo() {
			return "Ferro";
		}
	}
	
}
