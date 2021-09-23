package Pack01;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//이클래스가 스프링에서 인식하는 컨트롤러라는 것을 기록하기위해 @ 이용한다.
@Controller
public class Tiger {
	//함수를 콜하는 것이 아닌 서로를 연결하여 사용한다(Mapping)
	//요청에대한 아이디를 보내주어 연결
	@RequestMapping("/t1")
	//여기에 연결할때 t1이라고 부르겠다.
	public String method01() {
		System.out.println("함수콜1");
		return null;
	}

	@ResponseBody
	//따로 jsp를 연결하지않고 화면에 리턴값 출력
	@RequestMapping("/t2")
	//여기에 연결할때 t2라고 부르겠다.
	public String method02() {
		System.out.println("함수콜2");
		//return null;  <---  내가 이동할 jsp파일의 이름을 return해주면 된다.
		return "Tiger Call";
	}

	@RequestMapping("/t3")
	public String method03() {
		System.out.println("함수콜3");
		return "TigerView";
		//끝에 .jsp를 붙이지 않는다.
	}

	@RequestMapping("/t4")
	public String method04(
			@RequestParam(value="name") String name
			//"name"이라 약속된 이름에 저장된 정보를 requestparam을 이용해서 들고와서
			//name에 넣어준다.
			) {
		System.out.println("함수콜4 " + name);
		return "TigerView";
	}
	@RequestMapping("/t5")
	public String method05(
			@RequestParam(value="name") String name,
			@RequestParam(value="age") int age
			//"name"이라 약속된 이름에 저장된 정보를 requestparam을 이용해서 들고와서
			//name에 넣어준다.
			) {
		System.out.println("함수콜5 " + name + age);
		return "TigerView";
	}
	
	@RequestMapping("/t6")
	public String method06(
			HttpServletRequest request
			) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("함수콜6 " + name + age);
		return "TigerView";
	}

	@RequestMapping("/t7")
	public String method07(Model model) {
		model.addAttribute("name", "앵무새");
		model.addAttribute("age", "100");
		//name으로 던져서 앵무새로 받는다.
		//age으로 던져서 100로 받는다.
		//model은 return시킬떄 같이 넘어간다.
		System.out.println("함수콜7");
		return "TigerView";
	}
	
	
	
}
