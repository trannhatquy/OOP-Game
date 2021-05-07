package entity;

public class QSkill extends Entity{
	protected int damage;
	private int ExistTime;
	public void DecreaseTime() {
		super.DecreaseTime();
		if(ExistTime>0)ExistTime--;
	}
	public void OnLoop() {
		if(ExistTime==0)return;
		super.Render();
	}
	public int GetDamage() {
		return damage;
	}public void SetExistTime(int time) {
		ExistTime=time;
	}
}
