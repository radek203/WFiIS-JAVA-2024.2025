package lab04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lab04 {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("tekst.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(line);
        }

        for (int i = 0; i < Math.min(3, lines.size()); i++) {
            System.out.println(lines.get(i));
        }

        for (int i = Math.max(0, lines.size() - 3); i < lines.size(); i++) {
            System.out.println(lines.get(i));
        }

        StringBuilder sb = new StringBuilder();
        lines.forEach(l -> {
            sb.append(l.replace(",", "").replace("-", "").replace(".", ""));
            sb.append(" ");
        });

        String[] slowa = sb.toString().split(" ");
        System.out.println(Arrays.toString(slowa));
        String[] copy = new String[slowa.length];
        System.arraycopy(slowa, 0, copy, 0, slowa.length);
        long time = System.currentTimeMillis();
        Arrays.sort(slowa);
        System.out.println("Sortowanie zwykle: " + (System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        Arrays.parallelSort(copy);
        System.out.println("Sortowanie parallel: " + (System.currentTimeMillis() - time));
        System.out.println(Arrays.toString(slowa));
        System.out.println(Arrays.toString(copy));
        System.out.println("Ktory element tablicy chcesz:");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int number = Integer.parseInt(num);
        System.out.println("Element tablicy: " + copy[number]);

        Map<String, Integer> ilosc = new HashMap<>();
        for (String slowo : copy) {
            if (ilosc.containsKey(slowo)) {
                ilosc.replace(slowo, ilosc.get(slowo) + 1);
            } else {
                ilosc.put(slowo, 1);
            }
        }

        System.out.println("Ile najczesciej wystepujacych slow chcesz:");
        num = scanner.nextLine();
        scanner.close();
        number = Integer.parseInt(num);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(ilosc.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        for (int i = 0; i < Math.min(number, list.size()); i++) {
            System.out.println(list.get(i));
        }
    }

}
