package voteProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
	public Connection getConnection() {
		Connection conn = null;
		try {
			 // 1. 드라이버 로딩
            Class.forName("com.mysql.jdbc.Driver");
 
            // 2. 연결하기
            String url = "jdbc:mysql://211.221.45.149:7777/db01";
            String username = "test4";
            String password = "1";
            conn = DriverManager.getConnection(url,username,password);
            System.out.println(conn+ "연결성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return conn;
	}
}
