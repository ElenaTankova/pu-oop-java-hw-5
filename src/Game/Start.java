package Game;

import java.awt.*;
import java.util.Random;

public class Start extends Tile {

    public Color Random;

    public Start(int row, int col) {

        super(row, col);
        this.color = Random;
        this.id = "Start";
    }

    @Override
    public void renderBoard(Graphics g) {

        int tileX = this.col * this.TILE_SIZE;
        int tileY = this.row * this.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);

        drawBorders(g,tileX,tileY);
    }

}
