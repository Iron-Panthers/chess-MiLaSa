public class Bishop extends ChessPiece
{
  public Bishop(int[] _pos, String _color) {
    super(_pos, _color);
  }

  public Boolean valid_move(int[] new_pos, String new_tile_color) {
    if ((Math.abs(pos[0]-new_pos[0])<=15) && (new_tile_color != color)) {
      return true;
    } else {
      return false;
    }
  }
}