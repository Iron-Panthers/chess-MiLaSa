public class Main
{
  public static void main(String args[])
  {
    
    Board chess_board = new Board();
    chess_board.init_board();
    King new_king = new King(new int[]{1, 1}, "white");
    Pawn new_pawn = new Pawn(new int[]{1, 1}, "white");
    Boolean test = new_pawn.valid_move(new int[]{2,2}, new String[]{"black"});
    System.out.println(test);
  }
}
