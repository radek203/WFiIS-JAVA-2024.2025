package lab01;

public class Lab01 {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Uklad uklad = new Uklad(1, 2, 3, 4, 5, 6);
        uklad.printUklad();
        double[] result = uklad.rozwiazUklad();
        System.out.println("Rozwiazanie ukladu:");
        if (result == null) {
            System.out.println("Brak rozwiazan");
        } else {
            System.out.println("x = " + result[0]);
            System.out.println("y = " + result[1]);
            uklad.saveImage();
        }
    }
}
