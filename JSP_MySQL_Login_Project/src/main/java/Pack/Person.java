package Pack;
// get, set 만들려고 왔다.
public class Person {
	String id ="";
	String pass ="";
	String name ="";
	String email ="";
	String num ="";
	String date ="";
	
	public Person() { System.out.println("생성자콜");}
	//아이디
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	//패스워드
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	//이름
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	//이메일
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	//전번
	public String getNum() { return num; }
	public void setNum(String num) { this.num = num; }
	//생년월일
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	
}