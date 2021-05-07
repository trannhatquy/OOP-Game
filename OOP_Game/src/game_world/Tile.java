package game_world;

import java.awt.Rectangle;

public class Tile extends Rectangle{
	private byte id;
	public static final int size = 5;
	private byte prop;
	// 0: None
	// 1: Wall
	// 2: Water
	public Tile(byte id,int x,int y, byte prop) {
		
	}
	public byte GetProperty() {
		return prop;
	}
}
