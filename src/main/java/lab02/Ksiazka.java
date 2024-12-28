package lab02;

public class Ksiazka {

    private static int counter = 0;

    private final String tytul;
    private final int ID;

    public Ksiazka(String tytul, int ID) {
        this.tytul = tytul;
        this.ID = ID;
        counter++;
    }

    public String getTytul() {
        return tytul;
    }

    public int getID() {
        return ID;
    }

    public void print() {
        System.out.print("ID: " + ID + ", Tytul: " + tytul);
    }

    public static int getCounter() {
        return counter;
    }

}
