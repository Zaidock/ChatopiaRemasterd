package com.kenno.Chatopia.entity.statics;

import java.awt.Color;
import java.awt.Graphics;

import com.kenno.Chatopia.Handler;
import com.kenno.Chatopia.gfx.Assets;
import com.kenno.Chatopia.items.Item;
import com.kenno.Chatopia.tile.Tile;

public class Rock extends StaticEntity{
	
	public Rock(Handler handler, int x, int y) {
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 12;
		bounds.y = 31;
		bounds.width = 42;
		bounds.height = 1;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.rock, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		g.setColor(Color.red);
		/*g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
				(int) (y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width, bounds.height);*/
	}

	@Override
	protected void die() {
		handler.getWorld().getItemManager().addItem(Item.rockItem.createNew((int)x, (int) y));
		
	}
}
