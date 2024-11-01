package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class SettingsScreen implements Screen {
    private final AngryBirdsGame game;
    private OrthographicCamera camera;
    private Texture background;
    private Texture settingsheader;
    private Texture muteSFXButton;
    private Texture muteMusicButton;
    private Texture settingsbackButton;

    public SettingsScreen(AngryBirdsGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        background = new Texture("background.png");
        settingsheader = new Texture("settingslogo.png");
        muteSFXButton = new Texture(game.isSFXMuted ? "mutedsfx.png" : "sfx.png");
        muteMusicButton = new Texture(game.isMusicMuted ? "mutedmusic.png" : "music.png");
        settingsbackButton = new Texture("back.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.batch.draw(settingsheader, 300, 400, 200, 70);
        game.batch.draw(muteSFXButton, 225, 200, 90, 90);
        game.batch.draw(muteMusicButton, 475, 200, 90, 90);
        game.batch.draw(settingsbackButton, 50, 20, 75, 50);
        game.batch.end();

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (touchPos.x > 225 && touchPos.x < 315 && touchPos.y > 200 && touchPos.y < 290) {
                game.isSFXMuted = !game.isSFXMuted;
                muteSFXButton.dispose();
                muteSFXButton = new Texture(game.isSFXMuted ? "mutedsfx.png" : "sfx.png");
            }

            if (touchPos.x > 475 && touchPos.x < 565 && touchPos.y > 200 && touchPos.y < 290) {
                game.isMusicMuted = !game.isMusicMuted;
                muteMusicButton.dispose();
                muteMusicButton = new Texture(game.isMusicMuted ? "mutedmusic.png" : "music.png");
            }

            if (touchPos.x > 50 && touchPos.x < 125 && touchPos.y > 20 && touchPos.y < 70) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
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
        muteSFXButton.dispose();
        muteMusicButton.dispose();
        settingsbackButton.dispose();
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}
