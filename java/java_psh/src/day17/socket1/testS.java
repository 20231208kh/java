package day17.socket1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class testS {

	public static void main(String[] args) {
		int port = 3001;
		
		ServerSocket server;
		try {
			server = new ServerSocket(port);

			Socket client = server.accept();
			System.out.println("연결");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
