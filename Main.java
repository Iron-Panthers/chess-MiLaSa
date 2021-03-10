
import java.util.*;

public class Main
{
  public static void main(String args[])
  {
    // Chess board object
    Board chess_board = new Board();
    
    // Startup board sequence, sets all pieces in their needed positions
    chess_board.init_board();
    
    // Couple of test units for testing unit functions
    Bishop new_bishop = new Bishop(new int[]{2, 2}, "white");
    King new_king = new King(new int[]{1, 1}, "white");
    Pawn new_pawn = new Pawn(new int[]{1, 1}, "white");

    // Example move by one of the test pieces
    Boolean test = new_bishop.valid_move(new int[]{6,6}, chess_board.board_array);
    
    //System.out.println(test);
  }
}
