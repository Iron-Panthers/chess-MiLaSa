public class Board
{
  public ChessPiece[][] board_array = new ChessPiece[8][8];
  
  public void init_board()
  {
    
    // Make a bunch of pawns in spaces above units
    for (int i = 0; i < 8; i++)
    {
      board_array[6][i] = new Pawn(new int[]{i,6}, "white");
      board_array[1][i] = new Pawn(new int[]{i,1}, "black");
    }
    // Create Special Units ([i < 3] for the three kinds of different special units not counting king and queen)
    for (int i = 0; i < 3; i++)
    {
      // Variable b will keep in check which color we're writing to
      for (int b = 0; b < 2; b++)
      {
        String color_ = b==0 ? "black" : "white";
        // Determine piece based on iterator 'i'
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
    // Add king and queen based on color
    for (int i = 0;i < 2; i++)
    {
      String color_ = i==0 ? "black" : "white";
      board_array[i*7][3] = new Queen(new int[]{3, i*7}, color_);
      board_array[i*7][4] = new King(new int[]{4, i*7}, color_);
    }

    // Add a bunch of empty spaces that no other unit is taking up
    for (int i = 0; i < 4; i++)
    {
      for (int b = 0; b < 8; b++)
      {
        board_array[i+2][b] = new ChessPiece(new int[]{i+2, b}, new String("empty") );
      }
    }
  }

  public Board()
  {
  }
}
