package lab02;

public class Lab02 {

    public static void main(String[] args) {
        Ksiazka k1 = new Ksiazka("Ksiazka1", 1);
        Ksiazka k2 = new Ksiazka("Ksiazka2", 2);
        Ksiazka k3 = new Ksiazka("Ksiazka3", 3);
        Ksiazka k4 = new Ksiazka("Ksiazka4", 4);
        Ksiazka k5 = new Ksiazka("Ksiazka5", 5);
        Ksiazka k6 = new Ksiazka("Ksiazka6", 6);
        Ksiazka k0 = new Ksiazka("Ksiazka0", 0);

        Biblioteka b = new Biblioteka();
        b.dodaj(k1);
        b.dodaj(k4);
        b.dodaj(k3);
        b.dodaj(k2);
        b.dodaj(k6);
        b.dodaj(k5);
        b.dodaj(k0);
        //b.dodaj(k5);

        b.wyszukajID(3).print();
        b.wypiszKsiazki();
    }

}
