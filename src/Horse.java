public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard,
                                     int line, int column, int toLine, int toColumn) {
        if (line != toLine && column != toColumn) {
            if (checkPosition(toLine) && checkPosition(toColumn)) {
                int dx = Math.abs(toLine - line);
                int dy = Math.abs(toColumn - column);
                if ((dx == 1 && dy == 2) || (dx == 2 && dy == 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
