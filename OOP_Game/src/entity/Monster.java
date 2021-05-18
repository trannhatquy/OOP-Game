package entity;


import java.awt.Rectangle;

import java.awt.Graphics;
import game_world.Room;
import game_world.Vector;
import resources.Resources;

public class Monster extends Enemy{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Monster(int x,int y,Vector facing, int delayTime, int frameCount, byte imgID,  byte attackID, float speed, Room room, int hp, boolean freeze, int damage, int attackTime) {
		super(x,y,facing, delayTime, frameCount, imgID, speed, room);
		// TODO Auto-generated constructor stub
		this.hp=hp;
		this.freeze=freeze;
		this.damage = damage;
		this.AttackTime=attackTime;
		this.attackID=attackID;
		this.moveID=imgID;
		curATime=attackTime;
	}
	protected byte moveID;
	protected byte attackID;
	protected int hp;
	private boolean freeze;
	protected int damage;
	protected int AttackTime;
	protected int curATime; 
	public void DecreaseTime() {
		super.DecreaseTime();
		if(curATime>0) {
			curATime--;
		}
		
	}
	protected void Attack() {
		
		
		if(curATime==0) {
			player.TakeHP(-damage);
			curATime=AttackTime;
		}
	}
	public void CollisionPlayer() {
		Rectangle r= this.intersection(player);
		if(r.isEmpty() || r.width * r.height < 20 ) {
			imgID = moveID;
			super.frameCount=2;
			return;
		}
		super.imgID = attackID;
		super.frameCount=1;
		Attack();
		if(freeze) {
			player.SetFreezeTime(100);
			SetAlive(false);
		}
	}public void CollisionQ() {
		Rectangle r= this.intersection(player.GetQPos());
		if(r.isEmpty())return;
		this.x+=player.GetQPos().GetFacing().x * 90;
		this.y+=player.GetQPos().GetFacing().y * 90;
		TakeDamage(-player.GetQPos().GetDamage());
		
		
	}
	public void CollisionR() {
		Rectangle r= this.intersection(player.GetRPos());
		if(r.isEmpty())return;
		
		TakeDamage(-player.GetRPos().GetDamage());
	}
	protected void TakeDamage(int amount) {
		hp+=amount;
		if(hp<=0)SetAlive(false);
	}
	public void OnLoop() {
		AnimationDisplay();
		DecreaseTime();
		Move();
		for(int i=0;i<Room.Ysize;i++) {
			for(int j=0;j<Room.Xsize;j++) {
				super.CollisionWall(room.GetTile(i, j));
			}
		}
		CollisionPlayer();
		CollisionQ();
		CollisionR();
		
	}
	public void Move() {
		float angCoeff = ((float) this.player.y - (float) super.y) / ((float) this.player.x - (float) super.x);
		if(angCoeff < 1 && angCoeff > -1) {
			if(this.player.x < super.x) {
				facing=Vector.Left;
			} else {
				facing= Vector.Right;
			}
		}
		else if(angCoeff > 1 || angCoeff < -1) {
			if(this.player.y < super.y) {
				facing =Vector.Up;
			} else {
				facing = Vector.Down;
			}
		}
		else {
			if(this.player.x < super.x) {
				facing = Vector.Left;
			} else {
				facing = Vector.Right;
			}
		}
		super.x = (int)(super.x + facing.x * speed);
		super.y = (int)(super.y + facing.y * speed);
	}
	public void Render(Graphics g) {
		if(facing.x<0)
		g.drawImage(Resources.TEXTURES.get(imgID + curFrame), x + width, y, -width, height, null);
		else g.drawImage(Resources.TEXTURES.get(imgID + curFrame), x, y, width, height, null);
	}
}
