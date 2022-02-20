abstract public class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    abstract public String getColor();
    abstract public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    abstract public String getSymbol();

    protected boolean checkPosition(int position) {
        return ((position >= 0) && (position <= 7));
    }

    protected int getMax (int a, int b) {
        return (a > b) ? a : b;
    }

    protected int getMin (int a, int b) {
        return (a < b) ? a : b;
    }
}
