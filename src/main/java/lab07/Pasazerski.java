package lab07;

public interface Pasazerski {

    void ustawCeneBiletu(int cena);

    Bilet bilet();

    class Bilet {

        private final int cena;

        public Bilet(int cena) {
            this.cena = cena;
        }

        public int cena() {
            return cena;
        }

    }

}
