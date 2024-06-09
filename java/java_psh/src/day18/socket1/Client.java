package day18.socket1;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {

	private Socket socket;
	
	public void read() {
		Thread t = new Thread(()->{
			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
				while(true) {
					String str= ois.readUTF();
					if(str.equals("-1")) {
						break;
					}
					System.out.println(str);
				}
				System.out.println("읽기 기능이 정상 종료됩니다.");
		}catch(Exception e) {
			System.out.println("예외 발생 읽기 기능 종료");
		}
		});
		t.start();
		
		
	}
	
	public void send() {
		Thread t = new Thread(()->{
			try(ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream())){
				Scanner scan = new Scanner(System.in);
				while(true) {
					String str = scan.nextLine();
					oos.writeUTF(str);
					oos.flush();
					if(str.equals("-1")) {
						break;
					}
				}
				System.out.println("전송 기능이 정상적으로 종료됩니다.");
				
				
			} catch (Exception e) {
				System.out.println("예외 발생 전송 기능 종료");
			}
		});
		t.start();
	}
}
