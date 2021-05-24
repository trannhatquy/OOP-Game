package game_state;


import main.WindowManager;
import resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MainMenu extends GameState{
	
	protected String[] optionsMenu = {};
	protected String[] levelMenu = {};
	private static final String START_GAME ="Start";
	private static final String QUIT_GAME = "Quit";
	private static final String LEVEL_GAME = "Level: ";
    private static final String EASY_GAME = "Easy";
    private static final String HARD_GAME = "Hard";
    private static final String VERY_HARD_GAME = "Very Hard";
    private static final String LABEL = "OOP GAME";
 	protected int selected;
 	private static int level;
 	
 	public MainMenu(GameStateManager gameStateManager) {
		super(gameStateManager);
		this.optionsMenu= new String[]{START_GAME, LEVEL_GAME, QUIT_GAME};
		this.levelMenu = new String[]{ EASY_GAME, HARD_GAME, VERY_HARD_GAME};
		this.selected = 0;
		level = 0;
	}
	public static int getLevel() {
		return level;
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
		graphics.drawString(LABEL, WindowManager.WIDTH/2 - 120, WindowManager.HEIGHT/5);
		graphics.setFont(new Font("Arial", Font.PLAIN, 30));
		for(int i=0; i<this.optionsMenu.length; i++){
			if(i==this.selected) graphics.setColor(Color.BLACK);
			else graphics.setColor(Color.WHITE);
			graphics.drawString(this.optionsMenu[i], 30, 200 + i * 50);
			if(i==1){
				 graphics.drawString(this.levelMenu[level], 150, 200 + i * 50);
				
			}
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
					case START_GAME:
						gameStateManager.setGameStates(1, new PlayingState(gameStateManager));
						gameStateManager.setCurState(1);
						break;
					case QUIT_GAME:
						System.exit(0);
						break;
					case LEVEL_GAME:
						level++;
						if(level == 3)level = 0;
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
