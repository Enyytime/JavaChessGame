package piece;

import Main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

  public BufferedImage image;
  public int x,y;
  public int col, row, preRow, preCol;
  public int color;

  // instantiate
  public Piece(int color, int col, int row ){
    this.color = color;
    this.row = row;
    this.col = col;
    x = getX(col);
    y = getY(row);
    preCol = col;
    preRow = row;
  }

  public BufferedImage getImage (String imagePath){
    BufferedImage image = null;
    try{
      image = ImageIO.read(getClass().getResourceAsStream(imagePath + ".png"));
    } catch(IOException e) {
      e.printStackTrace();
    }

    return image;
  }

  public int getX(int col){

    return col * Board.square_size;
  }
  public int getY(int row){

    return row * Board.square_size;
  }

  public int getWidth(){
    return Board.square_size;
  }

  public int getHeight(){
    return Board.square_size;
  }

  public int getCol(int x){
    return (x + Board.half_square_size) / Board.square_size;
  }

  public int getRow(int x){
    return (y + Board.half_square_size) / Board.square_size;
  }

  public void updatePosition(){
    x = getX(col);
    y = getY(row);
    preCol = col;
    preRow = row;
  }
  public void draw(Graphics2D g2){
    // x and y is it's coordinate , and the width and height is the Board.square_size;
    g2.drawImage(image, x, y, getWidth() ,  getHeight(), null);
  }


}
