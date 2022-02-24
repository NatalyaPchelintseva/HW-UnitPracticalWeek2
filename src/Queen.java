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
        int[][] leftUpCorner = new int[2][8];
        getLeftUpCorner(2, 3, leftUpCorner);

        int[][] leftDownCorner = new int[2][8];
        getLeftDownCorner(2, 3, leftDownCorner);

        int[][] rightUpCorner = new int[2][8];
        getRightUpCorner(2, 3, rightUpCorner);

        int[][] rightDownCorner = new int[2][8];
        getRightDownCorner(2, 3, rightDownCorner);

        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (Math.abs(line - toLine) == 1 || Math.abs(column - toColumn) == 1) isInSingleCell = true;
            if ((line == toLine) || (column == toColumn)) isInStraightLine = true;
            int dx = Math.abs(line - toLine);
            int dy = Math.abs(column - toColumn);
            if ((toLine == leftUpCorner[0][dx] && toColumn == leftUpCorner[1][dy]) ||
                    (toLine == leftDownCorner[0][dx] && toColumn == leftDownCorner[1][dy]) ||
                    (toLine == rightUpCorner[0][dx] && toColumn == rightUpCorner[1][dy]) ||
                    (toLine == rightDownCorner[0][dx] && toColumn == rightDownCorner[1][dy]))
                isInDiagonal = true;
            if ((isInDiagonal || isInStraightLine || isInSingleCell) && !isUnderAttack(chessBoard, toLine, toColumn)) return true;
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

    public void getLeftUpCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line++;
            DiagonalElements[1][i] = column--;
        }
    }
    public void getLeftDownCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line--;
            DiagonalElements[1][i] = column--;
        }
    }
    public void getRightUpCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line++;
            DiagonalElements[1][i] = column++;
        }
    }
    public void getRightDownCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line--;
            DiagonalElements[1][i] = column++;
        }
    }

}
