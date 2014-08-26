package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class mapUI {
	private Stage stage;
	private Person person;
	Texture personImage;
	TextureAtlas atlas;
	TextButtonStyle style;
	Skin skin;
	
	public void create() {
	    stage = new Stage(new ScreenViewport());
	    Gdx.input.setInputProcessor(stage);
	    atlas = new TextureAtlas("faceButtons.pack");
	    skin = new Skin(atlas);
	    style = new TextButtonStyle();
	    
	    
	    
	    
	    personImage = new Texture(Gdx.files.internal("person_test_image.jpg"));
	    //person = new Person("person1", "might be harry potter", 273, 192, personImage);
	    //person.setBounds(271, 0, personImage.getWidth(), personImage.getHeight());
	   
	}

	public void resize (int width, int height) {
	    // See below for what true means.
	    stage.getViewport().update(width, height, true);
	}

	public void render (float delta) {
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    stage.act(delta);
	    stage.draw();
	}

	public void dispose() {
	    stage.dispose();
	}
	
	
	
}
