package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import java.util.ArrayList;
import java.util.List;

public class Level1Screen implements Screen {
    private final AngryBirdsGame game;
    private OrthographicCamera camera;
    private Texture background, catapult, pauseButton, resumeButton, restartButton, levelsButton, pauseMenuBox, pauseHeader, crossButton, winButton, loseButton, victory, levelfailed, nextlevelButton, loseguilaughingpig;
    private Texture emptyStar, fullStar;
    private List<Bird> birds;
    private List<Pig> pigs;
    private Structure structure;
    private boolean isPaused = false;
    private boolean showWinGUI = false;
    private boolean showLoseGUI = false;
    private int filledStars = 0;
    private ShapeRenderer shapeRenderer;

    public Level1Screen(AngryBirdsGame game) {
        this.game = game;

        shapeRenderer = new ShapeRenderer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        background = new Texture("background1.jpg");
        catapult = new Texture("catapult.png");
        pauseHeader = new Texture("pauseheader.png");
        pauseButton = new Texture("pause.png");
        resumeButton = new Texture("resume.png");
        restartButton = new Texture("restart.png");
        nextlevelButton = new Texture("nextlevel.png");
        levelsButton = new Texture("levels.png");
        pauseMenuBox = new Texture("wooden_box.png");
        crossButton = new Texture("crossButton.png");
        winButton = new Texture("winbutton.png");
        loseButton = new Texture("losebutton.png");
        emptyStar = new Texture("starblank.png");
        fullStar = new Texture("starfull.png");
        victory = new Texture("victory.png");
        levelfailed = new Texture("levelfailed.png");
        loseguilaughingpig = new Texture("losescreenlaughingpig.png");

        birds = new ArrayList<>();
        birds.add(new Bird(5, 100, "bluebird"));
        birds.add(new Bird(50, 100, "yellowbird"));
        birds.add(new Bird(95, 100, "redbird"));

        pigs = new ArrayList<>();
        pigs.add(new Pig(500, 200, "pig"));
        pigs.add(new Pig(550, 200, "foremanpig"));
        pigs.add(new Pig(600, 200, "kingpig"));

        structure = new Structure();

        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 touchPos = new Vector3(screenX, screenY, 0);
                camera.unproject(touchPos);

                if (!isPaused && touchPos.x >= 700 && touchPos.x <= 775 && touchPos.y >= 20 && touchPos.y <= 70) {
                    showWinGUI = true;
                    startStarAnimation();
                } else if (!isPaused && touchPos.x >= 600 && touchPos.x <= 675 && touchPos.y >= 20 && touchPos.y <= 70) {
                    showLoseGUI = true;
                } else if (!isPaused && touchPos.x >= 360 && touchPos.x <= 410 && touchPos.y >= 410 && touchPos.y <= 460) {
                    isPaused = true;
                } else if (isPaused) {
                    if (touchPos.x >= 295 && touchPos.x <= 345 && touchPos.y >= 255 && touchPos.y <= 305) {
                        isPaused = false;
                    } else if (touchPos.x >= 362 && touchPos.x <= 412 && touchPos.y >= 255 && touchPos.y <= 305) {
                        game.setScreen(new Level1Screen(game));
                    } else if (touchPos.x >= 430 && touchPos.x <= 480 && touchPos.y >= 255 && touchPos.y <= 305) {
                        Gdx.input.setInputProcessor(null);
                        game.setScreen(new LevelsScreen(game));
                    } else if (touchPos.x >= 478 && touchPos.x <= 518 && touchPos.y >= 356 && touchPos.y <= 396) {
                        isPaused = false;
                    }
                }

                if (showWinGUI) {
                    if (touchPos.x >= 275 && touchPos.x <= 325 && touchPos.y >= 130 && touchPos.y <= 180) {
                        game.setScreen(new LevelsScreen(game));
                        showWinGUI = false;
                    } else if (touchPos.x >= 375 && touchPos.x <= 425 && touchPos.y >= 130 && touchPos.y <= 180) {
                        game.setScreen(new Level1Screen(game));
                        showWinGUI = false;
                    }
                }

                if (showLoseGUI) {
                    if (touchPos.x >= 275 && touchPos.x <= 325 && touchPos.y >= 130 && touchPos.y <= 180) {
                        game.setScreen(new LevelsScreen(game));
                        showLoseGUI = false;
                    } else if (touchPos.x >= 375 && touchPos.x <= 425 && touchPos.y >= 130 && touchPos.y <= 180) {
                        game.setScreen(new Level1Screen(game));
                        showLoseGUI = false;
                    }
                }

                return true;
            }
        });
    }

    private void startStarAnimation() {
        filledStars = 0;
        Timer.schedule(new Task() {
            @Override
            public void run() {
                if (filledStars < 3) {
                    filledStars++;
                } else {
                    cancel();
                }
            }
        }, 0.5f, 0.5f, 2);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0, 800, 480);
        game.batch.draw(catapult, 120, 100, 85, 100);
        game.batch.draw(winButton, 700, 20, 75, 50);
        game.batch.draw(loseButton, 600, 20, 75, 50);

        if (!isPaused && !showWinGUI && !showLoseGUI) {
            game.batch.draw(pauseButton, 360, 410, 50, 50);
        }

        for (Bird bird : birds) bird.render(game.batch);
        for (Pig pig : pigs) pig.render(game.batch);
        structure.render(game.batch);

        if (showWinGUI) {
            game.batch.draw(pauseMenuBox, 200, 100, 400, 260);
            game.batch.draw(victory, 313, 240, 165, 50);
            game.batch.draw(levelsButton, 275, 130, 50, 50);
            game.batch.draw(restartButton, 375, 130, 50, 50);
            game.batch.draw(nextlevelButton, 475, 130, 50, 50);
            for (int i = 0; i < 3; i++) {
                Texture starTexture = (i < filledStars) ? fullStar : emptyStar;
                game.batch.draw(starTexture, 240 + i * 110, 300, 100, 100);
            }
        }

        if (showLoseGUI) {
            game.batch.draw(pauseMenuBox, 200, 100, 400, 260);
            game.batch.draw(levelfailed, 300, 275, 215, 50);
            game.batch.draw(levelsButton, 275, 130, 50, 50);
            game.batch.draw(restartButton, 375, 130, 50, 50);
            game.batch.draw(nextlevelButton, 475, 130, 50, 50);
            game.batch.draw(loseguilaughingpig, 360, 190, 75, 75);
        }

        game.batch.end();

        if (isPaused) {
            Gdx.gl.glEnable(GL20.GL_BLEND);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setProjectionMatrix(camera.combined);
            shapeRenderer.setColor(0, 0, 0, 0.4f);
            shapeRenderer.rect(0, 0, 800, 480);
            shapeRenderer.end();
            Gdx.gl.glDisable(GL20.GL_BLEND);

            game.batch.begin();
            game.batch.draw(pauseMenuBox, 262, 150, 250, 250);
            game.batch.draw(pauseHeader, 313, 345, 150, 60);
            game.batch.draw(crossButton, 478, 356, 40, 40);
            game.batch.draw(resumeButton, 295, 255, 50, 50);
            game.batch.draw(restartButton, 362, 255, 50, 50);
            game.batch.draw(levelsButton, 430, 255, 50, 50);
            game.batch.end();
        }
    }

    @Override
    public void dispose() {
        background.dispose();
        catapult.dispose();
        pauseButton.dispose();
        resumeButton.dispose();
        restartButton.dispose();
        levelsButton.dispose();
        pauseMenuBox.dispose();
        pauseHeader.dispose();
        winButton.dispose();
        loseButton.dispose();
        emptyStar.dispose();
        fullStar.dispose();
        victory.dispose();
        levelfailed.dispose();
        shapeRenderer.dispose();
        for (Bird bird : birds) bird.dispose();
        for (Pig pig : pigs) pig.dispose();
    }

    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void show() {}
    @Override
    public void hide() {}
}
