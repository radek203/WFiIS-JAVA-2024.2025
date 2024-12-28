package lab03;

public class Konto {

    private final String numer;
    private Kwota kwota;

    public Konto(String numer, Kwota kwota) {
        this.numer = numer;
        this.kwota = new Kwota(kwota);
    }

    public String getNumer() {
        return numer;
    }

    public Kwota getStan() {
        return new Kwota(kwota);
    }

    public void setStan(Kwota kwota) {
        this.kwota = kwota;
    }

    @Override
    public String toString() {
        return "[" + numer + "] " + kwota;
    }

}
