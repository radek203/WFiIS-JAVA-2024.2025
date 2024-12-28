package lab07;

public class Okret extends UczestnikBitwy implements Silnikowy {

    public Okret(String name) {
        super(name);
    }

    @Override
    public String toString() {
        if (zatopiony) {
            return "Okret[" + name + " - wrak]";
        }
        return "Okret[" + name + "]";
    }

    @Override
    public void zwiekszMoc(int moc) {

    }
}