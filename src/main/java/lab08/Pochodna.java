package lab08;

public class Pochodna {

    Funkcja.Funkcja1 funkcja;
    double h = 0.0001;

    public Pochodna(Funkcja funkcja) {
        this.funkcja = funkcja::wartosc;
    }

    public Pochodna(Funkcja.Funkcja1 funkcja) {
        this.funkcja = funkcja;
    }

    private double n1(double x) {
        return (funkcja.wartosc(x + h) - funkcja.wartosc(x - h)) / (2 * h);
    }

    private double n2(double x) {
        return (funkcja.wartosc(x + h) - 2 * funkcja.wartosc(x) + funkcja.wartosc(x - h)) / (h * h);
    }

    public double wartosc(int n, double x) {
        if (n == 1) {
            return n1(x);
        }
        if (n == 2) {
            return n2(x);
        }
        throw new BladPochodnej("Nieobsługiwany numer pochodnej");
    }

    public double[] wartosc(int n, double... x) {
        double[] result = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            result[i] = wartosc(n, x[i]);
        }
        return result;
    }

    public void setH(double h) {
        this.h = h;
    }

    static class BladPochodnej extends ArithmeticException {
        public BladPochodnej(String message) {
            super(message);
        }
    }
}
