package day17.socket1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class testpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String serverIp = InetAddress.getLocalHost().getHostAddress();
			System.out.println(serverIp);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
