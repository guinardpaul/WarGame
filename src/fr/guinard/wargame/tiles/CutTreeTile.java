package fr.guinard.wargame.tiles;

import fr.guinard.wargame.gfx.Assets;

public class CutTreeTile extends Tile {

	public CutTreeTile(int id) {
		super(Assets.cut_tree, id);
	}

	public boolean isSolid() {
		return true;
	}

}
