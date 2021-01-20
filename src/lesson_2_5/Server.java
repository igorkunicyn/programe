package lesson_2_5;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.*;

public class Server {

    static ServerSocket server;
    static Socket socket;
    static final int PORT = 8189;

    public Server() {
        try {
            server = new ServerSocket(PORT);
            out.println("Server started");
            socket = server.accept();
            out.println("Client connected");
            Scanner scanner = new Scanner(System.in);
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter out1 = new PrintWriter(socket.getOutputStream(), true);
            Thread thread1 = new Thread(() -> {
                while (true){
                    String str1 = sc.nextLine();
                    if (str1.equals("/end")) {
                        System.out.println("client disconnected");
                        break;
                    }
                    System.out.println("Client: " + str1);
                    }
                });
            Thread thread2 = new Thread(() -> {
                while (true){
                    String str1 = scanner.nextLine();
                        if (str1.equals("/end")) {
                            out.println("server disconnected");
                            break;
                        }
                    out1.println("Server: " + str1);
                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}