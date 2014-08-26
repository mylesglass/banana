package com.ld.banana;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Bottle extends GameObject{
	
	public static final int BOTTLE_STATE_FLOATING = 0;
	public static final int BOTTLE_STATE_MOVELEFT = 1;
	public static final int BOTTLE_STATE_MOVERIGHT = 2;
	public static final int BOTTLE_STATE_JUMP = 3;
	public static final int BOTTLE_STATE_HIT = 4;
	
	public static final int BOTTLE_WIDTH = 70;
	public static final int BOTTLE_HEIGHT = 70;
	
	private int bob = 1;
	private int moveState = 1;
	
	float stateTime;
	
	int state;
	int lane = 2;
	Polygon bounds;
	Vector2 velocity;
	float laneChangeSpeed = 500f;
	float originX;
	float originY;
	
	// Our main protagonist. has an x and y for drawing on the board. 
	// also has an image.
	
	public Bottle(float x, float y){
		super(x, y, BOTTLE_WIDTH, BOTTLE_HEIGHT);
		state = BOTTLE_STATE_FLOATING;
		stateTime = 0;
		float originX = x + 50;
		float originY = y + 50;
		bounds = new Polygon(new float[]{originX, originY + 50, originX + 100, originY, originX, originY - 50, originX - 100, originY});
		velocity = new Vector2(laneChangeSpeed, laneChangeSpeed/2);
		stateTime = 0;
	}
	
	public void update(float deltaTime) {
		stateTime += deltaTime;
		if(moveState == 1) {
			position.y += bob * deltaTime;
			bob++;
		}
		if(moveState == 0) {
			position.y -= bob * deltaTime;
			bob--;
		}
		if(bob >= 50) moveState = 0;
		if(bob <= 0) moveState = 1;
		
		switch(lane) {
		case 1:
			if(position.x < 250) {
				state = BOTTLE_STATE_MOVERIGHT;
				position.x += velocity.x * deltaTime;
				position.y -= velocity.y * deltaTime;
			} else {
				state = BOTTLE_STATE_FLOATING;
			}
			break;
		case 2: 
			if(position.x < 150) {
				state = BOTTLE_STATE_MOVERIGHT;
				position.x += velocity.x * deltaTime;
				position.y -= velocity.y * deltaTime;
			} else {
				state = BOTTLE_STATE_FLOATING;
			}
			
			if(position.x > 150) {
				state = BOTTLE_STATE_MOVELEFT;
				position.x -= velocity.x * deltaTime;
				position.y += velocity.y * deltaTime;
			} else {
				state = BOTTLE_STATE_FLOATING;
				
			}
			
			break;
		case 3:
			if(position.x > 50) {
				state = BOTTLE_STATE_MOVELEFT;
				position.x -= velocity.x * deltaTime;
				position.y += velocity.y * deltaTime;
			} else {
				state = BOTTLE_STATE_FLOATING;
			}

			break;
		}
		
		updateBounds();
	}
	
	public void updateBounds() {
		originX = position.x -350;
		originY = position.y - 300;
		bounds.setVertices(new float[]{originX, originY + 25, originX + 50, originY, originX, originY - 25, originX - 50, originY});
	}
	
	public void moveRight() {
		Assets.wind.play();
		switch(lane) {
		case 1:
			break;
		case 2:
			lane = 1;
			break;
		case 3:
			lane = 2;
			break;
		}
		
	}
	
	
	public void moveLeft() {
		Assets.wind.play();
		//state = BOTTLE_STATE_MOVELEFT;
		switch(lane) {
		case 1:
			lane = 2;
			break;
		case 2:
			lane = 3;
			break;
		case 3:
			break;
		}
	}
	
	
	public void printStatus() {
		System.out.println("[Bottle] Current state: "+this.state+". Position: ("+position.x+","+position.y+"). Lane: "+this.lane);
	}
}
