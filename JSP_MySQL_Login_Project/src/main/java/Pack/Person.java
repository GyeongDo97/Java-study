package Pack;
// get, set ������� �Դ�.
public class Person {
	String id ="";
	String pass ="";
	String name ="";
	String email ="";
	String num ="";
	String date ="";
	
	public Person() { System.out.println("��������");}
	//���̵�
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	//�н�����
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }
	//�̸�
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	//�̸���
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	//����
	public String getNum() { return num; }
	public void setNum(String num) { this.num = num; }
	//�������
	public String getDate() { return date; }
	public void setDate(String date) { this.date = date; }
	
}