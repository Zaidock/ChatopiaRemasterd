package com.kenno.Chatopia.states;

import java.awt.Graphics;

import com.kenno.Chatopia.Handler;
import com.kenno.Chatopia.gfx.Assets;
import com.kenno.Chatopia.ui.ClickListener;
import com.kenno.Chatopia.ui.UIImageButton;
import com.kenno.Chatopia.ui.UIManager;

public class MenuState extends State {

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(400, 400, 128, 64, Assets.btn_start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}
		}));
	}

	@Override
	public void tick() {
		uiManager.tick();
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
	}

}