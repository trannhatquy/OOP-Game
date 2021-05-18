package game_state;



import main.WindowManager;
import resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PauseMenu extends MainMenu{

	private static final String CONTINUE_GAME = "Continue";
	private static final String QUIT_GAME = "Quit";
	private static final String LABEL = "PAUSE";
	protected int selected;
	public PauseMenu(GameStateManager gameStateManager){
		super(gameStateManager);
		super.optionsMenu = new String[]{ CONTINUE_GAME, QUIT_GAME};
		this.selected=0;
	}
	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Render(Graphics graphics) {
		graphics.drawImage(Resources.TEXTURES.get(Resources.BACKGROUND),0, 0, WindowManager.WIDTH, WindowManager.HEIGHT, null);
		graphics.setFont(new Font("Arial", Font.ITALIC, 50));
		graphics.drawString(LABEL, WindowManager.WIDTH/2 - 120, WindowManager.HEIGHT/5);
		for (int i = 0; i < this.optionsMenu.length; i++) {
			if(i==this.selected) graphics.setColor(Color.BLACK);
			else graphics.setColor(Color.WHITE);
			graphics.drawString(this.optionsMenu[i], 30, 200 + i * 50);
		}
	}
	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch (keyCode) {
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case CONTINUE_GAME:
						gameStateManager.setCurState(1);
						System.out.print("Continue\n");
						break;
					case QUIT_GAME:
						gameStateManager.setCurState(0);
						System.out.print("BackToMenu");
						break;
				}
				break;
		}
	}

	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}
}
