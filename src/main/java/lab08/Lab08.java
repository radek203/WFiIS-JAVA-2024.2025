package lab08;

import java.util.Arrays;

public class Lab08 {

    public static void main(String[] args) {
        System.out.println("SIN(2) = " + Funkcja.SIN.wartosc(2));
        System.out.println("ARCSIN(0.5) = " + Funkcja.ARCSIN.wartosc(0.5));
        System.out.println("LN(2) = " + Funkcja.LN.wartosc(2));

        try {
            System.out.println("ARCSIN(2) = " + Funkcja.ARCSIN.wartosc(2));
        } catch (Funkcja.BladFunkcji e) {
            System.out.println(e.getMessage());
        }

        Pochodna pochodna = new Pochodna(Funkcja.SIN);
        System.out.println("Pochodna 1. rzędu SIN(2) = " + pochodna.wartosc(1, 2));

        System.out.println("Pochodna 1. rzędu SIN(2,3,4) = " + Arrays.toString(pochodna.wartosc(1, 2, 3, 4)));

        Pochodna pochodna1 = new Pochodna(Funkcja.SIN::wartosc);
        System.out.println("Pochodna 1. rzędu SIN(2) = " + pochodna1.wartosc(1, 2));

        Pochodna pochodna2 = new Pochodna(Math::cos);
        System.out.println("Pochodna 1. rzędu COS(2) = " + pochodna2.wartosc(1, 2));
    }

}
