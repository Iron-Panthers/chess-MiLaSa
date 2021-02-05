import java.lang.Math;
public class Pawn extends ChessPiece
{
  public Pawn(int[] _pos, String _color)
  {
    super(_pos, _color);
  }

  public Boolean valid_move(int[] new_pos, String[] new_tile_color)
  {
    if (color == "white")
    {
      //Movement
      if ((pos[1] == 1 && new_pos[1] == 3 && new_tile_color[0] == "empty" && new_tile_color[1] == "empty" && new_pos[0] == pos[0])||(new_pos[1]-pos[1] == 1 && new_tile_color[0] == "empty" && new_pos[0] == pos[0])) return 1;
      //Attack
      if (Math.abs(new_pos[0]-pos[0])==1 && new_pos[1]-pos[1] == 1 && new_tile_color[0] == "black")
    }
    else 
    {
      
    }
  }
}
