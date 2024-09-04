package programa.multithread;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import programa.multithread.Recurso.Ferro;
import programa.multithread.Recurso.Madeira;
import programa.multithread.Recurso.Pedra;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;

    private Armazen armazem;
    
    
    
    private Produtor[] produtores;
    
    private Produtor produtorCarinaldo;
    private Produtor produtorAstrolabio;
    private Produtor produtorPedronildo;
    
    private Consumidor[] consumidores;
    
    private Consumidor consumidorA;
    private Consumidor consumidorB;
    private Consumidor consumidorC;

    
    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("libgdx.png"));
        font = new BitmapFont();
       
        
        this.produtores = new Produtor[3];
        this.consumidores = new Consumidor[3];
        
        armazem = new Armazen(5);
        
        produtorCarinaldo = new Produtor("Carinaldo", 2.0, armazem, 0);
        produtorAstrolabio = new Produtor("Astrolabio", 2.5, armazem, 1);
        produtorPedronildo = new Produtor("Pedronildo", 1.5, armazem, 2);
        
        produtores[0] = produtorCarinaldo;
        produtores[1] = produtorAstrolabio;
        produtores[2] = produtorPedronildo;
        
        for(int i = 0; i < produtores.length; i++) {
        	produtores[i].start();
        }

        consumidorA = new Consumidor("ConsumidorA", 3.0,armazem, 0,1,3);
        consumidorB = new Consumidor("ConsumidorB", 2.0,armazem,0,2,4);
        consumidorC = new Consumidor("ConsumidorC", 4.0,armazem,1,2,5);

        consumidores[0] = consumidorA;
        consumidores[1] = consumidorB;
        consumidores[2] = consumidorC;
        
        for(int i = 0; i < consumidores.length; i++) {
        	consumidores[i].start();
        }
    }
    
   

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        batch.begin();
        batch.draw(image, 140, 210);

        font.draw(batch, "Itens no armazém:", 20, 420);
        int x = 400;
        for (String item : armazem.getItens()) {
            font.draw(batch, "- " + item, 20, x);
            x -= 20;
        }

        font.draw(batch, "Último recurso coletado: " + armazem.getUltimoRecurso(), 20, 280);
        font.draw(batch, "Por produtor: " + armazem.getUltimoProdutor(), 20, 260);
        font.draw(batch, "Mensagem: " + armazem.getUltimaMensagem(), 20, 240);

        int y = 400;
        
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}
