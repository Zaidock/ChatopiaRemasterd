package com.kenno.Chatopia.tile.world;

import java.awt.Graphics;

import com.kenno.Chatopia.Handler;
import com.kenno.Chatopia.entity.EntityManager;
import com.kenno.Chatopia.entity.creatures.Player;
import com.kenno.Chatopia.entity.statics.Rock;
import com.kenno.Chatopia.entity.statics.Tree;
import com.kenno.Chatopia.items.ItemManager;
import com.kenno.Chatopia.tile.Tile;
import com.kenno.Chatopia.utils.Utils;

public class World {
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	private EntityManager entityManager;
	private ItemManager itemManager;
	public World(Handler handler, String path){
		this.handler = handler;
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		entityManager.addEntity(new Tree(handler, 100 ,150));
		entityManager.addEntity(new Rock(handler, 300 ,150));
		itemManager = new ItemManager(handler);
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setX(spawnY);
		
	}

	public void tick(){
		entityManager.tick();
		itemManager.tick();
	}
	
	public void render(Graphics g){
		int xStart = Math.max(0, (int) handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = Math.max(0, (int) handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd =(int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);;
		
		
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd;x++){
				getTile(x, y).render(g,(int) (x * Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		itemManager.render(g);
		entityManager.render(g);
	}
	
	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public Tile getTile(int x, int y){
		
		if(x < 0 || y < 0|| x >= width || y>= height)
			return Tile.grassTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
