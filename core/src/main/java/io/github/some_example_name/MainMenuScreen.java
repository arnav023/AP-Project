package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen implements Screen {
    private final AngryBirdsGame game;
    private OrthographicCamera camera;
    private Texture background;
    private Texture playButton;
    private Texture loadgameButton;
    private Texture settingsButton;
    private Texture exitButton;

    public MainMenuScreen(AngryBirdsGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        background = new Texture("background.png");
        playButton = new Texture("play.png");
        loadgameButton = new Texture("loadgame.png");
        settingsButton = new Texture("settings.png");
        exitButton = new Texture("exit.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.batch.draw(playButton, 270, 265, 250, 65);
        game.batch.draw(loadgameButton, 270, 175, 250, 65);
        game.batch.draw(settingsButton, 570, 20, 60, 60);
        game.batch.draw(exitButton, 685, 20, 60, 60);
        game.batch.end();

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (touchPos.x > 270 && touchPos.x < 520 && touchPos.y > 265 && touchPos.y < 330) {
                game.setScreen(new LevelsScreen(game));
                dispose();
            }
            if (touchPos.x > 270 && touchPos.x < 520 && touchPos.y > 175 && touchPos.y < 240) {
                game.setScreen(new SavedGamesScreen(game));
                dispose();
            }

            if (touchPos.x > 570 && touchPos.x < 630 && touchPos.y > 20 && touchPos.y < 80) {
                game.setScreen(new SettingsScreen(game));
                dispose();
            }

            if (touchPos.x > 685 && touchPos.x < 745 && touchPos.y > 20 && touchPos.y < 80) {
                Gdx.app.exit();
            }
        }
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
        settingsButton.dispose();
        exitButton.dispose();
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}
