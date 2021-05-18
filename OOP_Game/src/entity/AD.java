package entity;

import java.awt.Graphics;
import java.util.Random;

import game_world.Room;
import game_world.Vector;
import resources.Resources;

public class AD extends Monster{
	
	private static final long serialVersionUID = 1L;

	public AD(int x, int y,Vector facing, int delayTime, int frameCount, byte imgID, float speed, Room room, int hp, boolean freeze, int damage, int attackTime) {
		super(x,y,facing, delayTime, frameCount, imgID, (byte)0, speed, room, hp, freeze, damage, attackTime);
		// TODO Auto-generated constructor stub
		b= new Bullet(this.x, this.y, this.facing, 20, 1, Resources.BULLET, 5, room, 2);
		m = new Missile(this.x, this.y, this.facing, 20, 1, Resources.MISSILE, 5,  room, 2);
		b.SetAlive(false);
		m.SetAlive(false);
	}
	
	
	private Bullet b;
	private Missile m;
	public void OnLoop() {
		AnimationDisplay();
		super.CollisionQ();
		super.CollisionR();
		DecreaseTime();
		if(b.GetAlive())b.OnLoop();
		if(m.GetAlive())m.OnLoop();
	}
	
	public void DecreaseTime() {
		if(super.curATime>0)
		super.curATime--;
		else {
			Attack();
			curATime=AttackTime;
		}
	}
	
	protected void Attack() {
		Random r = new Random();
		int ran = r.nextInt(2);
		if(ran==0) {
			Vector v = new Vector(player.x-this.x, player.y-this.y);
			v= v.Nomalize();
			b.SetFacing(v);
			b.x = this.x;
			b.y = this.y;
			b.SetAlive(true);
			b.SetExistTime(100);
		}else {
			m.x=this.x;
			m.y=this.y;
			m.SetAlive(true);
			m.SetExistTime(100);
		}
	}
	public void Render(Graphics g) {
		super.Render(g);
		if(b.GetAlive())b.Render(g);
		if(m.GetAlive())m.Render(g);
	}
}
