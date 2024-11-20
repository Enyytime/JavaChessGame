package Main;

import java.awt.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import piece.*;

public class GamePanel extends JPanel implements Runnable{
  public static final int WIDTH = 640;
  public static final int HEIGHT = 640;

  final int FPS = 60;
  Thread gameThread;
  Board board = new Board();
  Mouse mouse = new Mouse();

  // Color
  public static final int WHITE = 0;
  public static final int BLACK = 1;
  int currentColor = WHITE;

  // Pieces
  public static ArrayList<Piece> pieces = new ArrayList<>(); //backup list
  public static ArrayList<Piece> simPieces = new ArrayList<>(); // used pieces
  Piece activePiece;

  public GamePanel() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(Color.BLACK);
    addMouseMotionListener(mouse);
    addMouseListener(mouse);

    setPieces();
    copyPieces(pieces, simPieces);
  }

  public void launchGame(){
    gameThread = new Thread(this);
    gameThread.start();
  }

  public void setPieces(){
    //-----------WHITE TEAM-----------//
    // Add White pawns
    for (int col = 0; col < 8; col++) {
      pieces.add(new Pawn(WHITE, col, 6)); // White pawns on row 6
    }

    // Rest of the white
    pieces.add(new Rook(WHITE, 0, 7));
    pieces.add(new Rook(WHITE, 7, 7));
    pieces.add(new Knight(WHITE, 1, 7));
    pieces.add(new Knight(WHITE, 6, 7));
    pieces.add(new Bishop(WHITE, 2, 7));
    pieces.add(new Bishop(WHITE, 5, 7));
    pieces.add(new Queen(WHITE, 3, 7));
    pieces.add(new King(WHITE, 4, 7));


    //-----------BLACK TEAM-----------//

    // Add black pawns
    for (int col = 0; col < 8; col++) {
      pieces.add(new Pawn(BLACK, col, 1)); // Black pawns on row 1
    }

    // Rest of the white
    pieces.add(new Rook(BLACK, 0 , 0));
    pieces.add(new Rook(BLACK, 7, 0));
    pieces.add(new Knight(BLACK, 1, 0));
    pieces.add(new Knight(BLACK, 6, 0));
    pieces.add(new Bishop(BLACK, 2, 0));
    pieces.add(new Bishop(BLACK, 5, 0));
    pieces.add(new Queen(BLACK, 3, 0));
    pieces.add(new King(BLACK, 4, 0));
  }

  public void copyPieces(ArrayList<Piece> source, ArrayList<Piece> target){
    target.clear();
    for(int i = 0; i < source.size(); i++){
      target.add(source.get(i));
    }
  }
  @Override
  public void run() {
    double drawInterval = 1000000000 / FPS;
    double deltaTime = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    while(gameThread != null) {
      currentTime = System.nanoTime();
      deltaTime += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;


      if(deltaTime >= 1) {
        // 1. Update: information such as character position
        update();
        // 2. Draw: the frames with updated informations
        repaint(); // this is how you call the paintComponent function
        deltaTime--;
      }

    }
  }

  public void update(){
    if(mouse.pressed){
      if(activePiece == null){ // means the player is not holding any piece
        for(Piece piece : simPieces){ // iterate through all the pieces in the board, to find which one is being held
          if(piece.color == currentColor &&
                  piece.col == mouse.x / Board.square_size &&
                  piece.row == mouse.y / Board.square_size){
            activePiece = piece; // set the active piece
          }
        }
      }
      else{
        simulate();
      }
    }
    if(!mouse.pressed){
      if(activePiece != null){
        activePiece.updatePosition();
        activePiece = null;
      }
    }
  }

  public void simulate(){
    activePiece.x = mouse.x - Board.half_square_size;
    activePiece.y = mouse.y - Board.half_square_size;
    activePiece.row = activePiece.getRow(activePiece.y);
    activePiece.col = activePiece.getCol(activePiece.x);
  }

  // used to draw objects in the panel
  public void paintComponent(Graphics g){

    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;

    // Instantiate Board
    Board.draw(g2);

    // Instantiate Pieces
    for(Piece p : pieces){
      p.draw(g2);
    }
  }

}