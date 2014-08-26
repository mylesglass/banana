package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WinScreen extends ScreenAdapter{

	private OrthographicCamera camera;
	private SpriteBatch batch;
	
	public WinScreen(){
		
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		
		
	}
	
	public void update(){}
	public void draw(){
		Gdx.gl.glClearColor(0.5f, 0, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		Assets.font_paragraph.draw(batch, " YOU WIN! " ,340,300);
		batch.end();
	}
	
	@Override
	public void render(float delta){
		update();
		draw();
	}
	
	
	
	
}
