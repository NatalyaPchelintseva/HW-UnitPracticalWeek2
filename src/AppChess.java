import java.util.Arrays;

public class AppChess {
    static void getLeftUpCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line++;
            DiagonalElements[1][i] = column--;
        }
    }
    static void getLeftDownCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line--;
            DiagonalElements[1][i] = column--;
        }
    }
    static void getRightUpCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line++;
            DiagonalElements[1][i] = column++;
        }
    }
    static void getRightDownCorner(int line, int column, int[][] DiagonalElements) {
        for (int i = 0 ; i < 8; i++) {
            DiagonalElements[0][i] = line--;
            DiagonalElements[1][i] = column++;
        }
    }

    static void printElements(int[][] DiagonalElements) {
        System.out.println("-----");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(DiagonalElements[i][j] + "\t");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        int[][] leftUpCorner = new int[2][8];
        getLeftUpCorner(2, 3, leftUpCorner);
        printElements(leftUpCorner);

        int[][] leftDownCorner = new int[2][8];
        getLeftDownCorner(2, 3, leftDownCorner);
        printElements(leftDownCorner);

        int[][] rightUpCorner = new int[2][8];
        getRightUpCorner(2, 3, rightUpCorner);
        printElements(rightUpCorner);

        int[][] rightDownCorner = new int[2][8];
        getRightDownCorner(2, 3, rightDownCorner);
        printElements(rightDownCorner);

        int toLine = 5;
        int toColumn = 0;

//        int dx = leftUpCorner[0][toLine] - leftUpCorner[0][2];
//        int dy = leftUpCorner[1][toColumn] - leftUpCorner[1][3];
        int dx = Math.abs(2 - toLine);
        int dy = Math.abs(3 - toColumn);
        System.out.println(leftUpCorner[0][dx] + " " + leftUpCorner[1][dy]);
    }

}
