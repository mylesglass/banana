package com.ld.banana;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.badlogic.gdx.math.Intersector;

public class ObstacleController {
	
	private ArrayList<Obstacle> obstacles;
	
	private Queue<Obstacle> lane1Queue;
	private Queue<Obstacle> lane2Queue;
	private Queue<Obstacle> lane3Queue;
	
	private Queue<Obstacle> collideQueue;
	
	private int numOfCurrentObstacles;
	
	/**
	 * Obstacle Controller
	 * Controls the flow of obstacles on the screen during levels.
	 * @param obstacles
	 */
	public ObstacleController(ArrayList<Obstacle> obstacles, int numOfCurrentObstacles) {
		this.obstacles = obstacles;
		this.lane1Queue = new LinkedList<Obstacle>();
		this.lane2Queue = new LinkedList<Obstacle>();
		this.lane3Queue = new LinkedList<Obstacle>();
		
		this.collideQueue = new LinkedList<Obstacle>();
		
		this.numOfCurrentObstacles = numOfCurrentObstacles;
	}
	
	/**
	 * get the lane 1 queue
	 * @return
	 */
	public LinkedList<Obstacle> getLane1Queue() {
		return (LinkedList<Obstacle>) this.lane1Queue;
	}
	
	/**
	 * get the lane 2 queue
	 * @return
	 */
	public LinkedList<Obstacle> getLane2Queue() {
		return (LinkedList<Obstacle>) this.lane2Queue;
	}
	
	/**
	 * get the lane 3 queue
	 * @return
	 */
	public LinkedList<Obstacle> getLane3Queue() {
		return (LinkedList<Obstacle>) this.lane3Queue;
	}
	
	public void start() {
		
		for(int i = 0; i < this.numOfCurrentObstacles; i++) {
			
			//create obstacle
			int rand = (int)( Math.random() * this.obstacles.size());
			Obstacle ob = obstacles.get(rand).clone();

			generateNewPos(ob);
			
		
			switch(ob.getLane()) {
			case 1:
				if(checkQueuePosition(lane1Queue, ob)) {
					lane1Queue.offer(ob);
				}
				break;
			case 2:
				if(checkQueuePosition(lane2Queue, ob)) {
					lane2Queue.offer(ob);
				}
				break;
			case 3: 
				if(checkQueuePosition(lane3Queue, ob)) {
					lane3Queue.offer(ob);
				}
				break;
			}
		}
	}
	
	public void update(float deltaTime) {
		if(!collideQueue.isEmpty()) {
			obstacleRecycle(collideQueue);
		}
		
		//System.out.println("Q1 Size: "+lane1Queue.size()+" Q2 Size: "+lane2Queue.size()+" Q3 Size: "+lane3Queue.size()+" Total: "+(lane1Queue.size()+lane2Queue.size()+lane3Queue.size()));
		
		updateQueue(lane1Queue, deltaTime);
		updateQueue(lane2Queue, deltaTime);
		updateQueue(lane3Queue, deltaTime);
		
		recycleCheck(lane1Queue);
		recycleCheck(lane2Queue);
		recycleCheck(lane3Queue);
	}
	
	private void updateQueue(Queue<Obstacle> queue, float deltaTime) {
		for(Obstacle ob : queue) {
			ob.update();
			ob.position.x -= ob.velocity.x * deltaTime;
			ob.position.y -= ob.velocity.y * deltaTime;
		}
	}
	
	private void recycleCheck(Queue<Obstacle> queue) {
		if(queue.peek() != null) {
			Obstacle checking = queue.peek();
			if(checking.position.x < (0 - checking.getWidth())) {
				obstacleRecycle(queue);
			}
		}
	}
	
	private void obstacleRecycle(Queue<Obstacle> queue) {
		Obstacle recycle = (Obstacle) queue.poll();
		
		generateNewPos(recycle);
		recycle.update();

		//this.obstacleQueue.offer(recycle);
		
		switch(recycle.getLane()) {
		case 1:
			if(checkQueuePosition(lane1Queue, recycle)) {
				lane1Queue.offer(recycle);
			}
			break;
		case 2:
			if(checkQueuePosition(lane2Queue, recycle)) {
				lane2Queue.offer(recycle);
			}
			break;
		case 3: 
			if(checkQueuePosition(lane3Queue, recycle)) {
				lane3Queue.offer(recycle);
			}
			break;
		}
	}
	
	private boolean checkQueuePosition(Queue<Obstacle> queue, Obstacle check) {
		if(queue.isEmpty()) return true;
		for(Obstacle ob : queue) {
			if(Intersector.overlapConvexPolygons(ob.bounds, check.bounds)) {
				//checkQueuePosition(queue, check);
				collideQueue.offer(check);
				return false;
			}
		}
		
		return true;
	}
	
	
	
	private void generateNewPos(Obstacle ob) {
		ob.setLane(generateLane());
		//System.out.println("New Lane : "+ob.getLane());
		ob.position.x = 800 + (int)(Math.random() * ob.getFreq());
		ob.position.y = (ob.position.x / 2) + (ob.getLane() * 100) - 100;
	}
	
	private int generateLane() {
		return (int) (1 +(Math.random() * 3));
	}
}
