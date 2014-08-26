package com.ld.banana;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BananaGame extends Game {
	// Screens 
	public MainMenuScreen mainMenuScreen;
	public GameScreen gameScreen;
	public WorldScreen worldScreen;
	public InstructionScreen instructions;

	// Levels
	public Level level1;

	// Sprite Batcher
	public SpriteBatch batch;

	//messages delivered counter;
	public Message doing;
	int delivered = 0;

	// Map 
	private Map map;
	ArrayList<Person> people;
	BiosScreen bios;
	public Person current;
	public Person sender;
	public Boolean sending = false;
	
	//mapimage
	public Texture mapImage;
	

	//people
	public Person leatherman;
	public Person oldman;
	public Person NBAstar;
	public Person asian;
	public Person professor;
	public Person girl;
	public Person warvet;
	public Person rapper;

	@Override
	public void create () {
		batch = new SpriteBatch();
		Assets.load();
		 mapImage = Assets.map_stage_1;

		// Map Initialisation
		people = new ArrayList<Person>();
		leatherman = new Person("Leatherman", 
				"Leather guy is a \n"
						+ "semi-professional \n"
						+ "strongman/ mortgage \n"
						+ "broker by day, and \n"
						+ "spends his nights as a \n"
						+ "sado-masochistic \n"
						+ "submissive. Longs for a \n"
						+ "friend who doesn’t want to \n"
						+ "put stuff in his butt."
						, 336, 600-479, Assets.leathermanBody, Assets.bio_flag_norway);

		oldman = new Person("Oldman", "Old White Guy is a retired\nsandwhich technician. Now\n in his 90's, he has realised\nall his friends are deceased\n or out of contact. Flies RC\nplanes on the weekend,\nbut looking for more\nhobbies to fill his day.", 313, 600-427, Assets.oldmanBody, Assets.bio_flag_england);

		NBAstar = new Person("NBA star", "20-something year old future\n NBA hall of famer,\n he has taken his summer off\n to relax in his home country\n of the DR Congo,\n due to unforseen\n circumstances, cannot stay\n in his usual vacation spot.\n Has fathered manychildren. ", 384, 600-233, Assets.nbastarBody,Assets.bio_flag_congo );

		professor = new Person("Professor", "40-something university\n professor teaching\n software engineering.\n past-times include\n bodybuilding and robotics.\n Makes commits to\n open-source projects in\n his spare time\n while listening to hip-hop. ", 780 , 600-159, Assets.professorBody, Assets.bio_flag_nz);

		asian = new Person("Lady","Qualified masseuse\n working in a resort.\n Comes into contact with the\n rich and famous\n on a daily basis.\n She likes to drink\n White Russians.", 609, 600-306, Assets.asianBody, Assets.bio_flag_vietnam);

		girl = new Person("Girl", "Wants to know what life\n is like outside of her country.\n Fascinated by the lifestyle\n of the capitalist swine\n of the United States of America.\n Enjoys daily military drills,\n and harvesting. ", 649, 600-360, Assets.girlBody, Assets.bio_flag_nk);

		warvet = new Person("War Veteran", "Ex-Vietnam veteran\n who came home wounded.", 23, 600-365 , Assets.warVetBody, Assets.bio_flag_usa );

		rapper = new Person("rapper", "Famous rapper\n living in New York City.\n Claims to be\n the seconds coming of Jesus.\n At the forefront of\n rap-technology innovation,\n well known for his previous\n work with a vocoder. ", 154, 600-372, Assets.rapperBody, Assets.bio_flag_usa);

		//test message.
		if(delivered == 0){
			Message oldmanMessage = new Message(oldman, leatherman, "holla!" , 1000, Assets.letter_norway_england);//<-----------
			oldman.setMessage(true, oldmanMessage);

		}


		people.add(NBAstar);
		people.add(leatherman);
		people.add(oldman);
		people.add(professor);
		people.add(asian);
		people.add(rapper);
		people.add(girl);
		people.add(warvet);
		
		map = new Map(people);


		// Screens
		mainMenuScreen = new MainMenuScreen(this);
		gameScreen = new GameScreen(this);
		level1 = new Level(11, 3);
		worldScreen = new WorldScreen(this);
		instructions = new InstructionScreen(this);

		setScreen(mainMenuScreen);

	}


	@Override
	public void render () {
		super.render();
	}


	public ArrayList<Person> getPeople() {
		return people;
	}

}
