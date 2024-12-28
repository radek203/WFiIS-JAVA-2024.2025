package lab06;

public class LiczbaOdZeraDoJeden extends Liczba {

    private final double value;

    public LiczbaOdZeraDoJeden(double value) {
        if (value < 0.0 || value > 1.0) {
            throw new IllegalArgumentException("Moze przyjmowac liczby z zakresu [0,1]");
        }
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Double toDouble() {
        return value;
    }
}
