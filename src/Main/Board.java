package Main;

import java.awt.*;

public class Board {
  public static int MAX_COL = 8;
  public static int MAX_ROW = 8;
  public static final int square_size = 80;
  public static final int half_square_size = square_size/2;

  public static void draw(Graphics2D g2){
    int darkLight = 0;
    for(int row = 0; row < MAX_ROW; row++){
      for(int col = 0; col < MAX_COL; col++){
        if(darkLight == 0){
          g2.setColor(new Color(232,237,249,255));
          darkLight = 1;
        }
        else{
          g2.setColor(new Color(183,192,216,255));
          darkLight = 0;
        }
        g2.fillRect(col*square_size, row*square_size, square_size, square_size);
      }
      if(darkLight == 0) darkLight = 1;
      else darkLight = 0;
    }
  }
}
