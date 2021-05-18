package game_state;

import java.awt.*;
import java.awt.event.KeyEvent;

import main.WindowManager;
import resources.Resources;

public class GameOverMenu extends MainMenu{
	public static boolean result ;
	protected String[] gameoverMenu = {};
	private static final String WIN = "You win";
	private static final String LOSE = "You lose";
	private static final String RESTART = "Restart";
	private static final String MAINMENU = "Main menu";
	protected int selected;
	public GameOverMenu(GameStateManager gameStateManager){
		super(gameStateManager);
		this.gameoverMenu = new String[]{WIN, LOSE};
		this.optionsMenu = new String[]{RESTART, MAINMENU};
		this.selected= 0;
	}

	

	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Render(Graphics graphics) {
		// TODO Auto-generated method stub
		graphics.drawImage(Resources.TEXTURES.get(Resources.BACKGROUND),0, 0, WindowManager.WIDTH, WindowManager.HEIGHT, null);
		graphics.setFont(new Font("Arial", Font.ITALIC, 50));
		
		for(int i=0;i<this.optionsMenu.length;i++) {
			if(i==this.selected) graphics.setColor(Color.BLACK);
			else graphics.setColor(Color.WHITE);
			graphics.drawString(this.optionsMenu[i], 30, 200 + i * 50);
		}
		if(result) graphics.drawString(this.gameoverMenu[0], WindowManager.WIDTH/2 - 120, WindowManager.HEIGHT/5);
		else graphics.drawString(this.gameoverMenu[1], WindowManager.WIDTH/2 - 120, WindowManager.HEIGHT/5);
	}

	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch (keyCode){
			case KeyEvent.VK_UP:
				if(this.selected > 0) this.selected --;
				break;
			case KeyEvent.VK_DOWN:
				if(this.selected < this.optionsMenu.length - 1) this.selected ++;
				break;
			case KeyEvent.VK_ENTER:
				switch (this.optionsMenu[selected]){
					case RESTART:
						gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
						gameStateManager.setCurState(1);
						break;
					case MAINMENU:
						gameStateManager.setCurState(0);
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
