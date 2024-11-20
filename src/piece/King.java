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
}
