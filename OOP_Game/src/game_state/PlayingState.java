package game_state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import entity.Player;
import game_world.*;
import resources.Resources;

public class PlayingState extends GameState{
	private World world;
	private Player player;
	private int timeToGameOver = 50;
	public PlayingState(GameStateManager gameStateManager) {
		super(gameStateManager);
		player = new Player(7, 7, 2, 2, Resources.PLAYER, 1);
		world = new World(player);
	}
	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		world.ChangeRoom();
		if(world.GetCur()==World.count) {
		GameOverMenu.result=true;
			gameStateManager.setCurState(3);
		}else {
		if(player.getHp()>0) {
		Room room = world.GetCurrentRoom();
		
		room.Loop();
		player.OnLoop();
		}
		else {
			timeToGameOver--;
			if(timeToGameOver==0) {
				GameOverMenu.result=false;
				gameStateManager.setCurState(3);
			}
		}
		}
	}

	@Override
	public void Render(Graphics g) {
		// TODO Auto-generated method stub
		world.GetCurrentRoom().Render(g);
		player.Render(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 15));
		g.drawString("HP : "+ this.player.getHp(), Tile.size * 2/3 + 5, 20);
		g.drawString("MP : "+ this.player.getMp(), Tile.size * 2/3 + 85, 20);
		g.drawString("Def : "+ this.player.getDef(), Tile.size * 2/3 + 165, 20);
		g.drawString("R : "+ this.player.getRTime(), Tile.size * 2/3 + 245, 20);
	}

	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		switch(keyCode) {
		
		case KeyEvent.VK_DOWN:
			player.SetMove(true);
			player.SetFacing(Vector.Down);
			break;
		case KeyEvent.VK_LEFT:
			player.SetMove(true);
			player.SetFacing(Vector.Left);
			break;
		case KeyEvent.VK_RIGHT: 
			player.SetMove(true);
			player.SetFacing(Vector.Right);
			break;
		case KeyEvent.VK_UP:
			player.SetMove(true);
			player.SetFacing(Vector.Up);
			
			break;
		case KeyEvent.VK_Q: 
			player.AttackQ();
			break;
		case KeyEvent.VK_R:
			player.AttackR();
			break;
		case KeyEvent.VK_P:
			gameStateManager.setCurState(2);
			break;
		}
	}

	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		switch(keyCode) {
		case KeyEvent.VK_UP:
			player.SetMove(false);
			break;
		case KeyEvent.VK_DOWN:
			player.SetMove(false);
			break;
		case KeyEvent.VK_LEFT:
			player.SetMove(false);
			break;
		case KeyEvent.VK_RIGHT:
			player.SetMove(false);
			break;
		}
	}

}
