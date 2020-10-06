import java.util.Scanner;

public class Matrices {
    static Scanner in;
    private static final int ROW = 3, COL = 3;
    public static void main( String[] args ) {
        in = new Scanner(System.in);

        System.out.print("Enter +, -, *: ");
        char op = in.next().charAt(0);
        double[][] a;
        double[][] b;
        double[][] c;
        a = enterArray(1);
        b = enterArray(2);
        if (op == '+') c = addMatrix(a, b);
        else if (op == '-') c = subtractMatrix(a, b);
             else c = multiplyMatrix(a, b);
        printMatrix(a, b, c, op);
        in.close();
    }

    private static double[][] enterArray( int no ) {
        System.out.print("Enter matrix" + no + ": ");
        double[][] matrix = new double[ROW][COL];
        for ( int row = 0; row < ROW; row++ ) {
            for ( int col = 0; col < COL; col++ ) {
                matrix[row][col] = in.nextDouble();
            }
        }
        return matrix;
    }

    public static void printMatrix( double[][] a, double[][] b, double[][] c, char op ) {
        String format = "%-20s  %c  %-20s  %c  %-20s\n";
        String operation;
        if (op == '+') operation = "addition";
        else if (op == '-') operation = "subtraction";
        else operation = "multiplication";
        System.out.printf("The %s of the matrices is\n", operation);
        String rowA, rowB, rowC;
        rowA = rowB = rowC = " ";
        for ( int i = 0; i < ROW; i++ ) {
            if (i < a.length) rowA = formatRow(a[i]); else rowA = " ".repeat(rowA.length());
            if (i < b.length) rowB = formatRow(b[i]); else rowB = " ".repeat(rowB.length());
            if (i < c.length) rowC = formatRow(c[i]); else rowC = " ".repeat(rowC.length());
            if (i == a.length / 2) System.out.printf(format, rowA, op,  rowB, '=', rowC);
            else                   System.out.printf(format, rowA, ' ', rowB, ' ', rowC);
        }
    }

    private static String formatRow(double[] row) {
        StringBuilder sb = new StringBuilder();
        for ( double cell : row ) {
            sb.append(String.format("%5.1f", cell)).append(" ");
        }
        return sb.toString();
    }

    public static double[][] addMatrix( double[][] a, double[][] b ) {
        double[][] c = new double[a.length][a[0].length];
        for ( int row = 0; row < a.length; row++ ) {
            for ( int col = 0; col < a[row].length; col++ ) {
                c[row][col] = a[row][col] + b[row][col];
            }
        }
        return c;
    }

    public static double[][] subtractMatrix( double[][] a, double[][] b ) {
        double[][] c = new double[a.length][a[0].length];
        for ( int row = 0; row < a.length; row++ ) {
            for ( int col = 0; col < a[row].length; col++ ) {
                c[row][col] = a[row][col] - b[row][col];
            }
        }
        return c;
    }

    public static double[][] multiplyMatrix( double[][] a, double[][] b ) {
        double[][] c = new double[a.length][b[0].length];
        for ( int row = 0; row < c.length; row++ ) {
            for ( int col = 0; col < c[row].length; col++ ) {
                c[row][col] = 0;
                for ( int k = 0; k < b.length; k++ ) {
                    c[row][col] += a[row][k] * b[k][col];
                }
            }
        }
        return c;
    }
}
