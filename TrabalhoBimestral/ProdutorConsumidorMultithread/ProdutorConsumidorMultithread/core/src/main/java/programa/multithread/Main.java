package programa.multithread;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private BitmapFont font;
    
    private Produtor produtor;  // Variável para armazenar a instância do Produtor
    private Armazen armazem;    // Armazém para guardar os recursos

    private String ultimoRecursoColetado;
    
    @Override
    public void create() {
        // Inicializando os objetos gráficos
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        font = new BitmapFont(); // Fonte para mostrar o texto na tela

        // Inicializando o Produtor e Armazém
        produtor = new Produtor(2.0);  // Produtor com velocidade de produção de 2 segundos
        armazem = new Armazen(5);  // Armazém com capacidade máxima de 5 itens

        // Inicializando o último recurso coletado
        ultimoRecursoColetado = "Nenhum recurso coletado";
    }

    @Override
    public void render() {
        // Limpa a tela
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Coleta um recurso novo a cada frame
        Recurso.RecursoBase recursoColetado = produtor.coletarRecurso();
        armazem.adicionarRecurso(recursoColetado.getTipo());
        ultimoRecursoColetado = recursoColetado.getTipo();

        // Inicia o desenho
        batch.begin();
        batch.draw(image, 140, 210);

        // Exibe o último recurso coletado
        font.draw(batch, "Último recurso coletado: " + ultimoRecursoColetado, 20, 450);

        // Exibe os itens no armazém
        font.draw(batch, "Itens no armazém:", 20, 420);
        int y = 400;
        for (String item : armazem.getItens()) {
            font.draw(batch, "- " + item, 20, y);
            y -= 20;  // Reduz a posição vertical para mostrar o próximo item
        }

        batch.end();
    }

    @Override
    public void dispose() {
        // Libera os recursos
        batch.dispose();
        image.dispose();
        font.dispose();
    }
}
