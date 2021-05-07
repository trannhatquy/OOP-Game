package entity;

import java.awt.Rectangle;

import game_world.Room;

public class Monster extends Entity{
	protected int hp;
	private boolean freeze;
	protected int damage;
	protected Room room;
	protected Player player;
	protected int AttackTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(AttackTime>0) {
			AttackTime--;
		}
	}
	protected void Attack() {
		if(AttackTime==0) {
			
			player.TakeHP(-damage);
		}
	}
	public void CollisionPlayer() {
		Rectangle r= this.intersection(player);
		if(r.isEmpty()) {
			super.curFrame=0;
			return;
		}
		super.curFrame=1;
		Attack();
		if(freeze) {
			player.SetFreezeTime(10);
			room.GetEntities().remove(this);
		}
	}public void CollisionQ() {
		Rectangle r= this.intersection(player.GetQPos());
		if(r.isEmpty())return;
		
		TakeDamage(-player.GetQPos().GetDamage());
		
	}
	public void CollisionR() {
		Rectangle r= this.intersection(player.GetRPos());
		if(r.isEmpty())return;
		
		TakeDamage(-player.GetRPos().GetDamage());
	}
	protected void TakeDamage(int amount) {
		hp-=amount;
		if(hp<=0)room.GetEntities().remove(this);
	}
	public void OnLoop() {	
		Move();
		for(int i=0;i<Room.Xsize;i++) {
			for(int j=0;j<Room.Ysize;j++) {
				super.CollisionWall(room.GetTile(i, j));
			}
		}
		CollisionPlayer();
		CollisionQ();
		CollisionR();
	}public void Render() {
		
	}
	public void Move() {
		
	}
}
