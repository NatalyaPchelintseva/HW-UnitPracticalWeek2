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
        boolean isInSingleCell = false;
        boolean isInStraightLine = false;
        boolean isInDiagonal = false;
        int[] leftUpCorner = new int[2];
        leftUpCorner[0] = line + 1;
        leftUpCorner[1] = column - 1;
        int[] leftDownCorner = new int[2];
        leftDownCorner[0] =  line - 1;
        leftDownCorner[1] = column - 1;
        int[] rightUpCorner = new int[2];
        rightUpCorner[0] = line + 1;
        rightUpCorner[1] = column + 1;
        int[] rightDownCorner = new int[2];
        rightDownCorner[0] = line - 1;
        rightDownCorner[1] = line + 1;

        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (Math.abs(line - toLine) == 1 || Math.abs(column - toColumn) == 1) isInSingleCell = true;
            if ((line == toLine) || (column == toColumn)) isInStraightLine = true;
            if ((toLine == leftUpCorner[0] && toColumn == leftUpCorner[1]) ||
                    (toLine == leftDownCorner[0] && toColumn == leftDownCorner[1]) ||
                    (toLine == rightUpCorner[0] && toColumn == rightUpCorner[1]) ||
                    (toLine == rightDownCorner[0] && toColumn == rightDownCorner[1]))
                isInDiagonal = true;
            if (isInDiagonal || isInStraightLine || isInSingleCell) return true;
        }
        return false;
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
