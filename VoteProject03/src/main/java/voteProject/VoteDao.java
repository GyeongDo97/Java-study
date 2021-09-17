package voteProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import voteProject.Conn;

public class VoteDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	private Connection getCon() {
		try {
		     String DBURL = "jdbc:mysql://localhost:3306/db01";
		     String DBID ="root";
		     String DBPW ="1234";	
		     Class.forName("com.mysql.cj.jdbc.Driver");
		     conn = DriverManager.getConnection(DBURL, DBID, DBPW);
			System.out.println(" 드라이버 로드, 디비연결 성공! ");
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	// 자원해제코드 - finally 구문에서 사용
	public void closeDB(){
		try {
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close();}
			if(conn != null){ conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int loginCheck(String name, int jumin) {
		try {
			conn = getCon();
			sql = "select name from voter where jumin=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, jumin);
			rs = pstmt.executeQuery();
			if(rs.next()){
				System.out.println(rs.getString(1));

				if(rs.getString(1).equals(name)){
					return 1; //로그인 성공
				}
				else
					return 0; //주민번호 불일치
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
	
	return -2;
	}

	public int voteCheck(voterDto voter) {
		try {
			conn = getCon();
			sql = String.format("select * " +
					" from voter " +
					" where name = '%s' and jumin = '%s' and `check` = 0"
					,voter.getName()
					,voter.getJumin());
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return 0;
	}		
	
	public int voteUpdate(voterDto voter) {
		try {
			conn = getCon();
			sql = String.format("update voter "+
					" set `check` = `check`+ 1 "+
					" where name = '%s' and jumin = '%s' ",
					voter.getName(),
					voter.getJumin());
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return 0;
	}	


	public void CountUpdate(String name) {
		try {
			conn = getCon();
			sql = "update candidate set count=count+1 where name=?";
			pstmt = conn.prepareStatement(sql);
			
			//?
			pstmt.setString(1, name);
			
			//4 sql 실행
			pstmt.executeUpdate();
			
			System.out.println(" 투표수 증가 완료! ");	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	private candidateDto getCandidate(ResultSet rs) throws SQLException {
		String name = rs.getString("name");
		int count = rs.getInt("count");
		return new candidateDto(name,count);
	}
	
	public List<candidateDto> voteSum() {
		conn = getCon();
		String sql = String.format(" select * from candidate ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("[ select2 메서드 실행 ]");
		try {
			
			if(rs.next()){
				List<candidateDto> clist = new ArrayList<>();
				do {
					clist.add(getCandidate(rs));	
				}while(rs.next());
				return clist;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private voterDto getVoters(ResultSet rs) throws SQLException {
		voterDto vote = new voterDto();
		vote.setName(rs.getString("name"));
		vote.setJumin(rs.getInt("jumin"));
		vote.setCheck(rs.getInt("check"));
		return vote;
	}
	
	public List<voterDto> voteList() {
		conn = getCon();
		String sql = String.format(" select * from voter ");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			
			if(rs.next()){
				List<voterDto> clist = new ArrayList<>();
				do {
					clist.add(getVoters(rs));	
				}while(rs.next());
				return clist;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
