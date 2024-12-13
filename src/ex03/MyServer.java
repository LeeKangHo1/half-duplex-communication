package ex03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
아주 간단한 프로토콜 연습
buyer:1 -> 사과
seller:1 -> 당근
buyer:2 -> 라면
seller:2 -> 우유
위 유형이 아니면 404 응답
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            // 1. 리스너 생성 및 대기 (메인스레드) - 메인스레드를 종료 안 시키기 위해 MyServer 전체를 while
            ServerSocket serverSocket = new ServerSocket(20000);
            Socket socket = serverSocket.accept();

            // (클라이언트마다 t1, t2, t3... 새로운 스레드)
            new Thread(() -> {
                // 여기에 2번 3번 넣어서 해봐라. 일단 예외처리 안된다고 오류 뜬다.
            });
            // 2. 버퍼 달기
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            // 3. 요청받고, 응답하기
            while (true) {
                String line = br.readLine();
                String response = parser(line);
                pw.println(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String parser(String line) {
        // line에 : 없으면 폭파
        String header = line.split(":")[0];
        String body = line.split(":")[1];

        String response = "404";

        if (header.equals("buyer")) {
            if (body.equals("1")) response = "사과";
            else if (body.equals("2")) response = "라면";
        }
        if (header.equals("seller")) {
            if (body.equals("1")) response = "당근";
            else if (body.equals("2")) response = "우유";
        }
        return response;
    }
}