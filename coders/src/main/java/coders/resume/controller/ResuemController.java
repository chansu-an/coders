package coders.resume.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import coders.resume.service.ResumeService;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import coders.common.common.CommandMap;

@Controller
public class ResuemController {
	
	@Resource(name = "ResumeService")
	private ResumeService resumeService;
	//이력서 상세보기
	@RequestMapping(value ="/Resume/Detail.do")
	public ModelAndView selectResumeDetail(CommandMap commandMap,HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = resumeService.selectResumeDetail(commandMap.getMap());
		//저장된 이력서가 없으면 이력서 작성으로
		if(map==null) {
			mav.setViewName("redirect:/Resume/InsertResume.do");
			return mav;
		}
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		mav.addObject("CHECK", "N");
		if(smap!=null) {
			if(map.get("USER_NO").equals(smap.get("USER_NO"))) {
				mav.addObject("CHECK", "Y");
			}
		}
		mav.addObject("map", map);
		mav.setViewName("/Resuem/resumedetail");
		return mav;
	}
	//이력서 작성
	@RequestMapping(value = "/Resume/InsertResume.do",method = RequestMethod.GET)
	public String insertResumeForm()throws Exception{
		return "/Resume/InsertResumeForm";
	}
	
	@RequestMapping(value = "/Resume/InsertResume.do",method = RequestMethod.POST)
	public ModelAndView insertResume(CommandMap commandMap,HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		commandMap.put("USER_NO", smap.get("USER_NO"));
		resumeService.insertResume(commandMap.getMap());
		mav.setViewName("redirect:/main/Mypage.do?USER_NO="+smap.get("USER_NO"));
		return mav;
		
	}
	//이력서 수정
	@RequestMapping(value = "/Resume/UpdateResume.do", method = RequestMethod.GET)
	public ModelAndView updateResumeForm(HttpSession session)throws Exception{
		ModelAndView mav = new ModelAndView();
		Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
		Map<String, Object> map = resumeService.selectResumeDetail(smap);
		mav.addObject("map", map);
		mav.setViewName("/Resume/updateResumeForm");
		return mav;
		
	}
	//이력서 수정
		@RequestMapping(value = "/Resume/UpdateResume.do", method = RequestMethod.POST)
		public ModelAndView updateResume(CommandMap commandMap,HttpSession session)throws Exception{
			ModelAndView mav = new ModelAndView();
			Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
			resumeService.updateResume(commandMap.getMap());
			mav.setViewName("redirect:/main/Mypage.do?USER_NO="+smap.get("USER_NO"));
			return mav;
			
			
			
		}
	
	//이력서 삭제
		@RequestMapping(value ="/Resuem/DeleteResume.do")
		public ModelAndView DeleteResume(HttpSession session)throws Exception{
			ModelAndView mav =new ModelAndView();
			Map<String, Object> smap = (Map<String, Object>)session.getAttribute("map");
			resumeService.deleteResume(smap);
			mav.setViewName("redirect:/main/Mypage.do?USER_NO="+smap.get("USER_NO"));
			return mav;
		}

}
