package voteProject;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class VoteController {
	@RequestMapping("/candidate")
	public String method12(Model model, candidateDto dto, voterDto vto, 
			HttpServletRequest r, HttpServletResponse response) {
		String name = dto.getName();
		VoteDao vdao = new VoteDao();
		vto.setJumin(Integer.parseInt(r.getParameter("voterJumin")));
		vto.setName(r.getParameter("voterName"));
		int voteCheck = vdao.voteCheck(vto);
		System.out.println(voteCheck);
		if(voteCheck == 1) {
			vdao.CountUpdate(name);
			vdao.voteUpdate(vto);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>");
				out.print(" alert('이미 투표하셨습니다'); ");
				out.print(" history.go(-2); ");
				out.print("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		return goRes(model);
	}
	
	@RequestMapping("/voter")
	public ModelAndView voter(voterDto vote, candidateDto candidate, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("voteResult");
		vote.setName(request.getParameter("voterName"));
		vote.setJumin(Integer.parseInt(request.getParameter("voterJumin")));

		mv.addObject("candidate", candidate);

		return mv;
	}
	
	
	@RequestMapping("/loginCheck")
	public String method12(Model model, voterDto dto, HttpServletResponse response) {
		String name = dto.getName();
		int jumin = dto.getJumin();
		
		VoteDao vdao = new VoteDao();
		
		int check = vdao.loginCheck(name, jumin);
		int voteCheck = vdao.voteCheck(dto);
		model.addAttribute("voterInfo",dto);
		System.out.println(name +  jumin);
		if(check == 1) {
			if(voteCheck == 1) {
				return "vote";
			} else {
				return goRes(model);
			}
		}else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>");
				out.print(" alert('없는 아이디입니다.'); ");
				out.print(" history.back(); ");
				out.print("</script>");
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
	}
	
	VoteDao vDao = new VoteDao();

	@RequestMapping("/vote")
	public ModelAndView vote(voterDto vote) {
		ModelAndView mv = new ModelAndView("vote");
		mv.addObject("voterInfo", vote);
		return mv;
	}

	
	public String goRes(Model model) {
		VoteDao a = new VoteDao();
		List<candidateDto> mm = a.voteSum();
		model.addAttribute("mmm", mm);
		
		List<voterDto> voteList = a.voteList();
		model.addAttribute("voteList", voteList);
		return "voteResult";
	}

}




