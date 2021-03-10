public class ChessPiece
{
  // Public variables that all chess pieces will inherit
  public int[] pos;
  public String color;
  
  // Constructor to assign parameters to different values
  public ChessPiece(int[] _pos, String _color)
  {
    pos = _pos;
    color = _color;
  }
}
