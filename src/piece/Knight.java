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
}
