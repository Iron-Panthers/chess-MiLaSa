
import java.util.*;

public class Main
{
  public static void main(String args[])
  {
    
    Board chess_board = new Board();
    chess_board.init_board();
    Bishop new_bishop = new Bishop(new int[]{1, 1}, "white");
    King new_king = new King(new int[]{1, 1}, "white");
    Pawn new_pawn = new Pawn(new int[]{1, 1}, "white");

    for (int i = 0; i < 8; i++)
    {
      for (int b = 0; b < 8; b++)
      {
        System.out.print(chess_board.board_array[i][b].color + " ");
      }
      System.out.print("\n");
    }
    Boolean test = new_bishop.valid_move(new int[]{2,2}, chess_board.board_array);
    System.out.println(test);
  }
}
