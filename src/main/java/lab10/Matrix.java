package lab10;

import java.util.Random;

public class Matrix {

    private final int n;
    private final double[][] matrix;

    public Matrix(int n) {
        final Random random = new Random();
        this.n = n;
        matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }
    }

    public Matrix matrixMultiplication(Matrix m) {
        if (n != m.n) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        Matrix result = new Matrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.matrix[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return result;
    }

}
