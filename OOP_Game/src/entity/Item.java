package entity;

import java.awt.Rectangle;
import java.util.Random;

import game_world.Room;

public class Item extends Entity{
	private Room room;
	private Player player;
	public void CollisionPlayer() {
		Rectangle r = this.intersection(player);
		if(r.isEmpty())return;
		Random ran= new Random();
		int i = ran.nextInt(3);
		switch(i) {
		case 0: player.TakeHP(5);
		case 1: player.TakeMP(5);
		case 2: player.TakeDef(5);
		}
		room.GetEntities().remove(this);
	}
	public void OnLoop() {
		CollisionPlayer();
	}
}
