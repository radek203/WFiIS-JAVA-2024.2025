package lab07;

public class Pociag extends Statek implements Pasazerski, Silnikowy {

    public Pociag() {
        super("");
    }

    @Override
    public String toString() {
        return "Pociag[" + name + "]";
    }

    @Override
    public void zwiekszMoc(int moc) {

    }

    int cenaBiletu = 0;

    @Override
    public void ustawCeneBiletu(int cena) {
        cenaBiletu = cena;
    }

    @Override
    public Bilet bilet() {
        return new Bilet(cenaBiletu);
    }
}
