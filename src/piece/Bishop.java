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
}
