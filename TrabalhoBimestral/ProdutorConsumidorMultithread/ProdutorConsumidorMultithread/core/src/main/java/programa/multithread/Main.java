package programa.multithread;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;

    private Produtor produtor;
    private Consumidor consumidor;
    private Armazen armazem;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture(Gdx.files.internal("libgdx.png"));
        font = new BitmapFont();

        armazem = new Armazen(5);

        produtor = new ProdutorCarinaldo(armazem);
        consumidor = new Consumidor("Consumidor1", 5.0);

        produtor.iniciarProducao();
        consumidor.consumirRecurso(armazem);
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
