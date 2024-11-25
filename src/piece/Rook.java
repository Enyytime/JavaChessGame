package piece;

import Main.GamePanel;

public class Rook extends Piece{
  public Rook(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-rook");
    }
    else {
      image = getImage("/Piece/b-rook");
    }
  }
  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){
      if (targetCol == preCol || targetRow == preRow){
        if(isValidSquare(targetCol, targetRow) && pieceOnStraightLine(targetCol, targetRow) == false){
          return true;
        }
      }
    }
    return false;
  }
}
