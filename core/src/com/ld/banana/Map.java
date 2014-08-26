package com.ld.banana;

import java.util.ArrayList;
/**
public enum Locations {
	NZ			(x,y),
	NY			(x,y),
	NORWAY		(x,y),
	ENGLAND		(x,y),
	NK			(x,y),
	DRCONGO		(x,y),
	VIETNAM		(x,y),
	LA			(x,y)
}
*/
public class Map {
	private ArrayList<Person> people;
	//private routes?
	
	public Map(ArrayList<Person> people) {
		this.people = people;
	}
	
	public ArrayList<Person> getPeople() {
		return this.people;
	}
	
}
