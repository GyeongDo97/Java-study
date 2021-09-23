package Pack01;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//��Ŭ������ ���������� �ν��ϴ� ��Ʈ�ѷ���� ���� ����ϱ����� @ �̿��Ѵ�.
@Controller
public class Tiger {
	//�Լ��� ���ϴ� ���� �ƴ� ���θ� �����Ͽ� ����Ѵ�(Mapping)
	//��û������ ���̵� �����־� ����
	@RequestMapping("/t1")
	//���⿡ �����Ҷ� t1�̶�� �θ��ڴ�.
	public String method01() {
		System.out.println("�Լ���1");
		return null;
	}

	@ResponseBody
	//���� jsp�� ���������ʰ� ȭ�鿡 ���ϰ� ���
	@RequestMapping("/t2")
	//���⿡ �����Ҷ� t2��� �θ��ڴ�.
	public String method02() {
		System.out.println("�Լ���2");
		//return null;  <---  ���� �̵��� jsp������ �̸��� return���ָ� �ȴ�.
		return "Tiger Call";
	}

	@RequestMapping("/t3")
	public String method03() {
		System.out.println("�Լ���3");
		return "TigerView";
		//���� .jsp�� ������ �ʴ´�.
	}

	@RequestMapping("/t4")
	public String method04(
			@RequestParam(value="name") String name
			//"name"�̶� ��ӵ� �̸��� ����� ������ requestparam�� �̿��ؼ� ���ͼ�
			//name�� �־��ش�.
			) {
		System.out.println("�Լ���4 " + name);
		return "TigerView";
	}
	@RequestMapping("/t5")
	public String method05(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") int age
			//"name"�̶� ��ӵ� �̸��� ����� ������ requestparam�� �̿��ؼ� ���ͼ�
			//name�� �־��ش�.
			) {
		System.out.println("�Լ���5 " + name + age);
		return "TigerView";
	}
	
	@RequestMapping("/t6")
	public String method06(
			HttpServletRequest request
			) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("�Լ���6 " + name + age);
		return "TigerView";
	}

	@RequestMapping("/t7")
	public String method07(Model model) {
		model.addAttribute("name", "�޹���");
		model.addAttribute("age", "100");
		//name���� ������ �޹����� �޴´�.
		//age���� ������ 100�� �޴´�.
		//model�� return��ų�� ���� �Ѿ��.
		System.out.println("�Լ���7");
		return "TigerView";
	}
	
	
	
}
