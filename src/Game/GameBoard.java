package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {


    public static int firstRandomNumber;
    public static int secondRandomNumber;
    Player player = new Player(firstRandomNumber, secondRandomNumber);
    public Object[][] tileCollection;
    public Object selectedTile;



    public GameBoard () {

        this.setSize(900, 900);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.tileCollection = new Object[64][64];
        this.addMouseListener(this);
        fillTileCollection();
    }


    public Object getTile(int row, int col) {
            return this.tileCollection[row][col];
        }

        public boolean isThereTile(int row, int col) {
            return this.tileCollection[row][col] != null;
        }


        public void renderTiles(Graphics g, int row, int col) {

            if (this.isThereTile(row, col)) {
                Tile t = (Tile)this.getTile(row, col);
                t.renderBoard(g);
            }
        }


    @Override
    public void mouseClicked(MouseEvent e) {

        int row = this.getDimensionsBasedOnCoordinates(e.getY());
        int col = this.getDimensionsBasedOnCoordinates(e.getX());
        Tile tile = (Tile) this.getTile(row, col);

       if(tile.getId() == "Burnt" && tile.getColor() == Tile.nGreen && selectedTile == null){
           this.selectedTile = this.getTile(row, col);
           tile.setColor(tile.nBlack);
           repaint();
       }else if(this.selectedTile == "Burnt" && tile.getColor() == Tile.nRed && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlack);
           repaint();
       }else if(this.selectedTile == "Burnt" && tile.getColor() == Tile.nBlue && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlack);
           repaint();
       }else if(this.selectedTile == "Sturdy" && tile.getColor() == Tile.nBlue && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlue);
           repaint();
       } else if(this.selectedTile == "Sturdy" && tile.getColor() == Tile.nGreen && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nGreen);
           repaint();
       } else if(this.selectedTile == "Sturdy" && tile.getColor() == Tile.nRed && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nRed);
           repaint();
       }else if(this.selectedTile == "AboutToBurn" && tile.getColor() == Tile.nRed && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlack);
           repaint();
       }else if(this.selectedTile == "AboutToBurn" && tile.getColor() == Tile.nBlue && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlack);
           repaint();
       }else if(this.selectedTile == "AboutToBurn" && tile.getColor() == Tile.nGreen && selectedTile == null){
           this.selectedTile = this.getTile(row,col);
           tile.setColor(tile.nBlack);
           repaint();
       }

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    public void updateBoard(int row, int col) {

        this.tileCollection[row][col] = this.selectedTile;
        this.selectedTile = null;
        this.repaint();
    }


    public int getDimensionsBasedOnCoordinates(int coordinates) {
        return coordinates / Tile.TILE_SIZE;
    }


    public void fillTileCollection() {

        getRandomStartPosition();
        this.tileCollection[firstRandomNumber][secondRandomNumber] =
                (new Start(firstRandomNumber,secondRandomNumber));

        player.setRow(firstRandomNumber);
        player.setCol(secondRandomNumber);

        for(int i = 0; i < 64; i++) {
            getRandomNumber();
        }

    }


    public static void getRandomStartPosition() {
        Random rand = new Random();
        firstRandomNumber = rand.nextInt(64);
        secondRandomNumber = rand.nextInt(64);
        while (firstRandomNumber != 0 && firstRandomNumber != 63 ||
                secondRandomNumber != 0 && secondRandomNumber != 63) {
            firstRandomNumber = rand.nextInt(64);
            secondRandomNumber = rand.nextInt(64);

        }
    }

    public static void getRandomNumber() {

        Random random = new Random();
        firstRandomNumber = random.nextInt(64);
        secondRandomNumber = random.nextInt(64);

    }


    public void paint(Graphics g) {
        super.paint(g);

        for (int row = 0; row < 64; row++) {
            for (int col = 0; col < 64; col++) {

                this.renderTiles(g, row, col);
                this.renderPlayer(row, col, g);
            }
        }
    }

    public void renderPlayer(int row, int col, Graphics g) {

        if (this.isThereTile(row, col)) {
            Tile t = (Tile)this.getTile(row, col);
            t.getColor();
            if(t.getColor() == Tile.nGreen) {
                player.render(g);
            }
        }
    }

}
