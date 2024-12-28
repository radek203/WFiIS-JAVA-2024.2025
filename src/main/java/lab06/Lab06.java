package lab06;

public class Lab06 {

    public static void main(String[] args) {
        Lista<Double> lista = new Lista<>();
        lista.add(1.0);
        lista.add(2.0);
        lista.add(1.2);
        lista.add(21.37);

        lista.print();
        System.out.println("First: " + lista.getFirst());
        System.out.println("Second: " + lista.getElement(1));
        System.out.println("Last: " + lista.getLast());
        System.out.println("Size: " + lista.getSize());

        lista.removeItem(2);
        lista.print();

        lista.clear();
        lista.print();

        ListaLiczb listaLiczb = new ListaLiczb();
        listaLiczb.add(new LiczbaWymierna(2, 4));
        listaLiczb.add(new LiczbaWymierna(1, 3));
        listaLiczb.add(new LiczbaWymierna(4, 3));

        listaLiczb.print();
        System.out.println("Minimum: " + listaLiczb.getMin());
        System.out.println("Maksimum: " + listaLiczb.getMax());
        System.out.println("Srednia: " + listaLiczb.avg());

        listaLiczb.sort();
        listaLiczb.print();
    }

}
