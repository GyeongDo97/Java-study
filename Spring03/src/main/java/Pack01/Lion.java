package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Lion {
	@RequestMapping("/t8")
	public String method08(
			Model model,
			HttpServletRequest r
			) {
		String name = r.getParameter("name");
		String age = r.getParameter("age");
		
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		System.out.println("함수콜8" + name + age);
		return "LionView";
	}

	@RequestMapping("/t9")
	public ModelAndView method09() {
		ModelAndView mv = new ModelAndView("LionView");
		mv.addObject("name", "고양이");
		mv.addObject("age", 2000);
		return mv;
	}

	@RequestMapping("/t10")
	public ModelAndView method10() {
		
		ModelAndView mv; 
		mv= new ModelAndView((3<2) ? "TigerView" : "LionView" );
		mv.addObject("name", "고양이");
		mv.addObject("age", 2000);
		return mv;
	}
	
	@RequestMapping("/t12")
	public String method11(Model model, Person person) {
		model.addAttribute("ppp", person);
		
		LinkedList<String> mm = new LinkedList<String>();
		mm.add("까치1");
		mm.add("까치2");
		mm.add("까치3");
		model.addAttribute("mmm",mm);
		
		return "LionView";
	}
	
	//배열전송, LInkedList mm 이용가능
}
