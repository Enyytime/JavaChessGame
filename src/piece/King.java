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

      if(moved == false){
        // right castling
        if(targetCol == preCol + 2 && targetRow == preRow && pieceOnStraightLine(targetCol, targetRow) == false){
          for(Piece piece: GamePanel.simPieces){
            if(piece.col == preCol + 3 && piece.row == preRow && piece.moved == false){
              GamePanel.castlingPiece = piece;
              return true;
            }
          }
        }

        // left castling
        if(targetCol == preCol - 2 && targetRow == preRow && pieceOnStraightLine(targetCol, targetRow) == false){
          Piece p[] = new Piece[2];

          for(Piece piece : GamePanel.simPieces){
            if(piece.col == preCol - 3 && piece.row == targetRow){
              p[0] = piece;
            }
            if(piece.col == preCol - 4 && piece.row == targetRow){
              p[1] = piece;
            }
            if(p[0] == null && p[1] != null && p[1].moved == false){
              GamePanel.castlingPiece = p[1];
              return true;
            }
          }
        }
      }
    }
    return false;
  }


}
