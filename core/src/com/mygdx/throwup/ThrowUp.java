package com.mygdx.throwup;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public class ThrowUp extends Game {
	public static final float SCR_WIDTH = 1600, SCR_HEIGHT = 900;

	SpriteBatch batch;
	OrthographicCamera camera;
	Vector3 touch;
	BitmapFont fontSmall, fontLarge;

	ScreenMenu screenMenu;
	ScreenGame screenGame;

	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		touch = new Vector3();
		fontSmall = new BitmapFont(Gdx.files.internal("baldur_nouveau.fnt"));
		fontLarge = new BitmapFont(Gdx.files.internal("baldur_nouveau.fnt"));

		screenMenu = new ScreenMenu(this);
		screenGame = new ScreenGame(this);

		setScreen(screenMenu);
	}

	@Override
	public void dispose () {
		batch.dispose();
		fontSmall.dispose();
		fontLarge.dispose();
	}
}
