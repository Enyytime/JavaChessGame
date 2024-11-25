package piece;

import Main.GamePanel;

public class King extends Piece {
  public King(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-king");
    }
    else {
      image = getImage("/Piece/b-king");
    }
  }

  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetCol) && isSameSquare(targetCol, targetRow) == false){
      if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1
          || Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1){
        if(isValidSquare(targetCol, targetRow)){
          return true;
        }
      }
    }
    return false;
  }


}
