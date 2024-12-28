package lab12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Lab12 {

    public static void main(String[] args) {
        List<Punkt> points = new ArrayList<>();
        int ignoredLines = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith(".")) {
                    break;
                }
                if (line.startsWith("#")) {
                    ignoredLines++;
                    continue;
                }
                String[] parts = line.split(" ");
                if (parts.length < 2) {
                    ignoredLines++;
                    continue;
                }
                try {
                    double x = Double.parseDouble(parts[0]);
                    double y = Double.parseDouble(parts[1]);
                    points.add(new Punkt(x, y));
                } catch (NumberFormatException e) {
                    ignoredLines++;
                }
            }
        }
        for (Punkt p : points) {
            System.out.println("x: " + p.getX() + ", y: " + p.getY());
        }
        System.out.println("Ignored lines: " + ignoredLines);
        points.sort(Comparator.comparingDouble(Punkt::getX));
        points.stream().max(Comparator.comparingDouble(Punkt::getX)).ifPresent(p -> System.out.println("Point with the highest x: x: " + p.getX() + ", y: " + p.getY()));
        points.stream().max(Comparator.comparingDouble(Punkt::getY)).ifPresent(p -> System.out.println("Point with the highest y: x: " + p.getX() + ", y: " + p.getY()));
        points.stream().min(Comparator.comparingDouble(Punkt::getX)).ifPresent(p -> System.out.println("Point with the lowest x: x: " + p.getX() + ", y: " + p.getY()));
        points.stream().min(Comparator.comparingDouble(Punkt::getY)).ifPresent(p -> System.out.println("Point with the lowest y: x: " + p.getX() + ", y: " + p.getY()));
    }

}
