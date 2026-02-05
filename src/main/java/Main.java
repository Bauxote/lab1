import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class  Main  {
    public static void main(String[] args)  {
        short lowerLimit, upperLimit;
        final short multiplier;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        try {
            System.out.print("Enter the number of rows for the matrix: ");
            int rows = scanner.nextInt();
            System.out.print("Enter the number of columns for the matrix: ");
            int columns = scanner.nextInt();
            if (rows <= 0 || columns <= 0) {
                throw new IllegalArgumentException("Rows and columns must be positive integers.");
            }
            System.out.print("Enter the lower limit the matrix(from -32768 to 32767): ");
            lowerLimit = scanner.nextShort();
            System.out.print("Enter the upper limit the matrix(from -32768 to 32767): ");
            upperLimit = scanner.nextShort();
            if (lowerLimit >= upperLimit)  {
                    throw new IllegalArgumentException("Upper limit has to be higher than lower one");
            }

            short[][] matrixB = generateMatrix(rows, columns, upperLimit, lowerLimit, random);
            System.out.println("\nGenerated Matrix B:");
            printMatrix(matrixB);

            System.out.print("Enter the multiplier for matrix B to be multiplied(from -32768 to 32767): ");
            multiplier = scanner.nextShort()();
            short[][] matrixC = multiplyMatrix(matrixB, multiplier);

            System.out.println("\nMatrix C:");
            printMatrix(matrixC);

            System.out.println("\nSum of smallest integers in each row of C: " + calculateSumMinRow(matrixC));}
            catch (InputMismatchException e)  {
                System.err.println("Invalid input, please enter an integer");
            }
            finally  {
            scanner.close();
            }
    }
    public static short[][] multiplyMatrix(short[][] matrix, short a) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        short[][] result = new short[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (short) (matrix[i][j] * a);
            }
        }
        return result;
    }

    public static short calculateSumMinRow(short[][] matrix){
        short sum = 0;
        for (short[] row : matrix) {
            sum += findMin(row);
        }
        return sum;
    }

    public static short findMin(short[] array) {
        short min = array[0];
        for (short val: array) {
            if (val < min) {min = val;}
        }
        return min;
    }

    private static void printMatrix(short[][] matrix) {
        for (short[] row : matrix)  {
            for (short val : row)  {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    private static short[][] generateMatrix(int row, int column, short upperLimit, short lowerLimit, Random rnd){
        short[][] matrix = new short[row][column];
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (short) rnd.nextInt(lowerLimit, upperLimit+1);
            }
        }
        
        return matrix;
    }

}