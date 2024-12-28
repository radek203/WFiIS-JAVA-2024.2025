package lab03;

public class Kwota {

    private int zl;
    private int gr;

    public Kwota(int zl, int gr) {
        this.zl = zl;
        this.gr = gr;
    }

    public Kwota(Kwota kwota) {
        this.zl = kwota.zl;
        this.gr = kwota.gr;
    }

    public void set(int zl, int gr) {
        this.zl = zl;
        this.gr = gr;
    }

    @Override
    public String toString() {
        return zl + "zl " + gr + "gr";
    }

    public static Kwota dodaj(Kwota k1, Kwota k2) {
        int zl = k1.zl + k2.zl;
        int gr = k1.gr + k2.gr;
        if (gr >= 100) {
            zl++;
            gr -= 100;
        }
        return new Kwota(zl, gr);
    }

    public static Kwota odejmij(Kwota k1, Kwota k2) {
        int zl = k1.zl - k2.zl;
        int gr = k1.gr - k2.gr;
        if (gr < 0) {
            zl--;
            gr += 100;
        }
        return new Kwota(zl, gr);
    }

}
