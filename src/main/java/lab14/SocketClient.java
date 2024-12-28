package lab14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    private String name;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String name, String ip, int port) throws IOException {
        this.name = name;
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String getName() {
        return name;
    }

    public void readLines() {
        Thread thread = new Thread(() -> {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    if (!message.startsWith("HELLO")) {
                        out.println("MESSAGE_ERROR");
                        break;
                    }
                    if (message.startsWith("HELLO_FROM_SERVER")) {
                        System.out.println("Server response: " + message);
                    } else {
                        System.out.println("Server message: " + message);
                    }
                }
            } catch (IOException e) {
            }
        });
        thread.start();
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
