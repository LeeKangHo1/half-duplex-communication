package ex01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 10000);

        // 아래 BufferedWriter를 더욱 편리하게 쓰기 위해 만듬. /n같은 거 빼먹어도 괜찮게
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println("Hello World");

//        BufferedWriter bw = new BufferedWriter(
//                new OutputStreamWriter(socket.getOutputStream())
//        );
//
//        bw.write("Hello World\n"); // \n은 붙여야 한다. 프로토콜임
//        bw.flush();
    }
}
