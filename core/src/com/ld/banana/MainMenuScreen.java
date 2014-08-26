package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.ld.banana.BananaGame;

public class MainMenuScreen extends ScreenAdapter {
	BananaGame game;
	OrthographicCamera guiCam;
	private Vector2 botPos;
	private int botState = 1; // 1  up, 0 down
	
	public MainMenuScreen(BananaGame bananaGame) {
		this.game = bananaGame;
		this.botPos = new Vector2(328, 129);
		guiCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		guiCam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		
	}
	
	public void update() {
		if(Gdx.input.isKeyPressed(Keys.ENTER)) {
			//game.gameScreen.loadLevel(game.level1);
			//game.setScreen(game.gameScreen);
			Assets.seagull.play(0.1f);
			game.setScreen(game.instructions);
		}
		if(botPos.y == 150 && botState == 1) botState = 0;
		if(botPos.y == 100 && botState == 0) botState = 1;
		
		if(botPos.y < 150 && botState == 1) {
			botPos.y += 0.5f;
			botPos.x += 0.2f;
		}
		if(botPos.y > 100 & botState == 0) {
			botPos.y -= 0.5f;
			botPos.x -= 0.2f;
		}
		
		
	}
	
	public void draw() {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		guiCam.update();
		game.batch.setProjectionMatrix(guiCam.combined);
		
		game.batch.disableBlending();
		game.batch.begin();
		game.batch.draw(Assets.menuBackground, 0 , 0, 800, 600);
		game.batch.enableBlending();
		drawBottle();
		drawOverlay();
		game.batch.end();
		
		
		
	}
	
	

	
	private void drawBottle() {
		game.batch.draw(Assets.menuBottle, botPos.x, botPos.y);
	}
	
	private void drawOverlay() {
		game.batch.draw(Assets.menuOverlay, 0, 0, 800, 600);
		Assets.font_paragraph.draw(game.batch, "Created by", 650, 197);
		Assets.font_paragraph.draw(game.batch, "Neal Hartley &", 650, 175);
		Assets.font_paragraph.draw(game.batch, "Myles Glass", 650, 153);
		Assets.font_title.draw(game.batch, "Six Seas", 100, 270);
		Assets.font_title.draw(game.batch, "of Seperation", 100, 195);
		Assets.font_subheading.draw(game.batch, "press enter to begin", 100, 110);
	}

	
	@Override
	public void render(float delta) {
		update();
		draw();
	}
	
	
}
