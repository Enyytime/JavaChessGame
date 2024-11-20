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
}
