package com.kenno.Chatopia.states;

import java.awt.Graphics;

import com.kenno.Chatopia.Handler;
import com.kenno.Chatopia.tile.world.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.wrd");
		handler.setWorld(world);
		init();
	}
	
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}


	public void init() {
		
	}

}