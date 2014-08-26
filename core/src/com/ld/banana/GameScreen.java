package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.ld.banana.BananaGame;

public class GameScreen extends ScreenAdapter{
	static final int GAME_READY = 0;
	static final int GAME_RUNNING = 1;
	static final int GAME_PAUSED = 2;
	static final int GAME_LEVEL_END = 3;
	static final int GAME_OVER = 4;
	static final int GAME_WON = 5;
	
	BananaGame game;
	Level level;
	LevelRenderer renderer;

	int state;
	OrthographicCamera guiCam;

	String distanceString;

	public GameScreen (BananaGame game) {
		this.game = game;
		
		// Create Obstacles
		
		
	}
	
	public void loadLevel(Level level) {
		this.level = level;
		level.addObstacle(new Obstacle(Assets.l1_obstacle1, 1, 1, 800, 200f, true));
		level.addObstacle(new Obstacle(Assets.l1_obstacle2, 1, 1, 1000, 200f, true));
		level.addObstacle(new Obstacle(Assets.l1_obstacle3, 1, 1, 900, 200f, true));
		level.addObstacle(new Obstacle(Assets.l1_obstacle4, 1, 1, 2000, 200f, true));
		level.addObstacle(new Obstacle(Assets.l1_obstacle5, 1, 1, 1500, 200f, true));
		level.start();
		
		guiCam = new OrthographicCamera();
		guiCam.setToOrtho(false, 800, 600);
		
		state = GAME_RUNNING;
		renderer = new LevelRenderer(game.batch, level);
	}

	public void update(float deltaTime) {
		if(deltaTime > 0.1f) deltaTime = 0.1f;
		
		if(level.state == Level.LEVEL_STATE_GAME_OVER) this.state = GameScreen.GAME_OVER;
		if(level.state == Level.LEVEL_STATE_WIN) this.state = GameScreen.GAME_WON;
		
		switch (this.state) {
		case GAME_READY:
			updateReady();
			break;
		case GAME_RUNNING:
			updateRunning(deltaTime);
			break;
		case GAME_PAUSED:
			updatePaused();
			break;
		case GAME_LEVEL_END:
			updateLevelEnd();
			break;
		case GAME_OVER:
			updateGameOver();
			break;
		case GAME_WON:
			updateGameWon();
			break;
		}
		
	}
	
	private void updateReady() {
		
	}
	
	private void updateRunning(float deltaTime) {
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) level.bottle.moveLeft();
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) level.bottle.moveRight();
		
		level.update(deltaTime);
	}
	
	private void updatePaused() {
		
	}
	
	private void updateLevelEnd() {
		
	}
	
	private void updateGameOver() {
		game.level1 = new Level(11, 3);
		game.setScreen(game.bios);
		
	}
	
	private void updateGameWon() {
		if(game.doing.getRecipient() == game.current)
		{
		   System.out.println("made it to game won [gamescreen]");
			
			game.delivered++;
			
			System.out.println(game.delivered);

			game.sending = false;
			game.sender.setMessage(false, null);
			
			if(game.delivered == 1)game.mapImage = Assets.map_stage_2;
			if(game.delivered == 2)game.mapImage = Assets.map_stage_3;
			if(game.delivered == 3)game.mapImage = Assets.map_stage_4;
			if(game.delivered == 4)game.mapImage = Assets.map_stage_5;
			if(game.delivered == 5)game.mapImage = Assets.map_stage_6;
			
			game.level1 = new Level(7, 3);
			game.setScreen(game.bios);
		}
		
		
		if(game.doing.getRecipient() != game.current){
			
			game.setScreen(new WrongScreen(game));
			game.level1 = new Level(7, 3);
		}
		
		
		
	}//<--------
	
	public void draw() {
		GL20 gl = Gdx.gl;
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		renderer.render();
	}
	
	@Override
	public void render (float delta) {
		update(delta);
		draw();
	}

	@Override
	public void pause () {
		if (state == GAME_RUNNING) state = GAME_PAUSED;
	}
}
