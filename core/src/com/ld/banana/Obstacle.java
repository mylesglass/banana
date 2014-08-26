package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;

public class Obstacle {

	private Texture image;
	private String imagePath;
	private int width;
	private int height;
	private int lane;
	private int laneWidth;
	private int laneDepth;
	private int freq;
	private float speed;
	Vector2 velocity;
	Vector2 position;
	Polygon bounds;
	float originX;
	float originY;
	private boolean canHit;
	private float x;
	private float y;
	
	
	// Creates a new obstacles, needs an image to be associated with an int for width
	// and int for depth, an int for frequency(distance between two identical obs),
	// and a boolean on whether it can be hit by our protagonist the bottle.
	
	public Obstacle(Texture image, int width, int depth, int frequency, float speed, boolean canHit){
		this.image = image;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.laneWidth = width;
		this.laneDepth = depth;
		this.freq = frequency;
		this.speed = speed;
		this.velocity = new Vector2(speed, speed/2);
		this.position = new Vector2(x, y);
		this.canHit = canHit;
		this.lane = 1;
		
		bounds = new Polygon(new float[]{originX, originY + 50, originX + 100, originY, originX, originY - 50, originX - 100, originY});
	}
	
	public void updateBounds() {
		originX = position.x -350;
		originY = position.y - 275;
		bounds.setVertices(new float[]{originX, originY + 25, originX + 50, originY, originX, originY - 25, originX - 50, originY});
	}
	
	public void update() {
		updateBounds();
	}
	
	/**
	 * Draw this obstacle on supplied batch
	 * @param spritebatch
	 */
	public void draw(SpriteBatch batch) {
		batch.draw(this.image, x, y);
	}
	
	/**
	 * get x position of obstacle
	 * @return x
	 */
	public float getX() {
		return this.x;
	}
	
	/**
	 * set the x position of this obstacle
	 * @param x
	 */
	public void setX(float x) {
		this.x = x;
	}
	
	/**
	 * Get the Y position of Obstacle
	 * @return y
	 */
	public float getY() {
		return this.y;
	}
	
	/**
	 * Set the Y position of Obstacle
	 * @param y
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * Get the current lane this object occupies
	 * @return int lane
	 */
	public int getLane() {
		return this.lane;
	}
	
	/**
	 * Set the current lane that this object occupies
	 * @param int lane
	 */
	public void setLane(int lane) {
		this.lane = lane;
	}
	
	public Texture getImage(){
		return image;
	}
	
	public int getWidth(){
	    return width;
	}
	
	public int getHeight(){
	    return height;
	}
	
	public int getLaneWidth() {
		return this.laneWidth;
	}
	
	public int getLaneDepth(){
		return laneDepth;
	}
	
	public int getFreq(){
		return freq;
	}
	
	/**
	 * Get the speed of this object
	 * @return int speed
	 */
	public float getSpeed() {
		return speed;
	}
	
	public void setFreq(int newFreq){
		freq=newFreq;
	}
	
	public void setType(boolean canHit){
		this.canHit = canHit;
	}
	
	public Obstacle clone() {
		return new Obstacle(this.image, this.laneWidth, this.laneDepth, this.freq, this.speed, this.canHit);
	}
	
}
