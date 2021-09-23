package Pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
	private Connection conn; //DB Ŀ�ؼ� ���� ��ü
	private final String USERNAME = "root1";//DBMS���� �� ���̵�
	private final String PASSWORD = "Abcd1234!";//DBMS���� �� ��й�ȣ
	private final String URL = "jdbc:mysql://220.119.22.165:8889/LoginProject";//DBMS������ db��

	public MySQL() {
		try {
			System.out.println("[ ������ ]");
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("[ ����̹� �ε� ���� ]");
		} catch (Exception e) {
			System.out.println("[ ����̹� �ε� ���� ]");
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
				System.out.println("[ Create �޼��� ���� ���� ]");
			}
		}catch (Exception e) {
			System.out.println("[ Create �޼��� ���� ���� ]");
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
		System.out.println("������ �� :"+s);
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id=rs.getString("ID");
				System.out.println("DB�� �ִ� ���̵�: "+id);
				if(id.equals(s)) {
					System.out.println("�ߺ� Ȯ�ε� ���̵�: "+id);
					CHECK="denied";
					break;
				}
			}
		}
		catch(Exception e) {
			System.out.println("[ select �޼��� ���ܹ߻� ]");
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


		// 0 = �α��� ���� �߻�
		// 1 = ID�� ����
		// 2 = ID�� ������ PW�� Ʋ��
		// 3 = ID PW �Ѵ� ����

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("[ select �޼��� ���� ]");

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
			System.out.println("[ select �޼��� ���ܹ߻� ]");
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
			System.out.println("[ select �޼��� ���� ]");

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
			System.out.println("[ select �޼��� ���ܹ߻� ]");
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
				System.out.println("[ select �޼��� ���� ]");
				System.out.println(name);
				System.out.println(email);

				while(rs.next()) {
					checkname = rs.getString("FullName");
					checkemail = rs.getString("Email");

					if(name.equals(checkname)) {
						resultID = email.equals(checkemail)? "���� ID�� " + rs.getString("ID") + " �Դϴ�." : "���� Email�� Ȯ�� ���ּ���." ;
					}
					else {
						resultID = "���� �̸����� �� ������ �����ϴ�.";
					}
				}
				return resultID;
			}
			catch(Exception e) {
				System.out.println("[ select �޼��� ���ܹ߻� ]");
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
				System.out.println("[ ID : " + id + "������ ]");

			} catch (Exception e) {
				System.out.println("[ update �޼��� ���� �߻� ] ");
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
				System.out.println("[ Name : " + a + " ������ ]");

			} catch (Exception e) {
				System.out.println("[ update �޼��� ���� �߻� ] ");
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


