public class Board
{
  public ChessPiece[][] board_array = new ChessPiece[8][8];
  
  public void init_board()
  {
    //Make a bunch of empty pieces where nothing goes
    for (int i = 0; i < 4; i++)
    {
      for (int b = 0; b < 8; b++)
      {
        board_array[i+2][b] = new ChessPiece(new int[]{i+2, b}, new String("empty") );
      }
    }
    //Make a bunch of pawns
    for (int i = 0; i < 8; i++)
    {
      board_array[1][i] = new Pawn(new int[]{i,1}, "white");
      board_array[6][i] = new Pawn(new int[]{i,6}, "black");
    }
    //Make normal units
    for (int i = 0; i < 3; i++)
    {
      for (int b = 0; b < 2; b++)
      {
        String color_ = b==0 ? "white" : "black";
        switch (i)
        {
          case 0:
            board_array[b*7][i] = new Rook(new int[]{i,b*7},color_);
            board_array[b*7][7-i] = new Rook(new int[]{7-i,b*7},color_);
            break;
          case 1:
            board_array[b*7][i] = new Knight(new int[]{i,b*7},color_);
            board_array[b*7][7-i] = new Knight(new int[]{7-i,b*7},color_);
            break;
          case 2:
            board_array[b*7][i] = new Bishop(new int[]{i,b*7},color_);
            board_array[b*7][7-i] = new Bishop(new int[]{7-i,b*7},color_);
            break;
        }
      }
    }
    for (int i = 0;i < 2; i++)
    {
      String color_ = i==0 ? "white" : "black";
      board_array[i*7][3] = new Queen(new int[]{3, i*7}, color_);
      board_array[i*7][4] = new King(new int[]{4, i*7}, color_);
    }
  }

  public Board()
  {
  }
}
