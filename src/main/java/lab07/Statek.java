package lab07;

public class Statek {

    protected String name;

    public Statek(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Statek[" + name + "]";
    }

}
