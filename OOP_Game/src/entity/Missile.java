package entity;

public class Missile extends Bullet{
	public void Move() {
		
	}
	public void OnLoop() {
		Move();
		super.DecreaseTime();
		super.CollisionPlayer();
	}public void Render() {
		super.Render();
	}
}
