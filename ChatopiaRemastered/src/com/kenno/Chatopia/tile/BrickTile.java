package com.kenno.Chatopia.tile;

import com.kenno.Chatopia.gfx.Assets;

public class BrickTile extends Tile{

	public BrickTile(int id) {
		super(Assets.brick, id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isSolid() {
		return true;
	}

}
