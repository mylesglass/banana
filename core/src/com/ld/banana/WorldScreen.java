package com.ld.banana;

import java.util.ArrayList;
import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class WorldScreen extends ScreenAdapter {
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Stage stage;
	//button
	private TextureAtlas atlas;
	private TextButtonStyle style;
	private Skin skin;

	private Button button;
	private int buttonSize = 30;
	private Person worker;

	public Texture mapImage;

	ArrayList<Person> people;
	private  BiosScreen bio;
	private HashMap<Button,Person> map;


	//game
	private BananaGame game;

	private Texture personImage;



	public WorldScreen(BananaGame game) {
		this.game = game;

		Assets.noise.setLooping(true);//<-----------
		Assets.noise.setVolume(Assets.noise.getVolume()/2);//<-----------
		Assets.noise.play();//<-----------

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		map = new HashMap<Button,Person>();


		atlas = new TextureAtlas("faceButtons.pack");
		skin = new Skin(atlas);

		// People creation
		people = game.getPeople();
		mapImage = Assets.map_stage_1;
		personImage = Assets.asianHead;
		//button stuff.
		stage = new Stage();


		Gdx.input.setInputProcessor(stage);

		makeButtons();

		stage.addActor(button);

		batch = new SpriteBatch();



	}

	private void makeButtons() {

		for(Person p : people){
			worker = p;
			style = new TextButtonStyle();
			style.up = skin.getDrawable(p.getName());
			style.down = skin.getDrawable(p.getName());
			button = new Button(style);
			button.setBounds(p.getMapX()-buttonSize/2,600-p.getMapY()-buttonSize/2,30,30);
			System.out.println("worldscreen "+p.getName());
			map.put(button,p);
			button.addListener(new ClickListener(){
				@Override	
				public void clicked(InputEvent event, float x, float y){		
    
					Assets.button.play();
					
					System.out.println(x+" :x & y: "+y);

					Person closest = people.get(0);
					float distance = Float.MAX_VALUE;

					for(Person p  : people){
						
						float xDiff = Math.abs(p.getMapX() - Gdx.input.getX());
						
						System.out.println("input x: " + Gdx.input.getX() + " players X: "  + p.getMapX());
						
						float yDiff = Math.abs(p.getMapY() - Gdx.input.getY());
						
						System.out.println("input Y: " + Gdx.input.getY() + " players Y: "  + p.getMapY());
						
						
						float dist = xDiff + yDiff;

						System.out.println(p.getName()+": "+dist +":  distance from button");

						if(dist<distance){

							closest = p;
							distance = dist;

						}

					}
					game.current = closest;
					System.out.println("closest person to button: "+game.current.getName());

					bio = new BiosScreen(game);
					game.bios = bio;
					game.setScreen(new BiosScreen(game));


				}	
			});

			stage.addActor(button);



		}

	}

	public void update(){
		if(game.delivered == 1){
			Message vetMessage = new Message(game.warvet, game.asian, "Thank you for saving me!" , 1000, Assets.letter_vietnam_cali);//<-----------
			game.warvet.setMessage(true, vetMessage);
         }
		if(game.delivered == 2){
			Message rapperMessage = new Message(game.professor, game.rapper, "I need help creating hip-hop" , 1200, Assets.letter_ny_nz);//<-----------
			game.professor.setMessage(true, rapperMessage);
         }
		if(game.delivered == 3){
			Message girlMessage = new Message(game.girl, game.warvet, "capitalist!" , 900, Assets.letter_ny_nk);//<-----------
			game.girl.setMessage(true, girlMessage);
         }
		if(game.delivered == 4){
			Message asianMessage = new Message(game.asian, game.NBAstar, "Don't forget your baby!" , 800, Assets.letter_congo_vietnam);//<-----------
			game.asian.setMessage(true, asianMessage);
         }
		if(game.delivered == 5){
			Message rapperMessage = new Message(game.rapper, game.girl, "Americas the shit yo!" , 1400, Assets.letter_nk_ny);//<-----------
			game.rapper.setMessage(true, rapperMessage);
         }
		if(game.delivered == 6){
			WinScreen winScreen = new WinScreen();
			game.setScreen(winScreen);
			
		}
	}

	public void draw(){
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		stage.act();


		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();
		game.batch.draw(game.mapImage, 0, 0);
		game.batch.end();
		stage.draw();

	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}

	private void drawMap() {
		batch.draw(mapImage, 0, 0);
		for(Person p : people) {
			batch.draw(personImage, p.getMapX()-15, 600 - p.getMapY()-15);
		}
	}

	public Person getPerson(){
		return worker;
	}
}
