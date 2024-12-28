package lab09;

public class Dane implements Cloneable {

    private int x;
    private boolean y = false;

    public Dane(int x) {
        this.x = x;
    }

    public void set(int x) {
        this.x = x;
    }

    public int wynik(int x) throws UjemnyParametrException, ZaMaloDanychException {
        if (this.x < 10) {
            throw new ZaMaloDanychException("n=" + this.x);
        }
        if (x < 0) {
            throw new UjemnyParametrException();
        }
        return x;
    }

    public int innyWynik(int x) throws ZaMaloDanychException, UjemnyParametrException {
        if (y) {
            if (this.x < 10) {
                throw new ZaMaloDanychException("ZaMaloDanychException: n=" + this.x);
            }
        }
        y = true;
        throw new RuntimeException();
    }

    @Override
    public String toString() {
        return String.valueOf(x);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dane) {
            return x == ((Dane) obj).x;
        }
        return false;
    }

    @Override
    public Object clone() {
        return new Dane(x);
    }

    @Override
    public int hashCode() {
        return x;
    }

}
