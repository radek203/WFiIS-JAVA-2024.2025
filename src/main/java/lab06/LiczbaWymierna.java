package lab06;

public class LiczbaWymierna extends Liczba {

    private final double L;
    private final double M;

    public LiczbaWymierna(double L, double M) {
        this.L = L;
        this.M = M;
    }

    @Override
    public String toString() {
        return L + "/" + M;
    }

    @Override
    public Double toDouble() {
        return L / M;
    }
}
