package Game;

import java.awt.*;

public abstract class Tile {

    protected int row;
    protected int col;
    protected Color color;
    protected String id;
    public static final int TILE_SIZE = 20;


    public static Color nGreen = new Color(41, 232, 9);
    public static Color nRed = new Color(248, 1, 0);
    public static Color nBlue = new Color (39, 33, 239);
    public static Color nBlack = new Color(0, 0, 0);

    public Tile (int row, int col) {

        this.row = row;
        this.col = col;
    }

    public abstract void renderBoard(Graphics g);


    public void drawBorders(Graphics g, int tileX, int tileY) {

        g.setColor(Color.black);
        g.drawRect(tileX,tileY,TILE_SIZE,TILE_SIZE);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getId() {
        return id;
    }


}
