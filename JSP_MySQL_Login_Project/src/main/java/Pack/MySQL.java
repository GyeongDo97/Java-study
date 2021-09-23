package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	private Connection conn; //DB 커넥션 연결 객체
	private final String USERNAME = "root1";//DBMS접속 시 아이디
	private final String PASSWORD = "Abcd1234!";//DBMS접속 시 비밀번호
	private final String URL = "jdbc:mysql://220.119.22.165:8889/LoginProject";//DBMS접속할 db명

	public MySQL() {
		try {
			System.out.println("[ 생성자 ]");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("[ 드라이버 로딩 성공 ]");
		} catch (Exception e) {
			System.out.println("[ 드라이버 로딩 실패 ]");
			try {
				conn.close();
			} catch (SQLException e1) {    }
		}
	}

	public void create(String id, String pw, String name, String email, String num, String date) {
		String sql = "insert into UserList values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); //ID
			pstmt.setString(2, pw); //PW
			pstmt.setString(3, name); //Name
			pstmt.setString(4, email); //email
			pstmt.setString(5, num); //num
			pstmt.setString(6, date); //date

			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("[ Create 메서드 삽입 성공 ]");
			}
		}catch (Exception e) {
			System.out.println("[ Create 메서드 삽입 실패 ]");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
					return;
				}
			} catch (Exception e2) {}
		}
	}

	public String readID(String s) {
		String sql = "select ID from UserList;";
		PreparedStatement pstmt = null;
		String CHECK="checked";
		System.out.println("가지고 온 :"+s);
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("ID");
				System.out.println("DB에 있는 아이디: "+id);
				if(id.equals(s)) {
					System.out.println("중복 확인된 아이디: "+id);
					CHECK="denied";
					break;
				}
			}
		}
		catch(Exception e) {
			System.out.println("[ select 메서드 예외발생 ]");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
					return CHECK;
				}
			} catch (Exception e2) {}
		}
		return CHECK;
	}

	public int readlogin(String id, String pw) {
		String sql = " select * from UserList ";
		PreparedStatement pstmt = null;

		int checknum = 0;
		String checkID ;
		String checkPW ;


		// 0 = 로그인 오류 발생
		// 1 = ID가 없음
		// 2 = ID는 맞지만 PW가 틀림
		// 3 = ID PW 둘다 맞음

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("[ select 메서드 실행 ]");

			while(rs.next()) {
				checkID = rs.getString("ID");
				checkPW = rs.getString("PW");

				if(id.equals(checkID)) {
					checknum = pw.equals(checkPW)? 3 : 2;
				}
				else {
					checknum = 1;
				}
			}
			return checknum;

		}
		catch(Exception e) {
			System.out.println("[ select 메서드 예외발생 ]");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
					return checknum;
				}
			} catch (Exception e2) {}
		}
		return checknum;
	}


	public boolean readall(String id, String name, String num) {
		String sql = " select * from UserList ";
		PreparedStatement pstmt = null;

		int checknum = 0;
		String checkID = null;
		String checkName = null;
		String checkNumber = null;
		boolean result = false;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("[ select 메서드 실행 ]");

			while(rs.next()) {
				checkID = rs.getString("ID");
				checkName = rs.getString("FullName");
				checkNumber = rs.getString("PhoneNumber");

				if(id.equals(checkID) && name.equals(checkName) && num.equals(checkNumber)) {
					result=true;
				}
			}
		}
		catch(Exception e) {
			System.out.println("[ select 메서드 예외발생 ]");
		}    finally {
			try {
				if(pstmt!=null && !pstmt.isClosed()) {
					pstmt.close();
					return result;
				}
			} catch (Exception e2) {}
		}
		return result;
	}

	public String findID(String name, String email) {


			String sql = " select * from UserList ";
			PreparedStatement pstmt = null;

			String checkname ;
			String checkemail ;
			String resultID = null ;

			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				System.out.println("[ select 메서드 실행 ]");
				System.out.println(name);
				System.out.println(email);

				while(rs.next()) {
					checkname = rs.getString("FullName");
					checkemail = rs.getString("Email");

					if(name.equals(checkname)) {
						resultID = email.equals(checkemail)? "님의 ID는 " + rs.getString("ID") + " 입니다." : "님의 Email을 확인 해주세요." ;
					}
					else {
						resultID = "님의 이름으로 된 계정이 없습니다.";
					}
				}
				return resultID;
			}
			catch(Exception e) {
				System.out.println("[ select 메서드 예외발생 ]");
			}    finally {
				try {
					if(pstmt!=null && !pstmt.isClosed()) {
						pstmt.close();
						return resultID;
					}
				} catch (Exception e2) {}
			}
			return resultID;
		}

		public void update(String id, String pw) {
			String sql = "update table01 set PW=? where ID=?";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,pw);
				pstmt.setString(2,id);
				pstmt.executeUpdate();
				System.out.println("[ ID : " + id + "수정됨 ]");

			} catch (Exception e) {
				System.out.println("[ update 메서드 예외 발생 ] ");
			}    finally {
				try {
					if(pstmt!=null && !pstmt.isClosed()) {
						pstmt.close();
						return;
					}
				} catch (Exception e2) {}
			}
		}


		public void delete(String a) {
			String sql = "Delete from UserList where FullName= ? ";
			PreparedStatement pstmt = null;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,a);
				pstmt.executeUpdate();
				System.out.println("[ Name : " + a + " 삭제됨 ]");

			} catch (Exception e) {
				System.out.println("[ update 메서드 예외 발생 ] ");
			}    finally {
				try {
					if(pstmt!=null && !pstmt.isClosed()) {
						pstmt.close();
						return;
					}
				} catch (Exception e2) {}
			}
		}
	}


