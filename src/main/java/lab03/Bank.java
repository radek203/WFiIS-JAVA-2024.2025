package lab03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {

    private final List<Konto> konta = new ArrayList<>();

    /**
     * Tworzy nowe konto w banku jezeli nie istnieje o danym numerze
     *
     * @param numer numer konta
     */
    public void utworzKonto(String numer) {
        Optional<Konto> konto = konta.stream().filter(k -> k.getNumer().equals(numer)).findFirst();
        if (konto.isEmpty()) {
            Konto k = new Konto(numer, new Kwota(0, 0));
            konta.add(k);
        }
    }

    /**
     * Wplaca dana kwote na konto jezeli istnieje
     *
     * @param numer numer konta do wplaty
     * @param kwota kwota do wplacenia
     */
    public void wplataNaKonto(String numer, Kwota kwota) {
        Optional<Konto> konto = konta.stream().filter(k -> k.getNumer().equals(numer)).findFirst();
        if (konto.isPresent()) {
            Konto k = konto.get();
            k.setStan(Kwota.dodaj(k.getStan(), kwota));
        }
    }

    /**
     * Wyplaca dana kwote z konta jezeli istnieje
     *
     * @param numer numer konta do wyplaty
     * @param kwota kwota do wyplacenia
     */
    public void wyplataZKonta(String numer, Kwota kwota) {
        Optional<Konto> konto = konta.stream().filter(k -> k.getNumer().equals(numer)).findFirst();
        if (konto.isPresent()) {
            Konto k = konto.get();
            k.setStan(Kwota.odejmij(k.getStan(), kwota));
        }
    }

    /**
     * Zwraca stan konta o danym numerze
     *
     * @param numer numer konta do sprawdzenia
     * @return jezeli konto istnieje zwraca jego stan
     */
    public Kwota stanKonta(String numer) {
        Optional<Konto> konto = konta.stream().filter(k -> k.getNumer().equals(numer)).findFirst();
        if (konto.isPresent()) {
            return konto.get().getStan();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Konto konto : konta) {
            sb.append(konto);
            sb.append(" ; ");
        }
        return sb.toString();
    }

}
