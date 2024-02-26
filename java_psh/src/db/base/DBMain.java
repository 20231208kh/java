package db.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/test";
		String id = "root";
		String pw = "root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e){
			System.out.println("연결 실패");
		} catch (ClassNotFoundException e){
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
		
		//insert문 예제
//		String sql = "insert into member values('asdasd','pwasd','asd@naver.com',now())";
//		Statement stmt = null;
//		try{
//			stmt = con.createStatement();
//			stmt.execute(sql);
//			System.out.println("회원 추가 성공");
//		} catch (SQLException e){
//			System.out.println("예외 발생");
//		}
		
		//String sql = "쿼리";
		//예시 ?을 이용하여 값을 동적으로 변경
	/*
		String sql = "insert into member values(?,?,?,now())";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
			pstmt.setString(1, "qweqwe");
			pstmt.setString(2, "pwewe");
			pstmt.setString(3, "qwe@naver.com");
			//쿼리가 적용된 행의 개수를 리턴.
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("예외 발생");
		}
	*/
		//update문 예제
		String sql = "update member set pw = ? where id = ?";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			//?개수만큼 setxxx을 이용하여 바인딩 해야 함
			pstmt.setString(1, "newPw");
			pstmt.setString(2, "qweqwe");
			//쿼리가 적용된 행의 개수를 리턴.
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("예외 발생");
		}
		
		//delete문 예제
		
		//select문 예제
		
	}

}
