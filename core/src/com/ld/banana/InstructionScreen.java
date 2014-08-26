package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;

public class InstructionScreen extends ScreenAdapter{
	private BananaGame game;
	
	public InstructionScreen (BananaGame game) {
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
		Assets.font_title.setColor(Color.BLACK);
		Assets.font_paragraph.setColor(Color.BLACK);
		Assets.font_title.draw(game.batch, "How to play", 25, 570);
		Assets.font_paragraph.drawMultiLine(game.batch, "You are the god of messages in bottles.\nConnect the world.\nEach bottle has a destined recipient\nAre you a bad enough dude to figure it out?"
				+"\n\nOne bottle will appear at a time\nClick on the characters to find the message,\nand then choose a character to guide it to.\nUse the arrow keys to control bottle.\n\nThanks for playing", 25, 460);
		game.batch.draw(Assets.play_button, 700, 100);
		
		game.batch.end();
	}
	
	@Override
	public void render(float delta){
		update();
		draw();
	}
}
