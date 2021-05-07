package entity;

import java.awt.Rectangle;

import game_world.Room;
import game_world.Vector;

public class Obstacle extends Monster{
	private Vector tag1;
	private Vector tag2;
	private boolean cur;

	public void Move() {
		Vector curTag;
		if(cur)curTag = tag1;
		else curTag=tag2;
		super.facing.x= curTag.x - this.x;
		super.facing.y= curTag.y - this.y;
		if(facing.Length()<0.5) {
			cur=!cur;
		}
		facing = facing.Nomalize();
		this.x+=facing.x*speed;
		this.y+=facing.y*speed;
	}
	
	public void OnLoop() {
		Move();
		CollisionPlayer();
	}
	public void CollisionPlayer() {
		Rectangle r = this.intersection(player);
		if(r.isEmpty())return;
		player.TakeHP(-damage);
		room.GetEntities().remove(this);
	}
}
