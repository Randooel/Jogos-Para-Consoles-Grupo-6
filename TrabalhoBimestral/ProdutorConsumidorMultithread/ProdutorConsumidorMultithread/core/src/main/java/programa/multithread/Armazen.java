package programa.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Armazen {
	private String[] recursosPossiveis;
    private List<String> itens;
    private double capacidadeMaxima;
    private String ultimoRecurso;
    private String ultimoProdutor;
    private String ultimaMensagem;
    
    Semaphore enterElevatorSemaphore = new Semaphore(1);

    public Armazen(double capacidadeMaxima) {
    	recursosPossiveis = new String[6];
    	
    	SetRecursos();
    	
        this.itens = new ArrayList<>();
        this.capacidadeMaxima = capacidadeMaxima;
        this.ultimoRecurso = "";
        this.ultimoProdutor = "";
        this.ultimaMensagem = "";
    }
    
    public void SetRecursos() {
    	recursosPossiveis[0] = "Madeira";
    	recursosPossiveis[1] = "Pedra";
    	recursosPossiveis[2] = "Ferro";
    	recursosPossiveis[3] = "ParedeDeMadeiraPedra";
    	recursosPossiveis[4] = "ParedeDeMadeiraFerro";
    	recursosPossiveis[5] = "ParedeDePedraFerro";
    }
    
    public String GetRecurso(int recursoID) {
    	return recursosPossiveis[recursoID];
    }

    public boolean HaveItemInList(int recursoID) {
    	return itens.contains(recursosPossiveis[recursoID]);
    }
    
    public void adicionarRecurso(int novoItemID, String produtorNome) {
    	
    	try {
			enterElevatorSemaphore.acquire();
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
        if (this.itens.size() < capacidadeMaxima) {
            this.itens.add(recursosPossiveis[novoItemID]);
            this.ultimoRecurso = recursosPossiveis[novoItemID];
            this.ultimoProdutor = produtorNome;
            this.ultimaMensagem = "Recurso " + recursosPossiveis[novoItemID] + " foi adicionado ao armazém por " + produtorNome + ".";
        } else {
            this.ultimaMensagem = "Armazém cheio! Não é possível adicionar mais recursos.";
        }
        
        enterElevatorSemaphore.release();
    }

    public List<String> getItens() {
        return this.itens;
    }

    public String getUltimoRecurso() {
        return ultimoRecurso;
    }

    public String getUltimoProdutor() {
        return ultimoProdutor;
    }

    public String getUltimaMensagem() {
        return ultimaMensagem;
    }

    public boolean isCheio() {
        return itens.size() >= capacidadeMaxima;
    }

    public void setUltimaMensagem(String mensagem) {
        this.ultimaMensagem = mensagem;
    }

	public void RemoveItem(int itemID) {
		itens.remove(itens.indexOf(recursosPossiveis[itemID]));
		
	}
}
