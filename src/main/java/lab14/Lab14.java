package lab14;

import java.util.Scanner;

public class Lab14 {

    public static void main(String[] args) {
        SocketClient client = new SocketClient();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the server IP address: ");
            String ip = scanner.nextLine();
            System.out.println("Podaj nazwę klienta: ");
            String name = scanner.nextLine();
            client.startConnection(name, ip, 4321);
            client.readLines();
            client.sendMessage("HELLO_FROM_CLIENT " + client.getName());
            while (true) {
                String message = scanner.nextLine();
                if (message.equals("EXIT")) {
                    break;
                }
                client.sendMessage("HELLO_MESSAGE " + message);
            }
            client.stopConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
