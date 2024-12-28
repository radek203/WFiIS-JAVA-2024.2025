package lab07;

public class Zaglowiec extends Statek implements Pasazerski {

    public Zaglowiec() {
        super("");
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
