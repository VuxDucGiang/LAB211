package Week2.Matrix;

public class Matrix {

    private int rows;
    private int cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[][] getData() {
        return data;
    }

    
    public void setValue(int row, int col, double value) {
        this.data[row][col] = value;
    }

 
    public Matrix additionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.getRows() || this.cols != matrix2.getCols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] + matrix2.getData()[i][j]);
            }
        }
        return result;
    }

    public Matrix subtractionMatrix(Matrix matrix2) {
        if (this.rows != matrix2.getRows() || this.cols != matrix2.getCols()) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for subtraction.");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.data[i][j] - matrix2.getData()[i][j]);
            }
        }
        return result;
    }

    public Matrix multiplicationMatrix(Matrix matrix2) {
        if (this.cols != matrix2.getRows()) {
            throw new IllegalArgumentException("Number of columns of the first matrix must equal number of rows of the second matrix.");
        }
        Matrix result = new Matrix(this.rows, matrix2.getCols());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix2.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < this.cols; k++) {
                    sum += this.data[i][k] * matrix2.getData()[k][j];
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
