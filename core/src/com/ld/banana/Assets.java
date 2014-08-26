package com.ld.banana;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Texture menuBackground;
	public static Texture menuBottle;
	public static Texture menuOverlay;
	public static Texture bottle;
	public static Texture play_button;

	// map
	public static Texture facePlaceholder;
	public static Texture map_stage_1;
	public static Texture map_stage_2;
	public static Texture map_stage_3;
	public static Texture map_stage_4;
	public static Texture map_stage_5;
	public static Texture map_stage_6;
	public static Texture map_stage_7;
	public static Texture map_stage_test;

	// map heads
	public static Texture asianHead;
	public static Texture oldmanHead;
	public static Texture nbastarHead;
	public static Texture leathermanHead;
	public static Texture professorHead;

	// map bodies
	public static Texture oldmanBody;
	public static Texture asianBody;
	public static Texture nbastarBody;
	public static Texture leathermanBody;
	public static Texture professorBody;
	public static Texture girlBody;
	public static Texture warVetBody;
	public static Texture rapperBody;

	// bio screen assetd
	public static Texture bio_send;
	public static Texture bio_bottle;
	public static Texture bio_back;

	public static Texture bio_bg;
	public static Texture bio_buttons_nomsg;
	public static Texture bio_buttons_msg;
	public static Texture bio_buttons_send;

	public static Texture bio_flag_norway;
	public static Texture bio_flag_england;
	public static Texture bio_flag_vietnam;
	public static Texture bio_flag_congo;
	public static Texture bio_flag_nk;
	public static Texture bio_flag_usa;
	public static Texture bio_flag_nz;
	
	public static Texture bio_letter_bg;

	// letters
	public static Texture letter_congo_vietnam;
	public static Texture letter_england_norway;
	public static Texture letter_norway_england;
	public static Texture letter_ny_nz;
	public static Texture letter_ny_nk;
	public static Texture letter_nk_ny;
	public static Texture letter_nz_ny;
	public static Texture letter_vietnam_cali;
	
	public static Animation gust;

	//audio
	public static Sound seagull;
	public static Sound button;
	public static Sound exitButton;
	public static Sound lose;
	public static Sound letter;
	public static Sound win;
	public static Sound wind;

	public static Music noise;
	public static Music drums;

	// Level 1
	public static Texture levelBackground; // background
	public static Texture l1_obstacle1;
	public static Texture l1_obstacle2;
	public static Texture l1_obstacle3;
	public static Texture l1_obstacle4;
	public static Texture l1_obstacle5;

	public static BitmapFont font_title;
	public static BitmapFont font_bio_title;
	public static BitmapFont font_paragraph;
	public static BitmapFont font_subheading;

	public static Texture loadTexture(String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		// menu
		menuBackground = loadTexture("menu/bg.png");
		menuBottle = loadTexture("menu/bottle.png");
		menuOverlay = loadTexture("menu/overlay.png");
		play_button = loadTexture("btn_play.png");

		// Map Assets
		facePlaceholder = loadTexture("map/faces/person_test_image.jpg");
		map_stage_1 = loadTexture("map/map_no_info.jpg");
		map_stage_2 = loadTexture("map/map_path_1.jpg");
		map_stage_3 = loadTexture("map/map_path_2.jpg");
		map_stage_4 = loadTexture("map/map_path_3.jpg");
		map_stage_5 = loadTexture("map/map_path_4.jpg");
		map_stage_6 = loadTexture("map/map_path_5.jpg");
		map_stage_7 = loadTexture("map/map_path_6.jpg");
		map_stage_test = loadTexture("map/map_all_info.jpg");

		// Heads
		asianHead = loadTexture("map/faces/asian.png");
		oldmanHead = loadTexture("map/faces/oldman.png");
		nbastarHead = loadTexture("map/faces/nbastar.png");
		leathermanHead = loadTexture("map/faces/leatherman.png");
		professorHead = loadTexture("map/faces/professor.png");
		// Bodies
		asianBody = loadTexture("map/bodies/asian.png");
		oldmanBody = loadTexture("map/bodies/oldman.png");
		nbastarBody = loadTexture("map/bodies/nbastar.png");
		leathermanBody = loadTexture("map/bodies/leatherman.png");
		professorBody = loadTexture("map/bodies/professor.png");
		girlBody = loadTexture("map/bodies/girl.png");
		warVetBody = loadTexture("map/bodies/warvet.png");
		rapperBody = loadTexture("map/bodies/rapper.png");

		//bottle
		bottle = loadTexture("level/bottle/bottle.png");

		// level 1 background
		levelBackground = loadTexture("level/level1/level1background.jpg");

		// level 1 obstacles
		l1_obstacle1 = loadTexture("level/level1/obstacles/buoy.png");
		l1_obstacle2 = loadTexture("level/level1/obstacles/fish_1.png");
		l1_obstacle3 = loadTexture("level/level1/obstacles/octipus.png");
		l1_obstacle4 = loadTexture("level/level1/obstacles/snorkler.png");
		l1_obstacle5 = loadTexture("level/level1/obstacles/log.png");
		
		// Bio Assets
		bio_send = loadTexture("bio/send.jpg");
		bio_bottle = loadTexture("bio/bottle.jpg");
		bio_back = loadTexture("bio/back.png");

		bio_bg = loadTexture("bio/bg.jpg");
		bio_buttons_nomsg = loadTexture("bio/btn_nomsg.png");
		bio_buttons_msg = loadTexture("bio/btn_msg.png");
		bio_buttons_send = loadTexture("bio/btn_send.png");

		bio_flag_norway = loadTexture("bio/flag/norway.jpg");
		bio_flag_england = loadTexture("bio/flag/england.jpg");
		bio_flag_nk = loadTexture("bio/flag/nk.jpg");
		bio_flag_nz = loadTexture("bio/flag/nz.jpg");
		bio_flag_congo = loadTexture("bio/flag/congo.jpg");
		bio_flag_vietnam = loadTexture("bio/flag/vietnam.jpg");
		bio_flag_usa = loadTexture("bio/flag/usa.jpg");
		
		//letters
		bio_letter_bg = loadTexture("bio/letter_bg.jpg");
		letter_congo_vietnam = loadTexture("bio/letter/to_congo_from_vietnam.png");
		letter_england_norway = loadTexture("bio/letter/to_england_from_norway.png");
		letter_norway_england = loadTexture("bio/letter/to_norway_from_england.png");
		letter_ny_nz = loadTexture("bio/letter/to_ny_from_nz.png");
		letter_ny_nk = loadTexture("bio/letter/to_ny_from_nk.png");
		letter_nk_ny = loadTexture("bio/letter/to_nk_from_ny.png");
		letter_nz_ny = loadTexture("bio/letter/to_nz_from_ny.png");
		letter_vietnam_cali = loadTexture("bio/letter/to_vietnam_from_cali.png");

		//audio
		seagull = Gdx.audio.newSound(Gdx.files.internal("sfx/gulls.mp3"));//<-----------
		button = Gdx.audio.newSound(Gdx.files.internal("sfx/button.wav"));//<-----------
		exitButton = Gdx.audio.newSound(Gdx.files.internal("sfx/exitbutton.wav"));//<-----------
		lose = Gdx.audio.newSound(Gdx.files.internal("sfx/lose.wav"));//<-----------
		letter = Gdx.audio.newSound(Gdx.files.internal("sfx/letter.mp3"));//<-----------
		win = Gdx.audio.newSound(Gdx.files.internal("sfx/win.wav"));//<-----------
		wind = Gdx.audio.newSound(Gdx.files.internal("sfx/windyuck.mp3"));//<-----------

		noise =  Gdx.audio.newMusic(Gdx.files.internal("sfx/ocean.mp3"));//<-----------
		drums =Gdx.audio.newMusic(Gdx.files.internal("sfx/inlevel.mp3")); //<-----------

		//fonts
		font_title = new BitmapFont(Gdx.files.internal("font/h_bold_85.fnt"), Gdx.files.internal("font/h_bold_85.png"), false);
		font_bio_title = new BitmapFont(Gdx.files.internal("font/h_bold_55.fnt"), Gdx.files.internal("font/h_bold_55.png"), false);
		font_paragraph = new BitmapFont(Gdx.files.internal("font/h_light_22.fnt"), Gdx.files.internal("font/h_light_22.png"), false);
		font_subheading = new BitmapFont(Gdx.files.internal("font/h_light_40.fnt"), Gdx.files.internal("font/h_light_40.png"), false);
	}

}
