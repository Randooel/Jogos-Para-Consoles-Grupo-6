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
    private Produtor produtorCarinaldo;
    private Produtor produtorAstrolabio;
    private Produtor produtorPedronildo;
    private Consumidor consumidorA;
    private Consumidor consumidorB;
    private Consumidor consumidorC;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("libgdx.png"));
        font = new BitmapFont();

        armazem = new Armazen(20);

        produtorCarinaldo = new ProdutorCarinaldo(armazem);
        produtorAstrolabio = new ProdutorAstrolabio(armazem);
        produtorPedronildo = new ProdutorPedronildo(armazem);

        consumidorA = new ConsumidorA("ConsumidorA", 200.0);
        consumidorB = new ConsumidorB("ConsumidorB", 200.0);
        consumidorC = new ConsumidorC("ConsumidorC", 200.0);
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime() * 1000;  // Convertendo para milissegundos

        // Produção de recursos
        produtorCarinaldo.produzirRecurso(deltaTime);
        produtorAstrolabio.produzirRecurso(deltaTime);
        produtorPedronildo.produzirRecurso(deltaTime);

        // Consumo de recursos com delay
        consumidorA.consumirRecurso(armazem, deltaTime);
        consumidorB.consumirRecurso(armazem, deltaTime);
        consumidorC.consumirRecurso(armazem, deltaTime);

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
