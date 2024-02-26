package day17.socket1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 3001;
		String serverIp;
		try {
			serverIp = InetAddress.getLocalHost().getHostAddress();
			
			Socket socket = new Socket(serverIp,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
