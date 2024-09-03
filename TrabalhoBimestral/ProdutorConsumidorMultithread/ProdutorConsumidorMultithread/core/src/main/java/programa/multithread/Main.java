package programa.multithread;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

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
        
        produtorCarinaldo = new ProdutorCarinaldo(armazem);
        produtorAstrolabio = new ProdutorAstrolabio(armazem);
        produtorPedronildo = new ProdutorPedronildo(armazem);
        
        produtores[0] = produtorCarinaldo;
        produtores[1] = produtorAstrolabio;
        produtores[2] = produtorPedronildo;
        
        for(int i = 0; i < produtores.length; i++) {
        	produtores[i].start();
        }

        consumidorA = new ConsumidorA(armazem,"ConsumidorA", 3.0);
        consumidorB = new ConsumidorB(armazem,"ConsumidorB", 2.0);
        consumidorC = new ConsumidorC(armazem,"ConsumidorC", 4.0);

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
        int y = 400;
        for (String item : armazem.getItens()) {
            font.draw(batch, "- " + item, 20, y);
            y -= 20;
        }

        font.draw(batch, "Último recurso coletado: " + armazem.getUltimoRecurso(), 20, y - 20);
        font.draw(batch, "Por produtor: " + armazem.getUltimoProdutor(), 20, y - 40);
        font.draw(batch, "Mensagem: " + armazem.getUltimaMensagem(), 20, y - 60);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}
