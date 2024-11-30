package piece;

import Main.GamePanel;

public class Pawn extends Piece {
  public Pawn(int color, int row, int col) {
    super(color, row, col);
    if(color == GamePanel.WHITE){
      image = getImage("/Piece/w-pawn");
    }
    else {
      image = getImage("/Piece/b-pawn");
    }
  }

  public boolean canMove(int targetCol, int targetRow){
    if(isWithingBoard(targetCol, targetRow) && isSameSquare(targetCol, targetRow) == false){
      int moveValue;
      if(color == GamePanel.WHITE){
        moveValue = -1;
      }
      else {
        moveValue = 1;
      }

      hittingPiece = getHittingPiece(targetCol, targetRow);
      if(targetCol == preCol && targetRow == preRow + moveValue && hittingPiece == null){
        return true;
      }
      if(targetCol == preCol && targetRow == preRow +moveValue * 2 && hittingPiece == null && pieceOnStraightLine(targetCol, targetRow) == false && moved == false){
        return true;
      }

      if(Math.abs(targetCol -preCol) == 1 && targetRow == preRow + moveValue && hittingPiece != null && hittingPiece.color != color){
        return true;
      }
    }
    return false;
  }
}
