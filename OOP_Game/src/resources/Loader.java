package resources;

import java.io.File;


import javax.imageio.ImageIO;

public class Loader {
	public static void load(){
        try {  
        		System.out.print("Load Start\n");
        		Resources.TEXTURES.add(Resources.TILE, ImageIO.read(new File("image/title.png")));
        		Resources.TEXTURES.add(Resources.WALL, ImageIO.read(new File("image/wall.png")));
        		Resources.TEXTURES.add(Resources.WATER, ImageIO.read(new File("image/water.png")));
        		Resources.TEXTURES.add(Resources.DIRT, ImageIO.read(new File("image/dirt.png")));
                Resources.TEXTURES.add(Resources.TREE, ImageIO.read(new File("image/tree.png")));
                Resources.TEXTURES.add(Resources.STONE, ImageIO.read(new File("image/stone.png")));
                Resources.TEXTURES.add(Resources.GRASS, ImageIO.read(new File("image/grass.png")));              
                Resources.TEXTURES.add(Resources.PLAYER, ImageIO.read(new File("image/player.png")));
                Resources.TEXTURES.add(Resources.PLAYER_2, ImageIO.read(new File("image/player_2.png")));
                Resources.TEXTURES.add(Resources.PLAYER_BACK, ImageIO.read(new File("image/player_back.png")));
                Resources.TEXTURES.add(Resources.PLAYER_BACK_2, ImageIO.read(new File("image/player_back_2.png")));
                Resources.TEXTURES.add(Resources.PLAYER_LEFT, ImageIO.read(new File("image/player_left.png")));
                Resources.TEXTURES.add(Resources.PLAYER_LEFT_2, ImageIO.read(new File("image/player_left_2.png")));
                Resources.TEXTURES.add(Resources.PLAYER_RIGHT, ImageIO.read(new File("image/player_right.png")));
                Resources.TEXTURES.add(Resources.PLAYER_RIGHT_2, ImageIO.read(new File("image/player_right_2.png")));
                Resources.TEXTURES.add(Resources.AD, ImageIO.read(new File("image/AD.png")));
                Resources.TEXTURES.add(Resources.AD_2, ImageIO.read(new File("image/AD_2.png")));
                Resources.TEXTURES.add(Resources.BULLET, ImageIO.read(new File("image/Bullet.png")));
                Resources.TEXTURES.add(Resources.MISSILE, ImageIO.read(new File("image/missile.png")));
                Resources.TEXTURES.add(Resources.MONSTER, ImageIO.read(new File("image/monster.png")));
                Resources.TEXTURES.add(Resources.MONSTER_2, ImageIO.read(new File("image/monster_2.png")));
                Resources.TEXTURES.add(Resources.MONSTER_ATTACK, ImageIO.read(new File("image/monster_attack.png")));
                Resources.TEXTURES.add(Resources.GHOST, ImageIO.read(new File("image/ghost.png")));
                Resources.TEXTURES.add(Resources.GHOST_2, ImageIO.read(new File("image/ghost_2.png")));
                Resources.TEXTURES.add(Resources.GHOST_ATTACK, ImageIO.read(new File("image/ghost_attack.png")));
                Resources.TEXTURES.add(Resources.GHOST_INVISIBLE, ImageIO.read(new File("image/ghost_invi.png")));
                Resources.TEXTURES.add(Resources.GHOST_VISIBLE_2, ImageIO.read(new File("image/ghost_invi2.png")));
                Resources.TEXTURES.add(Resources.ITEM, ImageIO.read(new File("image/item.png")));
                Resources.TEXTURES.add(Resources.OBSTACLE, ImageIO.read(new File("image/obstacel.png")));
                Resources.TEXTURES.add(Resources.OBSTACLE_2, ImageIO.read(new File("image/obstacel_2.png")));
                Resources.TEXTURES.add(Resources.BACKGROUND, ImageIO.read(new File("image/anh_nen.png")));
                Resources.TEXTURES.add(Resources.PLAYER_ICE, ImageIO.read(new File("image/ice.png")));
                Resources.TEXTURES.add(Resources.F_MONSTER, ImageIO.read(new File("image/f_monster.png")));
                Resources.TEXTURES.add(Resources.F_MONSTER_2, ImageIO.read(new File("image/f_monster_2.png")));
                Resources.TEXTURES.add(Resources.Q, ImageIO.read(new File("image/Q.png")));
                Resources.TEXTURES.add(Resources.R, ImageIO.read(new File("image/R.png")));
                Resources.TEXTURES.add(Resources.BLOOD, ImageIO.read(new File("image/blood.png")));
        }catch (Exception e) {
        		System.out.print("Load Failed\n");
                e.printStackTrace();
        }
}
}
