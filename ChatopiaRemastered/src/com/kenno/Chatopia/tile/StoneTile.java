package com.kenno.Chatopia.tile;

import com.kenno.Chatopia.gfx.Assets;

public class StoneTile extends Tile{

	public StoneTile(int id) {
		super(Assets.stone, id);
		
	}
	@Override
	public boolean isSolid() {
		return true;
	}

}
