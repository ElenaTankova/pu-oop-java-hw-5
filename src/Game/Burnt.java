package Game;

import java.awt.*;

public class Burnt extends Tile {

    public Burnt (int row, int col) {
        super(row, col);
        this.color = nBlack;
        this.id = "Burnt";
    }

    @Override
    public void renderBoard(Graphics g) {

        int tileX = this.col * this.TILE_SIZE;
        int tileY = this.row * this.TILE_SIZE;

        g.setColor(this.color);
        g.fillRect(tileX,tileY,TILE_SIZE,TILE_SIZE);

        drawBorders(g,tileX,tileY);
    }

}
