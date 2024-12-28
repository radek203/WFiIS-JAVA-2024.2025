package lab10;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class Lab10 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            Matrix matrix1 = new Matrix(3);
            Matrix matrix2 = new Matrix(3);
            Matrix matrix3 = matrix1.matrixMultiplication(matrix2);
        }

        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            MatrixD matrixD1 = new MatrixD(3);
            MatrixD matrixD2 = new MatrixD(3);
            MatrixD matrixD3 = matrixD1.matrixMultiplication(matrixD2);
        }

        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            MatrixT<Double> matrixT4 = new MatrixT<Double>(3);
            MatrixT<Double> matrixT5 = new MatrixT<Double>(3);
            MatrixT<Double> matrixT6 = matrixT4.matrixMultiplication(matrixT5);
        }

        System.out.println(System.currentTimeMillis() - start);

        File myFolder = new File("src/lab10");
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{myFolder.toURI().toURL()}, Thread.currentThread().getContextClassLoader());
            Class<?> myClass = Class.forName("Lab10A", true, classLoader);
            Object obj = myClass.getConstructor(int.class, String.class).newInstance(3, "Matrix");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
