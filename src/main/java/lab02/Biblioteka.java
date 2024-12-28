package lab02;

public class Biblioteka {

    private Node root = null;

    public void dodaj(Ksiazka k) {
        if (root == null) {
            root = new Node(k);
            return;
        }
        if (wyszukajID(k.getID()) != null) {
            System.out.println("lab02.Ksiazka o podanym ID juz istnieje");
            return;
        }
        dodajKsiazke(k, root);
    }

    private void dodajKsiazke(Ksiazka k, Node node) {
        if (k.getID() < node.getKsiazka().getID()) {
            if (node.getLeftNode() == null) {
                node.addLeftNode(k);
            } else {
                dodajKsiazke(k, node.getLeftNode());
            }
        } else {
            if (node.getRightNode() == null) {
                node.addRightNode(k);
            } else {
                dodajKsiazke(k, node.getRightNode());
            }
        }
    }

    public Ksiazka wyszukajID(int ID) {
        if (root == null) {
            return null;
        }
        long start = System.currentTimeMillis();
        Node n = root;
        while (n != null && (n.getKsiazka().getID() != ID)) {
            n = (ID < n.getKsiazka().getID()) ? n.getLeftNode() : n.getRightNode();
        }
        long stop = System.currentTimeMillis();
        System.out.println("Czas wyszukiwania (ID): " + (stop - start) + " ms");
        return n == null ? null : n.getKsiazka();
    }

    public Ksiazka wyszukajTytul(String wartosc) {
        long start = System.currentTimeMillis();
        Ksiazka k = wyszukajTytulKsiazki(wartosc, root);
        long stop = System.currentTimeMillis();
        System.out.println("Czas wyszukiwania (Tytul): " + (stop - start) + " ms");
        return k;
    }

    private Ksiazka wyszukajTytulKsiazki(String wartosc, Node n) {
        if (n == null) {
            return null;
        }
        if (n.getKsiazka().getTytul().equals(wartosc)) {
            return n.getKsiazka();
        }
        Ksiazka k = wyszukajTytulKsiazki(wartosc, n.getLeftNode());
        if (k != null) {
            return k;
        }
        return wyszukajTytulKsiazki(wartosc, n.getRightNode());
    }

    public void wypiszKsiazki() {
        System.out.println();
        System.out.println();
        wypiszKsiazki(root, 1);
        System.out.println();
    }

    private void wypiszKsiazki(Node node, int poziom) {
        if (node == null) {
            return;
        }
        node.getKsiazka().print();
        if (node.getLeftNode() != null) {
            System.out.println();
        }
        for (int i = 0; i < poziom; i++) {
            System.out.print("  ");
        }
        wypiszKsiazki(node.getLeftNode(), poziom + 1);
        if (node.getRightNode() != null) {
            System.out.println();
        }
        for (int i = 0; i < poziom; i++) {
            System.out.print("  ");
        }
        wypiszKsiazki(node.getRightNode(), poziom + 1);
    }

}

class Node {

    private final Ksiazka ksiazka;
    private Node leftNode = null;
    private Node rightNode = null;

    public Node(Ksiazka ksiazka) {
        this.ksiazka = ksiazka;
    }

    public Ksiazka getKsiazka() {
        return ksiazka;
    }

    public void addLeftNode(Ksiazka k) {
        this.leftNode = new Node(k);
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void addRightNode(Ksiazka k) {
        this.rightNode = new Node(k);
    }

    public Node getRightNode() {
        return rightNode;
    }

}