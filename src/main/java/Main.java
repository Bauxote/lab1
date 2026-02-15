import java.util.InputMismatchException;
import java.util.Scanner;

public class  Main  {
    public static void main(String[] args)  {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rows for the matrix: ");
            int rows = scanner.nextInt();
            
            System.out.print("Enter the number of columns for the matrix: ");
            int cols = scanner.nextInt();

            System.out.print("Enter the enter the lower limit the matrix(from -32768 to 32767): ");
            short lower = scanner.nextShort();

            System.out.print("Enter the enter the upper limit the matrix(from -32768 to 32767): ");
            short upper = scanner.nextShort();

            if (lower >= upper) throw new IllegalArgumentException("Upper limit has to be higher than lower one");

            Matrix matrixB = new Matrix(rows, cols, lower, upper);
            System.out.println("Matrix B: \n" + matrixB);

            System.out.println("Enter the multiplier for matrix B to be multiplied: ");
            int multiplier = scanner.nextInt();
            Matrix matrixC = matrixB.multiply(multiplier);

            System.out.println("Matrix C: \n" + matrixC);
            System.out.println("Sum of mins in each row: " + matrixC.calculateSumMinRow());
        }
        catch (InputMismatchException e) {
            System.err.println("Please input a valid integer");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } 
}
}