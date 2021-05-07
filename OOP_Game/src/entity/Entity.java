package entity;

import java.awt.Rectangle;

import game_world.Tile;
import game_world.Vector;

public class Entity extends Rectangle{
	protected Vector facing;
	protected int curFrame;
	protected int delayTime;
	protected int frameCount;
	protected byte imgID;
	protected float speed;
	public void OnLoop() {
		
	}
	public void Render() {
		
	}
	public void SetFacing(float x, float y) {
		facing.x+=x;
		facing.y+=y;
	}
	public void DecreaseTime() {
		if(delayTime > 0)delayTime--;
		else delayTime = 30;
	}public void CollisionWall(Tile tile) {
		Rectangle rectangle = this.intersection(tile);
		if(rectangle.isEmpty() || tile.GetProperty() != 1) return;
		
	}public void CollisionWater(Tile tile) {
		Rectangle rectangle = this.intersection(tile);
		if(rectangle.isEmpty() || tile.GetProperty() != 2) return;
	}
}
