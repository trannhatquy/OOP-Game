package game_state;

public class GameStateManager {
	private GameState[] gameStates;
	private int curState;
	public void Loop() {
		gameStates[curState].Loop();
	}
	public void Render() {
		gameStates[curState].Render();
	}public void KeyPressed(int keyCode) {
		gameStates[curState].KeyPressed(keyCode);
	}public void KeyReleased(int keyCode) {
		gameStates[curState].KeyReleased(keyCode);
	}
}
