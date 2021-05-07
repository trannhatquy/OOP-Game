package entity;

import java.awt.Rectangle;

import game_world.Room;
import game_world.Tile;

public class Player extends Entity{
	private int hp;
	private int mp;
	private int def;
	private int QTime;
	private int RTime;
	private QSkill q;
	private RSkill r;
	private int freezeTime;

	private Room room;
	public void Move() {
		super.x += (int)facing.x * speed;
		super.y += (int)facing.y * speed;
	}
	@Override
	public void DecreaseTime() {
		super.DecreaseTime();
		if(QTime>0)QTime--;
		if(RTime>0)RTime--;
		if(freezeTime>0)freezeTime--;
	}
	public void AttackQ() {
		if(QTime==0) QTime=50;
		//MakeQ
		q.SetExistTime(10);
	}public void AttackR() {
		if(mp > 0) {
		if(RTime==0) {
			RTime=1000;
			mp--;
		}
		}
		//MakeR
		r.SetExistTime(10);
	}
	public QSkill GetQPos() {
		return q;
	}public RSkill GetRPos() {
		return r;
	}
	
	public void TakeHP(int amount) {
		this.hp+=amount;
		if(hp < 0) {
			hp = 0;
		}
	}public void TakeMP(int amount) {
		this.mp+=amount;
		if(mp<0) {
			mp=0;
		}
	}public void TakeDef(int amount) {
		this.def+=amount;
		if(def<0) {
			def=0;
		}
	}
	public void OnLoop() {
		if(freezeTime==0) {
			Move();
			super.curFrame=0;
		}else super.curFrame=1;
		DecreaseTime();
		for(int i=0;i<Room.Xsize;i++) {
			for(int j=0;j<Room.Ysize;j++) {
				super.CollisionWall(room.GetTile(i, j));
				super.CollisionWater(room.GetTile(i, j));
			}
		}
		q.OnLoop();
		r.OnLoop();
	}
	public void Render() {
		
	}
	public void SetRoom(Room room) {
		this.room=room;
	}
	public Room GetRoom() {
		return room;
	}public void SetFreezeTime(int time) {
		freezeTime=time;
	}
}
