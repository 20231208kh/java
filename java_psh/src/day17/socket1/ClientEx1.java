package day17.socket1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientEx1 {

	public static void main(String[] args) {
		// 서버의 ip, port번호 설정
		Scanner scan = new Scanner(System.in);
		
		String ip = "192.168.30.193";
		int port = 5001;
		ArrayList<String> list = null;
		
		//1. ip와 port를 이용해 소켓 생성
		try(Socket socket = new Socket()){
			//2.연결 요청
			socket.connect(new InetSocketAddress(ip,port));
			//3.작업
			System.out.println("연결 성공!!");
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			list = (ArrayList<String>) ois.readObject();
			System.out.println(list);
			
			while(true) {
				System.out.print("내용 : ");
				String str = scan.nextLine();
				oos.writeUTF(str);
				oos.flush();
				if (str.equals("-1")) {
					break;
				}
			}
			os.close();
			oos.close();
		} catch (UnknownHostException e) {
			System.out.println("연결할 수 없습니다");
		} catch (IOException e) {
			System.out.println("에외 발생");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
