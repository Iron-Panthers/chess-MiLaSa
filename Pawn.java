import java.lang.Math;
public class Pawn extends ChessPiece
{
  public Pawn(int[] _pos, String _color)
  {
    super(_pos, _color);
  }

  public String[] get_tiles(ChessPiece[][] board_)
  {
    // This is the output string array that will store color properties of pieces ahead of current piece
    String[] return_string = new String[]{"",""};
    
    // For loop goes twice, two possible unit spaces above (this ensures that a pawn can be able to check for two above if moving two squares on its first move)
    for (int i = 0; i < 2; i++)
    {
      // Adds colors to return_string, changes direction based on color
      if (this.color == "white") return_string[i] = (pos[1]+i+1 <= 7)? board_[this.pos[1]+i+1][0].color : "";
      else return_string[i] = (this.pos[1]-i-1 >= 0)? board_[this.pos[1]-i-1][0].color : "";
    }
    return return_string;
  }

  public Boolean valid_move(int[] new_pos, String[] new_tile_color)
  {
    if (this.color == "white")
    {
      //Movement
      if ((this.pos[1] == 1 && new_pos[1] == 3 && new_tile_color[0] == "empty" && new_tile_color[1] == "empty" && new_pos[0] == this.pos[0])||(new_pos[1]-this.pos[1] == 1 && new_tile_color[0] == "empty" && new_pos[0] == this.pos[0])) return true;
      //Attack
      if (Math.abs(new_pos[0]-this.pos[0])==1 && new_pos[1]-this.pos[1] == 1 && new_tile_color[0] == "black") return true;
    }
    else 
    {
      //Movement
      if ((this.pos[1] == 6 && new_pos[1] == 4 && new_tile_color[0] == "empty" && new_tile_color[1] == "empty" && new_pos[0] == this.pos[0])||(this.pos[1]-new_pos[1] == 1 && new_tile_color[0] == "empty" && new_pos[0] == this.pos[0])) return true;
      //Attack
      if (Math.abs(new_pos[0]-this.pos[0])==1 && this.pos[1]-new_pos[1] == 1 && new_tile_color[0] == "white") return true;
    }
    return false;
  }
}
