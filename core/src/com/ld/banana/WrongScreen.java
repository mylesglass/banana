package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WrongScreen extends ScreenAdapter {

	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BananaGame game;
	
	public WrongScreen(BananaGame game){
		this.game = game;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		
		
		
	}
	
	public void update(){}
	
	public void draw(){
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Assets.font_paragraph.setColor(Color.BLACK);
		Assets.font_paragraph.drawMultiLine(batch, "Although you managed to deliver the message\n it was delivered to the wrong recipient.\n They pick up the bottle read the letter and throw it away.\n\n Try again.\n\n (Perhaps this time think more carefully about the clues.)\n\n Click To Continue.",100, 500);
		batch.end();
		
		
		if(Gdx.input.isTouched()) {
			
			game.setScreen(game.worldScreen);
			
			
		}
	}
	
	
	@Override
	public void render(float delta){
		update();
		draw();
	}
	
}
