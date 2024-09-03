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
    private Armazen armazem;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        font = new BitmapFont();

        produtor = new Produtor(2.0);
        armazem = new Armazen(5);

        produtor.iniciarProducao();
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        Recurso.RecursoBase recursoColetado = produtor.coletarRecurso();
        armazem.adicionarRecurso(recursoColetado.getTipo());

        batch.begin();
        batch.draw(image, 140, 210);

        font.draw(batch, "Itens no armazém:", 20, 420);
        int y = 400;
        for (String item : armazem.getItens()) {
            font.draw(batch, "- " + item, 20, y);
            y -= 20;
        }

        font.draw(batch, "Último recurso coletado: " + armazem.getUltimoRecurso(), 20, y - 40);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}
