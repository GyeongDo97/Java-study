package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class JavaAa {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/db01?useSSL=false";
	static final String USERNAME = "root";
	static final String PASSWORD = "1234";
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		System.out.println("접속");

		try {
			Class.forName(JDBC_DRIVER);

			while(true) {
				
				System.out.println("");
				System.out.println("1. 삽입");
				System.out.println("2. 출력");
				System.out.println("3. 업데이트");
				System.out.println("4. 삭제");
				System.out.println("메뉴를 선택하세요.");
							
				
				Scanner sc = new Scanner(System.in);
				int num = sc.nextInt();
				switch (num) {
				case 1: {
					System.out.println("이름을 입력하세요.");
					String name = sc.next();
					System.out.println(name);
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String ins = "INSERT INTO table01 values('" + name + "');";
					//System.out.println(ins);
					stmt.executeUpdate(ins);
					
					break;
				}
				case 2: {
					System.out.println("데이터베이스 출력합니다.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String sel = "SELECT Fullname FROM table01";
					rs = stmt.executeQuery(sel);
					while(rs.next()){
						String Fullname = rs.getString(1);

						System.out.println(Fullname);
					}
					break;
				}
				case 3: {
					System.out.println("수정합니다.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					
					String upd = "update table01"+
							" set Fullname='김자바'" +
							" where Fullname='호랑이';";
					//System.out.println(ins);
					stmt.executeUpdate(upd);
					
					break;
				}
				case 4: {
					System.out.println("삭제합니다.");
					conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
					stmt = conn.createStatement();
					String del = "delete from table01 where FullName='코끼리';";
					//System.out.println(ins);
					stmt.executeUpdate(del);
					
					break;
				}
				default:
				}
				
				stmt.close();
				conn.close();
				
				
			}

		}catch (ClassNotFoundException e) { 
			System.out.println("Class Not Found Exection"); 
			e.printStackTrace(); 

		}catch (SQLException e) {
			System.out.println("SQL Exception : " + e.getMessage()); e.printStackTrace(); 
		}

	}

}