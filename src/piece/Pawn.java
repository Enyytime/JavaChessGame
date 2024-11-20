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
}
