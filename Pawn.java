import java.lang.Math;
public class Pawn extends ChessPiece
{
  public Pawn(int[] _pos, String _color)
  {
    super(_pos, _color);
  }

  public static String[] get_tiles(ChessPiece[][] board_)
  {
    String[] return_string = new String[]{"",""};
    for (int i = 0; i < 2; i++)
    {
      if (color == "white") return_string[i] = (pos[1]+i+1 <= 7)? board_[pos[1]+i+1][0].color : "";
      else return_string[i] = (pos[1]-i-1 >= 0)? board_[pos[1]-i-1][0].color : "";
    }
    return return_string;
  }

  public Boolean valid_move(int[] new_pos, String[] new_tile_color)
  {
    if (color == "white")
    {
      //Movement
      if ((pos[1] == 1 && new_pos[1] == 3 && new_tile_color[0] == "empty" && new_tile_color[1] == "empty" && new_pos[0] == pos[0])||(new_pos[1]-pos[1] == 1 && new_tile_color[0] == "empty" && new_pos[0] == pos[0])) return true;
      //Attack
      if (Math.abs(new_pos[0]-pos[0])==1 && new_pos[1]-pos[1] == 1 && new_tile_color[0] == "black") return true;
    }
    else 
    {
      //Movement
      if ((pos[1] == 6 && new_pos[1] == 4 && new_tile_color[0] == "empty" && new_tile_color[1] == "empty" && new_pos[0] == pos[0])||(pos[1]-new_pos[1] == 1 && new_tile_color[0] == "empty" && new_pos[0] == pos[0])) return true;
      //Attack
      if (Math.abs(new_pos[0]-pos[0])==1 && pos[1]-new_pos[1] == 1 && new_tile_color[0] == "white") return true;
    }
    return false;
  }
}
