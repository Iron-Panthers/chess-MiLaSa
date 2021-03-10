import java.util.*;

public class Bishop extends ChessPiece
{
  public Bishop(int[] _pos, String _color) {
    super(_pos, _color);
  }
  
  public String[] get_tiles(ChessPiece[][] board_, int[] new_pos)
  {
    // This list will store all encountered unit colors on the tracer's path
    List<String> return_string_vector = new ArrayList<String>();

    // x_change and y_change will be different based on the slope of the path the bishop's move is taking
    int x_change = 0;
    int y_change = 0;
    
    // Find the slope of the tracer
    if (new_pos[0] > pos[0] && new_pos[1] > pos[1])
    {
      // Bottom right corner
      x_change = 1;
      y_change = 1;
    }
    else if (new_pos[0] > pos[0] && new_pos[1] < pos[1])
    {
      // Top right corner
      x_change = 1;
      y_change = -1;
    }
    else if (new_pos[0] < pos[0] && new_pos[1] > pos[1])
    {
      // Bottom Left corner
      x_change = -1;
      y_change = 1;
    }
    else
    {
      // Top left corner
      x_change = -1;
      y_change = -1;
    }

    int i = 1;
    // Make sure the tracer's position isn't off of the baord
    while ((pos[0]+x_change*i>=0 && pos[0]+x_change*i < 8) && (pos[1]+y_change*i>=0 && pos[1]+y_change*i < 8)) 
    {
      // Add color to the tracer's list
      return_string_vector.add(board_[pos[1]+y_change*i][pos[0]+x_change*i].color);
      i++;
    }
    
    // Convert tracer's vector list into a structured array for program to accept
    String[] return_string = new String[return_string_vector.size()];
    return_string_vector.toArray(return_string);
    
    // Return the tracer's path
    return return_string;
  }

  public Boolean valid_move(int[] new_pos, ChessPiece[][] board_)
  {
    // Check to make sure that the piece we're looking at isn't straight across or above from current piece 
    if (new_pos[0] == this.pos[0] || new_pos[1] == this.pos[1]) return false;
    
    // Make sure the slope of the difference of the two pieces is 1 or -1, signifying a perfect diagnal
    if (Math.abs((double)(new_pos[1]-pos[1])/(double)(new_pos[0]-pos[0])) != 1.0) return false;
    
    // Get the current piece colors in this line away from the bishop
    String[] new_tile_color = get_tiles(board_,new_pos);
    
    //System.out.println(Arrays.toString(new_tile_color));
    
    // Make sure that all the pieces up to the destination are empty
    for (int i = 0; i < Math.abs(new_pos[0]-pos[0])-1; i++) if (new_tile_color[i] != "empty") return false;
    
    // Make sure the destination location is not the same color as current piece (either opposite color or empty)
    if (new_tile_color[Math.abs(new_pos[0]-pos[0])-1] == this.color) return false;
    
    // If nothing is wrong, then we can return true
    return true;
  }
}
