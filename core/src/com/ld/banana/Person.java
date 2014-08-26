package com.ld.banana;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Person extends Actor{
	private String name;
	private String bio;
	private int x;
	private int y;
	private Texture texture;
	private Texture flag;
	private TextureRegion button; 
	private Boolean hasMessage = false;
	public Message message;
	
	/**
	 * Constructs a new person to be placed on the map.
	 * @param persons name
	 * @param bio of person
	 * @param x position on map
	 * @param y position on map
	 */
	public Person(String name, String bio, int x, int y, Texture pic, Texture flag) {
		this.name = name;
		this.bio = bio;
		this.x = x;
		this.y = y;
		texture = pic;
		button = new TextureRegion(pic);
		this.flag = flag;
	}
	
	public Texture getFlag() {
		return this.flag;
	}
	
	/**
	 * Get X Position on Map
	 * @return x map pos
	 */
	public int getMapX() {
		return this.x;
	}
	
	/**
	 * Get Y Position on Map
	 * @return x map pos
	 */
	public int getMapY() {
		return this.y;
	}
	
	/**
	 * Get this persons name
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get this persons bio
	 * @return bio
	 */
	public String getBio() {
		return this.bio;
	}
	
	public Texture getTexture(){
		return texture;
	}

	public void setMessage(boolean b, Message m){//<-----------
		hasMessage = b;
		this.message =m;//<-----------
	}
	
	public Boolean getMessage(){
		return hasMessage;
		
	}
	
	
}
