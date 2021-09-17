package voteProject;

import java.util.List;

public class test {
	public static void main(String[] args) {
		Conn con = new Conn();
		con.getConnection();
		
		VoteDao v = new VoteDao();
		List<voterDto> list = v.voteList();
		for(voterDto t : list) {
			System.out.println(t);
		}
	}
}
