package pl.bbl.osbir.engine.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import pl.bbl.osbir.properties.OsbirProperties;

public abstract class AbstractScreen implements Screen {
    protected AssetManager assetManager;
    protected OrthographicCamera orthographicCamera;
    protected OsbirProperties osbirProperties;
    protected SpriteBatch spriteBatch;
    protected Stage stage;
    protected final Game game;

    public AbstractScreen(final Game game){
        this.game = game;
        assetManager = new AssetManager();
        orthographicCamera = new OrthographicCamera();
        osbirProperties = new OsbirProperties();
        spriteBatch = new SpriteBatch();
        setupStage();
        setupCamera();
    }

    private void setupCamera(){
        orthographicCamera.setToOrtho(false, osbirProperties.getViewportWidth(), osbirProperties.getViewportHeight());
    }

    private void setupStage(){
        stage = new Stage(new StretchViewport(osbirProperties.getViewportWidth(), osbirProperties.getViewportHeight()));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        assetManager.update();
        update();
        spriteBatch.begin();
        draw();
        spriteBatch.end();
    }

    protected abstract void draw();

    protected abstract void update();

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}