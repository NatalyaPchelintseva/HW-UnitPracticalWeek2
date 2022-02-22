public class Queen extends ChessPiece {

    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            // if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;
            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;
            if (chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.color);
            }
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if (checkPosition(line) && checkPosition(column)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if (chessBoard.board[i][j] != null) {
                        if (!chessBoard.board[i][j].getColor().equals(this.color) &&
                                chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } else return true;
    }
}
