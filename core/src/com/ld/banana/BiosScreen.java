package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.sun.javafx.geom.Rectangle;

public class BiosScreen extends ScreenAdapter{

	//set-up
	private OrthographicCamera camera;
	private Stage stage;
	private TextureAtlas atlas;
	private TextButtonStyle style;
	private Skin skin;
	private BananaGame game;

	//images
	private Texture character;
	private Texture back;
	private Texture letter;
	private Texture bottle;
	private Texture send;


	//buttons resources.
	private int exitX = 450;
	private int exitY = 105;
	private int sendX = 525;
	private int sendY = 105;
	private int readX = 600;
	private int readY = 105;
	private int bottleX = 50;
	private int bottleY = 50;
	private Boolean bottleExists = false;
	private Boolean sendingExists = false;

	private Rectangle back_btn;
	private Rectangle send_btn;
	private Rectangle read_btn;

	public BiosScreen(BananaGame game){
		this.game = game;

		send = Assets.bio_send;
		bottle = Assets.bio_bottle;
		back = Assets.bio_back;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);

		//set buttons
		back_btn = new Rectangle(400, 100, 75, 75);
	}

	public void update(){
	}

	public void draw(){
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 1, 1, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batch.setProjectionMatrix(camera.combined);
		game.batch.begin();

		// draw background
		game.batch.disableBlending();
		game.batch.draw(Assets.bio_bg, 0 , 0, 800, 600);
		game.batch.draw(game.current.getFlag(), 448, 464);

		//draw char
		game.batch.enableBlending();
		game.batch.draw(game.current.getTexture(), 90, 100);

		//draw words
		Assets.font_bio_title.setColor(Color.BLACK);
		Assets.font_bio_title.draw(game.batch, game.current.getName(), 110, 507);

		Assets.font_paragraph.setColor(Color.BLACK);
		Assets.font_paragraph.drawMultiLine(game.batch, game.current.getBio(), 444, 449);

		// draw buttons

		if(game.current.getMessage()) {
			game.batch.draw(Assets.bio_buttons_msg, 445, 105);
			bottleExists = true;
		} else if(game.sending) {
			game.batch.draw(Assets.bio_buttons_send, 445, 105);
			sendingExists = true;
		} else {
			game.batch.draw(Assets.bio_buttons_nomsg, 445, 105);
		}



		//game.batch.draw(letter, 400, 50);
		//game.batch.draw(back,exitX ,exitY);
		//if(game.current.getMessage()){game.batch.draw( bottle , bottleX , bottleY ); bottleExists = true;}
		//if(game.sending){
		//	game.batch.draw( send , bottleX , bottleY );
		//	sendingExists = true; 
		//}
		game.batch.end();
	}

	@Override
	public void render(float delta){
		update();
		draw();


		//dealing with touch.
		if(Gdx.input.isTouched()) {
			int x = Gdx.input.getX();
			int y = Gdx.input.getY();

			//exit button
			if(exitX < x  && x < exitX + 75   && 600 - exitY > y && y > 600-( exitY + 75 ) ){
				Assets.exitButton.play();
				
				game.setScreen(game.worldScreen);

			}

			//bottle
			if(bottleExists){
				if(x > readX && x < readX + 75 && 600 - readY > y && 600 - (readY + 75) < y){
					Assets.letter.play();
					game.sender = game.current;
					game.doing = game.current.message;
					bottleExists = false;
					game.sending = true;
					game.setScreen(new LetterScreen(game));

				}
			}

			//send
			if(sendingExists){
				if(x > sendX && x < sendX + 75 && 600 - sendY > y && 600 - (readY + 75) < y){
					Assets.letter.play();

					game.level1.goal = game.doing.distance;
					game.gameScreen.loadLevel(game.level1);
					game.setScreen(game.gameScreen);

					Assets.seagull.pause();
					Assets.drums.setLooping(true);
					Assets.drums.play();
				}
			}
		}
	}
}
