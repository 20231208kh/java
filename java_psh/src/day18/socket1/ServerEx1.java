package day18.socket1;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx1 {

	public static void main(String[] args) {
		int port = 5001;
//		String ip = "192.168.30.193";
		try(ServerSocket serverSocket = new ServerSocket(port)){
			Socket socket = serverSocket.accept();
			Client client = new Client(socket);
			client.send();
			client.read();
		}catch(Exception e) {
			System.out.println("서버 소켓 생성에서 예외 발생하여 종료");
		}

	}

}
