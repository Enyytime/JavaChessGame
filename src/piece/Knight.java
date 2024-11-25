package piece;

import Main.GamePanel;

public class Knight extends Piece{
  public Knight(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-knight");
    }
    else {
      image = getImage("/Piece/b-knight");
    }
  }

  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetRow)){
      if(Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 2){
        if(isValidSquare(targetCol, targetRow)){
          return true;
        }
      }
    }
    return false;
  }
}
