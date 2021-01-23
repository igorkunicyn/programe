package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;

    public Server() {
        clients = new CopyOnWriteArrayList<>();
        authService = new SimpleAuthService();

        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void broadcastMsgAll(ClientHandler clientHandler, String msg){
        String message = String.format("[ %s ]: %s", clientHandler.getNickname(), msg);
        String nickname = clientHandler.getNickname();
        String messageself = String.format("%s :[ ALL ]",msg);
        clientHandler.sendMsg(messageself);
        for (ClientHandler c : clients) {
            if (!c.getNickname().equals(nickname)) {
                c.sendMsg(message);

            }
        }
    }

    public void broadcastMsg(ClientHandler clientHandler, String nick,String msg){
        String message = String.format("[ %s ]: %s", clientHandler.getNickname(), msg);
        String messageself = String.format("%s : [ %s ]", msg,nick);
        clientHandler.sendMsg(messageself);
        for (ClientHandler c : clients) {
                    if (c.getNickname().equals(nick)){
                c.sendMsg(message);
            }
        }
    }

    void subscribe(ClientHandler clientHandler){
        clients.add(clientHandler);
    }

    void unsubscribe(ClientHandler clientHandler){
        clients.remove(clientHandler);
    }

    public AuthService getAuthService() {
        return authService;
    }
}
