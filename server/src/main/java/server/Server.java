package server;

import Commands.Command;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Server {
    private ServerSocket server;
    private Socket socket;
    private final int PORT = 8189;
    private List<ClientHandler> clients;
    private AuthService authService;
    private static final Logger logger = Logger.getLogger(Server.class.getName());

    public Logger getLogger() {
        return logger;
    }

    public Server() {
        clients = new CopyOnWriteArrayList<>();
//        authService = new SimpleAuthService();
        //==============//
        if (!SQLHandler.connect()) {
            throw new RuntimeException("Не удалось подключиться к БД");
        }
        authService = new DBAuthServise();
//        logger.setUseParentHandlers(false);
//==============//
        try {
            LogManager manager = LogManager.getLogManager();
            manager.readConfiguration(new FileInputStream("server/logging.properties"));
            server = new ServerSocket(PORT);
//            System.out.println("Server started");
            logger.info("Server started");

            while (true) {
                socket = server.accept();
//                System.out.println("Client connected");
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            logger.severe("Произошла ошибка "+e.getMessage());
        } finally {
            SQLHandler.disconnect();
            try {
                server.close();
            } catch (IOException e) {
//                e.printStackTrace();
                logger.severe("Произошла ошибка "+e.getMessage());
            }
        }
    }

    public void broadcastMsg(ClientHandler clientHandler, String msg) {
        String message = String.format("[ %s ]: %s", clientHandler.getNickname(), msg);

        //==============//
        SQLHandler.addMessage(clientHandler.getNickname(), "all", msg, "once upon a time");
        //==============//

        for (ClientHandler c : clients) {
            c.sendMsg(message);
        }
    }

    public void privateMsg(ClientHandler sender, String receiver, String msg) {
        String message = String.format("[ %s ] to [ %s ]: %s", sender.getNickname(), receiver, msg);
        for (ClientHandler c : clients) {
            if (c.getNickname().equals(receiver)) {
                c.sendMsg(message);
                //==============//
                SQLHandler.addMessage(sender.getNickname(), receiver, msg, "once upon a time");
                //==============//
                if (!c.equals(sender)) {
                    sender.sendMsg(message);
                }
                return;
            }
        }
        sender.sendMsg(String.format("User %s not found", receiver));
    }

    void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
        broadcastClientList();
    }

    void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
        broadcastClientList();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public boolean isLoginAuthenticated(String login) {
        for (ClientHandler c : clients) {
            if (c.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder(Command.CLIENT_LIST);

        for (ClientHandler c : clients) {
            sb.append(" ").append(c.getNickname());
        }

        String msg = sb.toString();

        for (ClientHandler c : clients) {
            c.sendMsg(msg);
        }
    }

}
