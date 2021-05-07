package entity;

public class RSkill extends QSkill{
	public void Move() {
		super.x += (int)facing.x * speed;
		super.y += (int)facing.y * speed;
	}
	public void DecreaseTime() {
		super.DecreaseTime();
		super.damage+=5;
		super.width+=1;
		super.height+=1;
	}
	public void OnLoop() {
		super.OnLoop();
		Move();
	}
	public void SetExistTime(int time) {
		super.SetExistTime(time);
	}
}
