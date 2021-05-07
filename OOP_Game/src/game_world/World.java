package game_world;

import entity.Player;

public class World {
	public static final int count = 5;
	private Room[] rooms;
	private Player player;
	private int curRoom;
	public void ChangeRoom() {
		
	}
	public Room GetCurrentRoom() {
		return rooms[curRoom];
	}public Room[] GetRooms() {
		return rooms;
	}
}
