package entity;

import java.awt.Rectangle;

import game_world.Room;

public class Bullet extends Entity{
	private Player player;
	private Room room;
	private int damage;
	private int existTime;
	public void Move() {
		super.x += (int)facing.x * speed;
		super.y += (int)facing.y * speed;
	}
	public void DecreaseTime() {
		super.DecreaseTime();
		if(existTime>0)existTime--;
		else room.GetEntities().remove(this);
	}
	public void CollisionPlayer() {
		Rectangle r= this.intersection(player);
		if(r.isEmpty())return;
		player.TakeHP(-damage);
		room.GetEntities().remove(this);
	}
	
	public void OnLoop() {
		Move();
		DecreaseTime();
		CollisionPlayer();
	}
	public void Render() {
		super.Render();
	}
}
