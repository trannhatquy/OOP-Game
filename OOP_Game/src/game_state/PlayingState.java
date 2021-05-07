package game_state;

import entity.Entity;
import entity.Player;
import game_world.*;

public class PlayingState extends GameState{
	private World world;
	private Player player;
	@Override
	public void Loop() {
		// TODO Auto-generated method stub
		Room room = world.GetCurrentRoom();
		for(Entity entity : room.GetEntities()) {
			entity.OnLoop();
		}
		player.OnLoop();
	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub
		world.GetCurrentRoom().Render();
		player.Render();
	}

	@Override
	public void KeyPressed(int keyCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void KeyReleased(int keyCode) {
		// TODO Auto-generated method stub
		
	}

}
