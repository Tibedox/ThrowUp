package com.mygdx.throwup;

import static com.mygdx.throwup.ThrowUp.SCR_HEIGHT;
import static com.mygdx.throwup.ThrowUp.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class ScreenGame implements Screen {
    ThrowUp main;

    SpriteBatch batch;
    OrthographicCamera camera;
    Vector3 touch;
    BitmapFont fontLarge;

    Texture imgBackGround;
    Texture[] imgFruit = new Texture[6];

    MyButton btnPlay;
    MyButton btnBack;

    Array<Fruit> fruits = new Array<>();

    public ScreenGame(ThrowUp main) {
        this.main = main;

        batch = main.batch;
        camera = main.camera;
        touch = main.touch;
        fontLarge = main.fontLarge;

        imgBackGround = new Texture("bg1.jpg");
        for (int i = 0; i < imgFruit.length; i++) {
            imgFruit[i] = new Texture("ball"+i+".png");
        }

        btnPlay = new MyButton("Go", 100, 700, fontLarge);
        btnBack = new MyButton("Back", 100, 600, fontLarge);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания
        if(Gdx.input.justTouched()){
            touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touch);

            if(btnPlay.hit(touch.x, touch.y)){
                fruits.add(new Fruit());
            }
            if(btnBack.hit(touch.x, touch.y)){
                main.setScreen(main.screenMenu);
            }
        }

        // события игры
        for(Fruit f: fruits) f.move();

        // отрисовка
        ScreenUtils.clear(1, 0, 0, 1);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        batch.draw(imgBackGround, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnBack.font.draw(batch, btnBack.text, btnBack.x, btnBack.y);
        for(Fruit f: fruits) batch.draw(imgFruit[f.type], f.getX(), f.getY(), f.width/2, f.height/2,
                f.width, f.height, 1, 1, f.rotation, 0, 0, 200, 200, false, false);
        batch.end();
    }

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
        imgBackGround.dispose();
    }
}
