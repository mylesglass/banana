package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;

public class LetterScreen extends ScreenAdapter{
	private BananaGame game;
	
	public LetterScreen (BananaGame game) {
		this.game = game;
	}
	
	private void update() {
		if(Gdx.input.isTouched()) {
			if(Gdx.input.getX() > 700 && Gdx.input.getX() < 775 && Gdx.input.getY() > 100) {
				game.setScreen(game.worldScreen);
			}
		}
	}
	
	private void draw() {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 1, 1, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		game.batch.begin();
		game.batch.draw(Assets.bio_letter_bg, 0, 0);
		game.batch.draw(game.doing.image, 400 - game.doing.image.getWidth() / 2, 300 - game.doing.image.getHeight() / 2);
		game.batch.draw(Assets.bio_back, 700, 100);
		game.batch.end();
	}
	
	@Override
	public void render(float delta){
		update();
		draw();
	}
}
