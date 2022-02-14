package coders.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import coders.common.common.CommandMap;
import coders.project.service.ProjectService;

@Controller
public class ProjectController {

	@Resource(name = "projectService")
	private ProjectService projectService;

//	프로젝트 리스트
	@RequestMapping(value = "/Project.do")
	public ModelAndView ProjectList(CommandMap commandMap) throws Exception {

		ModelAndView mav = new ModelAndView("/project/project_board_list");

		List<Map<String, Object>> list = projectService.selectProjectList(commandMap.getMap());
		List<Map<String, Object>> list1 = projectService.selectProjectSList(commandMap.getMap());
		List<Map<String, Object>> list2 = projectService.selectProjectEList(commandMap.getMap());
		mav.addObject("list", list);
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		return mav;
	}

//프로젝트 작성폼
	@RequestMapping(value = "/Project/Write.do", method = RequestMethod.GET)
	public ModelAndView ProjectWriteForm(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_write");

		return mav;
	}

//프로젝트 작성
	@RequestMapping(value = "/Project/Write.do", method = RequestMethod.POST)
	public ModelAndView ProjectWrite(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_list");

		commandMap.put("PROJECT_NO", request.getParameter("PROJECT_NO"));
		commandMap.put("PROJECT_NAME", request.getParameter("PROJECT_NAME"));
		commandMap.put("PROJECT_START", request.getParameter("PROJECT_START"));
		commandMap.put("PROJECT_END", request.getParameter("PROJECT_END"));
		commandMap.put("PROJECT_MEMBER", request.getParameter("PROJECT_MEMBER"));
		commandMap.put("USER_NO", request.getParameter("USER_NO"));
		commandMap.put("PROJECT_CONTEXT", request.getParameter("PROJECT_CONTEXT"));

		projectService.insertProject(commandMap.getMap());
		return mav;
	}

//프로젝트 상세보기
	@RequestMapping(value = "/Project/Detail.do")
	public ModelAndView ProjectDetail(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_detail");

		commandMap.put("PROJECT_NO", request.getParameter("PROJECT_NO"));

		Map<String, Object> map = projectService.selectProjectDetail(commandMap.getMap());
		mav.addObject("map", map);
		return mav;

	}

//프로젝트 수정폼
	@RequestMapping(value = "/Project/Modify.do", method = RequestMethod.GET)
	public ModelAndView ProjectModifyForm(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_modify");
		Map<String, Object> map = projectService.selectProjectDetail(commandMap.getMap());
		System.out.println(map);
		mav.addObject("map", map);
		return mav;
	}

//프로젝트 수정
	@RequestMapping(value = "/Project/Modify.do", method = RequestMethod.POST)
	public ModelAndView ProjectModify(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/Project.do");
		System.out.println(commandMap.getMap());
		projectService.updateProject(commandMap.getMap());
		mav.addObject("EMAIL", commandMap.get("EMAIL"));
		return mav;
	}

//프로젝트 삭제
	@RequestMapping(value = "/Project/Delete.do")
	public ModelAndView ProjectDelete(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_list");

		commandMap.put("PROJECT_NO", request.getParameter("PROJECT_NO"));
		projectService.deleteProject(commandMap.getMap());
		return mav;

	}

//프로젝트참가신청
	@RequestMapping(value = "/Project/Application.do")
	public ModelAndView ProjectApplication(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_detail");

		commandMap.put("PROJECT_NO", request.getParameter("PROJECT_NO"));
		commandMap.put("APPLICATION_USER_NO", request.getParameter("APPLICATION_USER_NO"));

		projectService.insertProjectApp(commandMap.getMap());
		return mav;

	}
	//파일 업로드 관련 
		@RequestMapping(value="/Project/ProjectFile.do")
		public ModelAndView selectProjectFile(CommandMap commandMap)throws Exception{
			ModelAndView mav  = new ModelAndView("redirect:/project/project_board_list");
			
			projectService.selectProjectFile(commandMap.getMap());
			
			return mav;
		}
		
		
		

}