package game_world;

import java.util.ArrayList;

import entity.*;

public class Room {
	public static final int Xsize = 0;
	public static final int Ysize = 0;
	private Tile[][] tiles;
	private ArrayList<Entity> entities;
	private Player player;
	public Room() {
		tiles= new Tile[Xsize][Ysize];
		entities = new ArrayList<Entity>();
	}
	public Tile GetTile(int i, int j) {
		return tiles[i][j];
	}
	public ArrayList<Entity> GetEntities(){
		return entities;
	}public void Render() {
		for(Entity entity: entities)entity.Render();
	}
}
