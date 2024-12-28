package lab07;

public abstract class UczestnikBitwy extends Statek {

    protected int ammo = 100;
    protected boolean zatopiony = false;

    public UczestnikBitwy(String name) {
        super(name);
    }

    public int amunicja() {
        return ammo;
    }

    public void strzelaj() {
        ammo -= 1;
    }

    public static void zatapia(UczestnikBitwy uczestnik) {
        uczestnik.zatopiony = true;
        uczestnik.ammo = 0;
    }


}
