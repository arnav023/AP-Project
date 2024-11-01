package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class LevelsScreen implements Screen {
    private final AngryBirdsGame game;
    private OrthographicCamera camera;
    private Texture background;
    private Texture level1Button;
    private Texture level2Button;
    private Texture level3Button;
    private Texture level4Button;
    private Texture level5Button;
    private Texture randomlevelButton;
    private Texture backButton;
    private Texture header;

    public LevelsScreen(AngryBirdsGame game) {
        this.game = game;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        background = new Texture("background.png");
        level1Button = new Texture("level1.png");
        level2Button = new Texture("level2.png");
        level3Button = new Texture("level3.png");
        level4Button = new Texture("level4.png");
        level5Button = new Texture("level5.png");
        randomlevelButton = new Texture("randomlevel.png");
        backButton = new Texture("back.png");
        header = new Texture("levelsheader.png");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.batch.draw(header, 300, 400, 200, 70);
        game.batch.draw(level1Button, 170, 230, 90, 90);
        game.batch.draw(level2Button, 345, 230, 90, 90);
        game.batch.draw(level3Button, 520, 230, 90, 90);
        game.batch.draw(level4Button, 170, 90, 90, 90);
        game.batch.draw(level5Button, 345, 90, 90, 90);
        game.batch.draw(randomlevelButton, 520, 90, 90, 90);
        game.batch.draw(backButton, 50, 20, 75, 50);
        game.batch.end();

        handleInput();
    }

    private void handleInput() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (touchPos.x > 50 && touchPos.x < 125 && touchPos.y > 20 && touchPos.y < 70) {
                game.setScreen(new MainMenuScreen(game));
                dispose();
            }

            if (touchPos.x > 170 && touchPos.x < 260 && touchPos.y > 230 && touchPos.y < 320) {
                game.setScreen(new Level1Screen(game));
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
        level1Button.dispose();
        level2Button.dispose();
        level3Button.dispose();
        backButton.dispose();
        header.dispose();
    }

    @Override public void show() {}
    @Override public void hide() {}
    @Override public void pause() {}
    @Override public void resume() {}
}
