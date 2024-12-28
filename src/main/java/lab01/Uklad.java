package lab01;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.function.Function;

public class Uklad {

    private final double a;
    private final double b;
    private final double c;

    private final double d;
    private final double e;
    private final double f;

    public Uklad(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public void printUklad() {
        System.out.println("lab01.Uklad rownan:");
        System.out.println(a + "x + " + b + "y = " + c);
        System.out.println(d + "x + " + e + "y = " + f);
    }

    public double wyznacznikGlowny() {
        return a * e - b * d;
    }

    public double wyznacznikX() {
        return c * e - b * f;
    }

    public double wyznacznikY() {
        return a * f - c * d;
    }

    public double[] rozwiazUklad() {
        double W = wyznacznikGlowny();

        if (W == 0) {
            return null;
        }

        double[] result = new double[2];
        double Wx = wyznacznikX();
        double Wy = wyznacznikY();

        result[0] = (Wx / W);
        result[1] = (Wy / W);

        return result;
    }

    private double wynikFun1(double x) {
        return (c - a * x) / b;
    }

    private double wynikFun2(double x) {
        return (f - d * x) / e;
    }

    public void saveImage() {
        int width = 1000;  // Szerokość obrazu
        int height = 1000; // Wysokość obrazu
        int scale = 100;   // Skala przeliczeniowa do współrzędnych na płótnie

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();

        // Rysowanie osi X i Y
        g.setColor(Color.ORANGE);
        g.drawLine(0, height / 2, width, height / 2); // Oś X
        g.drawLine(width / 2, 0, width / 2, height);  // Oś Y

        // Rysowanie prostych dla obu równań
        g.setColor(Color.WHITE);
        drawEquationLine(g, -5, 5, scale, width, height, this::wynikFun1); // Linia dla pierwszego równania
        drawEquationLine(g, -5, 5, scale, width, height, this::wynikFun2); // Linia dla drugiego równania

        // Rysowanie punktu przecięcia (jeśli istnieje)
        double[] result = rozwiazUklad();
        if (result != null) {
            g.setColor(Color.RED);
            // Przeskalowanie i przesunięcie punktu przecięcia
            int x = (int) (result[0] * scale + width / 2);
            int y = (int) (height / 2 - result[1] * scale);
            g.fillOval(x - 5, y - 5, 10, 10); // Punkt przecięcia (z centrowaniem -5)
        }

        // Zapis obrazu do pliku
        File outputfile = new File("saved.png");
        try {
            outputfile.createNewFile();
            ImageIO.write(bi, "png", outputfile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Pomocnicza metoda do rysowania linii dla równań
    private void drawEquationLine(Graphics g, double xStart, double xEnd, int scale, int width, int height, Function<Double, Double> func) {
        double yStart = func.apply(xStart);
        double yEnd = func.apply(xEnd);

        int x1 = (int) (xStart * scale + width / 2); //0
        int y1 = (int) (height / 2 - yStart * scale);
        int x2 = (int) (xEnd * scale + width / 2); //1000
        int y2 = (int) (height / 2 - yEnd * scale);
        g.drawLine(x1, y1, x2, y2);  // Rysowanie prostej
    }

}
