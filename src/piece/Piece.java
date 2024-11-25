package piece;

import Main.Board;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Piece {

  public BufferedImage image;
  public int x,y;
  public int col, row, preRow, preCol;
  public int color;
  public Piece hittingPiece;
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

  public boolean canMove(int targetCol, int targetRow){
    return false;
  }

  public void resetPosition(){
    col = preCol;
    row = preRow;
    x = getX(col);
    y = getY(row);
  }

  public Piece getHittingPiece(int targetCol, int targetRow){
    for(Piece piece: GamePanel.simPieces){
      if(piece.col == targetCol && piece.row == targetRow && piece != this){
        return piece;
      }
    }
    return null;
  }
  public int getIndex(){
    for(int i = 0; i < GamePanel.simPieces.size(); i++){
      if(GamePanel.simPieces.get(i) == this){
        return i;
      }
    }
    return 0;
  }

  public boolean isValidSquare(int targetCol, int targetRow){
    hittingPiece = getHittingPiece(targetCol, targetRow);

    if(hittingPiece == null){
      return true;
    }
    else {
      if(hittingPiece.color != this.color){ // if the colour is different than it can be eaten
        return true;
      }
      else {
        hittingPiece = null; //same colour than it can't be moved
      }
    }
    return false;
  }

  public boolean isWithingBoard(int targetCol, int targetRow){
    if(targetCol >= 0 && targetCol <= 7 && targetRow >= 0 && targetRow <= 7) return true;
    else return false;
  }

  public boolean isSameSquare(int targetCol, int targetRow){ // to deny moving to the same square
    if(targetCol == preCol && targetRow == preRow){
      return true;
    }
    return false;
  }

  public boolean pieceOnStraightLine(int targetCol, int targetRow){
    // check up
    for(int i = preRow - 1; i > targetRow; i--){
      for(Piece piece: GamePanel.simPieces){
        if(piece.col == targetCol && piece.row == i){
           hittingPiece = piece;
           return true;
        }
      }
    }
    // check down
    for(int i = preRow + 1; i < targetRow; i++){
      for(Piece piece: GamePanel.simPieces){
        if(piece.col == targetCol && piece.row == i){
          hittingPiece = piece;
          return true;
        }
      }
    }
    // check right
    for(int i = preCol + 1; i < targetCol; i++){
      for(Piece piece: GamePanel.simPieces){
        if(piece.col == i && piece.row == targetRow){
          hittingPiece = piece;
          return true;
        }
      }
    }
    // check left
    for(int i = preCol - 1; i > targetCol; i--){
      for(Piece piece: GamePanel.simPieces){
        if(piece.col == i && piece.row == targetRow){
          hittingPiece = piece;
          return true;
        }
      }
    }
    return false;
  }

  public void draw(Graphics2D g2){
    // x and y is it's coordinate , and the width and height is the Board.square_size;
    g2.drawImage(image, x, y, getWidth() ,  getHeight(), null);
  }
}
