package com.ld.banana;

import com.badlogic.gdx.graphics.Texture;

public class Message {
	private Person sender;
	private Person recipient;
	private String message;
	public int distance;
	public Texture image;
	
	/**
	 * Constructs a message object.
	 */
	public Message(Person sender, Person recipient, String msg, int distance, Texture image) {
		this.sender = sender;
		this.recipient = recipient;
		this.message = msg;
		this.distance = distance;
		this.image = image;
	}
	
	/**
	 * Get Sender
	 * @return person sender
	 */
	public Person getSender() {
		return this.sender;
	}
	
	/**
	 * Get recipient
	 * @return person recipient
	 */
	public Person getRecipient() {
		return this.recipient;
	}
	
	/**
	 * Get Message
	 * @return message string
	 */
	public String getMessage() {
		return this.message;
	}
}
