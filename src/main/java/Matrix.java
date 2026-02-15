


public class Matrix {
    private final short[][] data;
    private final int rows;
    private final int cols;

    public Matrix(int rows, int cols, int lowerLimit, int  upperLimit) {
        this.rows = rows;
        this.cols = cols;
        this.data = new short[rows][cols];
        java.util.Random rnd = new java.util.Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.data[i][j] = (short) rnd.nextInt(lowerLimit, upperLimit + 1);
            }
        }
    }

    public Matrix multiply(int scalar) {
        short[][] resultData = new short[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultData[i][j] = (short) (this.data[i][j] * scalar);
            }
        }
        return new Matrix(resultData);
    }

    private Matrix(short[][] data) {
        this.data = data;
        this.rows = data.length;
        this.cols = data[0].length;
    }

    public int calculateSumMinRow(){
        short sum = 0;
        for (short[] row : data) {
            short min = row[0];
            for (short val : row) if (val < min) min = val;
            sum += min;
        }
        return sum;
    }

    @Override
    public String toString() {
        String result = "";
    
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result = result + data[i][j] + "\t";
            }
            result = result + "\n";
        }
    
    return result;
}
}

