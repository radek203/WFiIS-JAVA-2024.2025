package lab08;

public enum Funkcja {
    SIN {
        @Override
        public double wartosc(double x) {
            return Math.sin(x);
        }
    },
    ARCSIN {
        @Override
        public double wartosc(double x) {
            if (x < -1 || x > 1) {
                throw new BladFunkcji("Argument spoza dziedziny funkcji arcsin");
            }
            return Math.asin(x);
        }
    },
    LN {
        @Override
        public double wartosc(double x) {
            if (x <= 0) {
                throw new BladFunkcji("Argument spoza dziedziny funkcji ln");
            }
            return Math.log(x);
        }
    };

    public abstract double wartosc(double x);

    static class BladFunkcji extends ArithmeticException {
        public BladFunkcji(String message) {
            super(message);
        }
    }

    public interface Funkcja1 {
        double wartosc(double x);
    }
}
