package entity;

public class AD extends Monster{
	private boolean bullet;
	public void OnLoop() {
		super.CollisionQ();
		super.CollisionR();
	}
	public void DecreaseTime() {
		if(super.AttackTime>0)
		super.AttackTime--;
		else Attack();
	}
	protected void Attack() {
		if(bullet) {
			
		}else {
			
		}
		// add new Bullet/Missile
	}
}
