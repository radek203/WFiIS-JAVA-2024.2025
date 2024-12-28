package lab10;

import java.util.Random;

public class MatrixD {

    private final int n;
    private final Double[][] matrix;

    public MatrixD(int n) {
        final Random random = new Random();
        this.n = n;
        matrix = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextDouble();
            }
        }
    }

    public MatrixD matrixMultiplication(MatrixD m) {
        if (n != m.n) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixD result = new MatrixD(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.matrix[i][j] = 0.0;
                for (int k = 0; k < n; k++) {
                    result.matrix[i][j] += matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return result;
    }

}
