package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        // 소켓은 클라이언트랑 1:1로 연결
        // 서버소켓 -> 리스너소켓. 통신이 들어오면 소켓을 만들고 임의의 번호의 포트를 배정해서 그 소켓과 클라이언트를 연결한 다음, 서버 소캣과 클라이언트간 연결은 끊음
        try {
            ServerSocket serverSocket = new ServerSocket(10000); // 1. 서버소캣 생성

            Socket socket = serverSocket.accept(); // 2. 리스닝 -> 서버소캣한데 배정 받을 때 까지 while 돌리면서 대기 중(코드 진행x). 배정 받으면 소켓 생성하고 다음 코드로 진행
            System.out.println("oh! connect?");

            BufferedReader br = new BufferedReader(
                    // 소켓으로부터 input 받음
                    new InputStreamReader(socket.getInputStream()) // 버퍼에 소켓 장착
            );

            String line = br.readLine(); // 버퍼에 있는 메세지를 \n까지 읽는다. ("Hello World" -> \n 없어서 읽다가 터짐-> 예외 발생)
            System.out.println("read : " + line);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        1. 서버 main 실행 (oh! connect? 출력 안 된 상태)
        2. 클라이언트 main 실행
        3. console 탭에서 MyServer 탭을 보면 (oh! connect? 와 read : Hello World 출력)
        */

        // 여기까지 하고 응답까지 코드 쓰면 반이중. 지금은 단방향 통신 구현

        // 소켓을 직접 구현하면? http 통신은 헤더내용이 필수 -> 내가 소켓 만들면 필요 없음
        // -> 빠르고 간결한 통신 가능
    }
}
