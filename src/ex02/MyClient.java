package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 20000);

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        Scanner sc = new Scanner(System.in);

        while (true) {
            String request = sc.nextLine();
            pw.println(request);
            String line = br.readLine();
            System.out.println(line);
        }
    }
}