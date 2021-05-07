package game_state;

public abstract class GameState {
	protected GameStateManager gameStateManager;
	
	public abstract void Loop();
	public abstract void Render();
	public abstract void KeyPressed(int keyCode);
	public abstract void KeyReleased(int keyCode);
}
