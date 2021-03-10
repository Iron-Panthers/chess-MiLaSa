import java.lang.Math;

public class King extends ChessPiece {
  public King(int[] _pos, String _color) {
    super(_pos, _color);
  }

  public Boolean valid_move(int[] new_pos, String new_tile_color) {
    // The new_pos will be the requested position
    // New_tile_color can either be "white" "black" or "empty". This is the color of
    if ((Math.abs(pos[0]-new_pos[0])<=1&&Math.abs(pos[1]-new_pos[1])<=1)&&(new_tile_color != color)) return true;
    else return false;
  }
}