
import java.util.*;

public class Main
{
  public static void main(String args[])
  {
    
    Board chess_board = new Board();
    chess_board.init_board();
    Bishop new_bishop = new Bishop(new int[]{2, 2}, "white");
    King new_king = new King(new int[]{1, 1}, "white");
    Pawn new_pawn = new Pawn(new int[]{1, 1}, "white");

    Boolean test = new_bishop.valid_move(new int[]{3,3}, chess_board.board_array);
    System.out.println(test);
  }
}
