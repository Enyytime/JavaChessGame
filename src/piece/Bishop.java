package piece;

import Main.GamePanel;

public class Bishop extends Piece{

  public Bishop(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-bishop");
    }
    else {
      image = getImage("/Piece/b-bishop");
    }
  }

  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){
      if (Math.abs(targetCol - preCol) == Math.abs(targetRow - preRow)){
        if(isValidSquare(targetCol, targetRow) && pieceOnDiagonalLine(targetCol, targetRow) == false){
          return true;
        }
      }
    }
    return false;
  }

}
