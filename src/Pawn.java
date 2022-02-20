public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) &&
                checkPosition(toColumn) && chessBoard.board[line][column] != null) {
            if (column == toColumn) {
                int dir;
                int start;
                if (color.equals("White")) {
                    dir = 1;
                    start = 1;
                }
                else {
                    dir = -1;
                    start = 6;
                }
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                if (line == start && line + 2 * dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null &&
                            chessBoard.board[line + dir][column] == null;
                }
            }
        }
        else {
            if (((column - toColumn == 1) || (column - toColumn == -1)) &&
                    ((line - toLine == 1) || (line - toLine == -1)) &&
                    (chessBoard.board[toLine][toColumn] != null)) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }
            else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    private boolean checkPosition(int position) {
        return ((position >= 0) && (position <= 7));
    }
}
