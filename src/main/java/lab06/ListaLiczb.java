package lab06;

import java.util.Arrays;
import java.util.Comparator;

public class ListaLiczb extends Lista<Liczba> {

    public Liczba getMin() {
        if (root == null) {
            return null;
        }
        Liczba min = root.getElement();
        LNode<Liczba> current = root;
        while (current != null && current.getNext() != null) {
            if (min.toDouble() > current.getNext().getElement().toDouble()) {
                min = current.getElement();
            }
            current = current.getNext();
        }
        return min;
    }

    public Liczba getMax() {
        if (root == null) {
            return null;
        }
        Liczba max = root.getElement();
        LNode<Liczba> current = root;
        while (current != null && current.getNext() != null) {
            if (max.toDouble() < current.getNext().getElement().toDouble()) {
                max = current.getElement();
            }
            current = current.getNext();
        }
        return max;
    }

    public double[] getWartosci() {
        if (root == null) {
            return null;
        }
        double[] wartosci = new double[size];
        LNode<Liczba> elem = root;

        int index = 0;
        while (elem != null) {
            wartosci[index] = elem.getElement().toDouble();
            elem = elem.getNext();
            index++;
        }
        return wartosci;
    }

    public double avg() {
        if (root == null) {
            return 0;
        }
        return Arrays.stream(getWartosci()).sum() / size;
    }

    public void sort() {
        if (root == null) {
            return;
        }
        Liczba[] wartosci = new Liczba[size];
        LNode<Liczba> elem = root;
        int index = 0;
        while (elem != null) {
            wartosci[index] = elem.getElement();
            elem = elem.getNext();
            index++;
        }
        Arrays.sort(wartosci, Comparator.comparingDouble(Liczba::toDouble));
        root = new LNode<>(wartosci[0]);
        elem = root;
        for (int i = 1; i < wartosci.length; i++) {
            elem.setNext(new LNode<>(wartosci[i]));
            elem = elem.getNext();
        }
    }

}
