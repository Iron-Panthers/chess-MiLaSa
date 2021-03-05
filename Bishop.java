import java.util.*;

public class Bishop extends ChessPiece
{
  public Bishop(int[] _pos, String _color) {
    super(_pos, _color);
  }
  
  public String[] get_tiles(ChessPiece[][] board_, int[] new_pos)
  {
    List<String> return_string_vector = new ArrayList<String>();

    int x_change = 0;
    int y_change = 0;
    if (new_pos[0] > pos[0] && new_pos[1] > pos[1])
    {
      //Top right corner
      x_change = 1;
      y_change = -1;
    }
    else if (new_pos[0] > pos[0] && new_pos[1] < pos[1])
    {
      //Bottom right corner
      x_change = 1;
      y_change = 1;
    }
    else if (new_pos[0] < pos[0] && new_pos[1] > pos[1])
    {
      //Top Left corner
      x_change = -1;
      y_change = -1;
    }
    else
    {
      //Bottom left corner
      x_change = -1;
      y_change = 1;
    }

    int i = 1;
    while ((pos[0]+x_change*i>=0 && pos[0]+x_change*i < 8) && (pos[1]+y_change*i>=0 && pos[1]+y_change*i < 8)) 
    {
      System.out.println("X-Pos: "+String.valueOf(pos[0]+x_change*i));
      return_string_vector.add(board_[pos[1]+y_change*i][pos[0]+x_change*i].color);
      i++;
    }
  
    String[] return_string = new String[return_string_vector.size()];
    return_string_vector.toArray(return_string);
    return return_string;
  }

  public Boolean valid_move(int[] new_pos, ChessPiece[][] board_) {

    if (new_pos[0] == this.pos[0] || new_pos[1] == this.pos[1]) return false;
    if (Math.abs((double)(new_pos[1]-pos[1])/(double)(new_pos[0]-pos[0])) != 1.0) return false;
    String[] new_tile_color = get_tiles(board_,new_pos);
    System.out.println(Arrays.toString(new_tile_color));
      return false;
  }
}
