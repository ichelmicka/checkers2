package com.example.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Minimalny konsolowy klient: 1) wysyła JOIN <name>, 2) wysyła linie "MOVE x y".
 */
public class Client {
    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: java com.example.client.Client <host> <port> <name>");
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String name = args[2];

        try (Socket s = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             Scanner sc = new Scanner(System.in)) {

            out.println("JOIN " + name);

            Thread reader = new Thread(() -> {
                try {
                    String l;
                    while ((l = in.readLine()) != null) {
                        System.out.println("[SERVER] " + l);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected.");
                }
            });
            reader.setDaemon(true);
            reader.start();

            System.out.println("Use: MOVE x y");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("quit")) break;
                out.println(line);
            }
        }
    }
}