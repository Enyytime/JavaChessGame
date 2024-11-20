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
}
