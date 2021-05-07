package entity;

import game_world.Room;

public class Ghost extends Monster{
	private int invisibleTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(invisibleTime>0)
		invisibleTime--;
		else invisibleTime=60;
	}
	public void OnLoop() {
		DecreaseTime();
		super.CollisionPlayer();
		super.Move();
		
		if(invisibleTime>30) {
			super.curFrame=0;
			super.CollisionR();
			super.CollisionR();
			for(int i=0;i<Room.Xsize;i++) {
				for(int j=0;j<Room.Ysize;j++) {
					super.CollisionWall(room.GetTile(i, j));
				}
			}
			
		}else {
			super.curFrame=1;
		}
	}
}
