package piece;

import Main.GamePanel;

public class Queen extends Piece{

  public Queen(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-queen");
    }
    else {
      image = getImage("/Piece/b-queen");
    }
  }

  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){
      // vertical & horizontal
      if (targetCol == preCol || targetRow == preRow){
        if(isValidSquare(targetCol, targetRow) && pieceOnStraightLine(targetCol, targetRow) == false){
          return true;
        }
      }

      // diagonal
      if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)){
        if(isValidSquare(targetCol, targetRow) && pieceOnDiagonalLine(targetCol, targetRow) == false){
          return true;
        }
      }
    }
    return false;
  }
}
