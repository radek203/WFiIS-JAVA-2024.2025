package lab06;

public class Lista<T> {

    protected LNode<T> root = null;
    protected int size = 0;

    public Lista() {

    }

    public void add(T element) {
        size++;
        if (root == null) {
            root = new LNode<>(element);
            return;
        }
        root.addNext(element);
    }

    public T getFirst() {
        return getElement(0);
    }

    public T getLast() {
        return getElement(size - 1);
    }

    public T getElement(int index) {
        if (root == null || index < 0 || index >= size) {
            return null;
        }
        LNode<T> current = root;
        int i = 0;
        while (i != index && current.getNext() != null) {
            current = current.getNext();
            i++;
        }
        return current.getElement();
    }

    public void removeItem(int index) {
        if (root == null || index < 0 || index >= size) {
            return;
        }
        LNode<T> before = null;
        LNode<T> current = root;
        int i = 0;
        while (i != index && current.getNext() != null) {
            before = current;
            current = current.getNext();
            i++;
        }
        if (before != null && current.getNext() != null) {
            before.setNext(current.getNext());
        }
        size--;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public void print() {
        System.out.println(this);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lab06.Lista: ");
        LNode<T> current = root;
        while (current != null) {
            sb.append(current.getElement());
            sb.append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }
}

class LNode<T> {

    protected T element;
    protected LNode<T> next = null;

    public LNode(T element) {
        this.element = element;
    }

    public void addNext(T element) {
        if (next == null) {
            next = new LNode<>(element);
        } else {
            next.addNext(element);
        }
    }

    public void setNext(LNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public LNode<T> getNext() {
        return next;
    }

}