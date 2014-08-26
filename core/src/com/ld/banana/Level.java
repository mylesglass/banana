package com.ld.banana;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Queue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;

public class Level {
	public static final int LEVEL_STATE_RUNNING = 0;
	public static final int LEVEL_STATE_GAME_OVER = 1;
	public static final int LEVEL_STATE_WIN = 2;
	
	
	public final Bottle bottle;
	private int lanecount;
	public int state;

	public int goal;
	public int distance = 0;

	ArrayList<Obstacle> obstacles;
	ObstacleController obstacleController;

	// Used for differentiating between levels. contains a list of obstacles that will
	// appear during said level, also contains a background image.
	public Level(int objectDensity, int lanecount){
		this.bottle = new Bottle(150, 200);
		obstacles = new ArrayList<Obstacle>();
		this.obstacleController = new ObstacleController(obstacles, objectDensity);
		this.lanecount = lanecount;
		state = Level.LEVEL_STATE_RUNNING;
	}

	/**
	 * Starts the components of level, must be called after obstacles are set.
	 */
	public void start() {
		this.obstacleController.start();
	}

	public void update(float deltaTime) {
		distance++;

		updateBottle(deltaTime);
		updateObstacles(deltaTime);
		//updateDecorations(deltaTime);
		checkCollisions();
		checkGameOver();
	}

	private void checkGameOver() {
		if(bottle.state == Bottle.BOTTLE_STATE_HIT) {
			this.state = Level.LEVEL_STATE_GAME_OVER;
		}

		if(goal <= distance){
			Assets.drums.stop();
			Assets.win.play();
			this.state = Level.LEVEL_STATE_WIN;
		}
	}

	private void checkCollisions() {
		if(isLaneCollision(bottle.lane) && bottle.state == Bottle.BOTTLE_STATE_FLOATING) {
			bottle.state = Bottle.BOTTLE_STATE_HIT;
			Assets.drums.stop();
			Assets.lose.play();
		}
	}

	private boolean isLaneCollision(int lane) {
		Queue<Obstacle> queue = null;

		if(lane == 1) {
			queue = obstacleController.getLane1Queue();
		} else if (lane == 2) {
			queue = obstacleController.getLane2Queue();
		} else if (lane == 3) {
			queue = obstacleController.getLane3Queue();
		}

		if(queue != null) {
			for(Obstacle obs : (Queue<Obstacle>) queue) {
				if(Intersector.overlapConvexPolygons(bottle.bounds, obs.bounds)) {
					System.out.println("Collision!");
					return true;

				}
			}

		}


		return false;
	}

	private void updateObstacles(float deltaTime) {
		this.obstacleController.update(deltaTime);
	}

	private void updateBottle(float deltaTime) {


		bottle.update(deltaTime);

	}



	/**
	 * Add obstacle
	 * @param obstacle
	 */
	public void addObstacle(Obstacle obs){
		obstacles.add(obs);
	}

	/**
	 * Remove Obstacle
	 * @param obstacle
	 */
	public void removeObstacle(Obstacle obs){
		obstacles.remove(obs);
	}

	/**
	 * Get the different types of obstacles that this level has
	 * @return arraylist of obstacles
	 */
	public ArrayList<Obstacle> getObstacles(){
		return obstacles;
	} 



}
