package lab14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocketServer {

    private static class UserConnection {
        PrintWriter out;
        BufferedReader in;
        String name = "";

        public UserConnection(PrintWriter out, BufferedReader in) {
            this.out = out;
            this.in = in;
        }
    }

    private ServerSocket serverSocket;
    private final List<UserConnection> connections = new ArrayList<>();

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        Thread thread = new Thread(() -> {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String messageToSend = scanner.nextLine();
                if (messageToSend.equals("EXIT")) {
                    stop();
                    System.exit(0);
                    return;
                }
                for (UserConnection connection : connections) {
                    connection.out.println("HELLO_SERVER_MESSAGE " + messageToSend);
                }
            }
        });
        thread.start();
        while (true) {
            try {
                holdConnection(serverSocket.accept());
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }

    public void holdConnection(Socket clientSocket) throws IOException {
        System.out.println("[connection from " + clientSocket.getInetAddress().getHostAddress() + "]");
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        UserConnection userConnection = new UserConnection(out, in);
        connections.add(userConnection);
        Thread thread = new Thread(() -> {
            String message;
            while (true) {
                try {
                    if ((message = in.readLine()) == null) break;
                } catch (IOException e) {
                    break;
                }
                if (!message.startsWith("HELLO")) {
                    out.println("MESSAGE_ERROR");
                    stop(in, out, clientSocket);
                    break;
                }
                if (message.startsWith("HELLO_FROM_CLIENT")) {
                    userConnection.name = message.split(" ")[1];
                } else {
                    System.out.println("@" + userConnection.name + " message: " + message);
                }
                out.println("HELLO_FROM_SERVER SERVER_NAME");
            }
        });
        thread.start();
    }

    public void stop(BufferedReader in, PrintWriter out, Socket clientSocket) {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(4321);
        server.stop();
    }
}
