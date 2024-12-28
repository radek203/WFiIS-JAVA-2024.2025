package lab10;

import java.util.Random;

public class MatrixT<T extends Number> {

    private final int n;
    private final T[][] matrix;

    public MatrixT(int n) {
        final Random random = new Random();
        this.n = n;
        this.matrix = (T[][]) new Number[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.matrix[i][j] = (T) Double.valueOf(random.nextDouble());
            }
        }
    }

    public MatrixT<T> matrixMultiplication(MatrixT<T> m) {
        if (n != m.n) {
            throw new IllegalArgumentException("Matrix dimensions must agree.");
        }
        MatrixT<T> result = new MatrixT<T>(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += matrix[i][k].doubleValue() * m.matrix[k][j].doubleValue();
                }
                result.matrix[i][j] = (T) Double.valueOf(sum);
            }
        }
        return result;
    }

}
