package com.ld.banana;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class LevelRenderer {
	Level level;
	OrthographicCamera cam;
	SpriteBatch batch;

	public LevelRenderer(SpriteBatch batch, Level level) {
		this.level = level;
		this.cam = new OrthographicCamera(800, 600);
		this.batch = batch;
	}

	public void render() {
		cam.update();
		renderBackground();
		renderDecorations();
		renderObjects();
		
	}
	
	public void renderDebug() {
		ShapeRenderer sr = new ShapeRenderer();
		sr.setProjectionMatrix(cam.combined);
		
		sr.begin(ShapeType.Line);
		sr.setColor(1, 1, 0, 1);
		for(Obstacle ob : level.obstacleController.getLane1Queue()) {
			sr.polygon(ob.bounds.getVertices());
		}
		for(Obstacle ob : level.obstacleController.getLane2Queue()) {
			sr.polygon(ob.bounds.getVertices());
		}
		for(Obstacle ob : level.obstacleController.getLane3Queue()) {
			sr.polygon(ob.bounds.getVertices());
		}
		sr.polygon(level.bottle.bounds.getVertices());
		sr.end();
	}

	public void renderBackground() {
		batch.disableBlending();
		batch.begin();
		batch.draw(Assets.levelBackground, 0, 0);
		batch.end();
	}

	public void renderObjects() {
		batch.enableBlending();
		batch.begin();
		
		renderBottle();
		renderObstacles();
		
		renderUI();
		batch.end();
	}

	public void renderBottle() {
		
		batch.draw(Assets.bottle, level.bottle.position.x, level.bottle.position.y);
	}
	
	public void renderUI() {
		Assets.font_paragraph.draw(batch, "Distance Covered "+level.distance, 30, 30);
		Assets.font_paragraph.draw(batch, "Goal: " + level.goal,250 ,30);
	}

	public void renderObstacles() {
		for(Obstacle obs : level.obstacleController.getLane3Queue()) {
			batch.draw(obs.getImage(), obs.position.x, obs.position.y);
		}
		if(level.bottle.lane == 3) renderBottle();
		for(Obstacle obs : level.obstacleController.getLane2Queue()) {
			batch.draw(obs.getImage(), obs.position.x, obs.position.y);
		}
		if(level.bottle.lane == 2) renderBottle();
		for(Obstacle obs : level.obstacleController.getLane1Queue()) {
			batch.draw(obs.getImage(), obs.position.x, obs.position.y);
		}
		if(level.bottle.lane == 1) renderBottle();
	}
	private void renderDecorations() {
		
	}
}
