package coders.project.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
//
//	@RequestMapping(value = "/Project.do")
//	public ModelAndView ProjectSList(CommandMap commandMap) throws Exception {
//
//		ModelAndView mav = new ModelAndView("/project/project_board_list");
//
//		List<Map<String, Object>> list = projectService.selectProjectSList(commandMap.getMap());
//
//		mav.addObject("list", list);
//
//		return mav;
//	}
//	@RequestMapping(value = "/Project.do")
//	public ModelAndView ProjectEList(CommandMap commandMap) throws Exception {
//
//		ModelAndView mav = new ModelAndView("/project/project_board_list");
//
//		List<Map<String, Object>> list = projectService.selectProjectEList(commandMap.getMap());
//
//		mav.addObject("list", list);
//
//		return mav;
//	}

	@RequestMapping(value = "/Project/Write.do", method = RequestMethod.GET)
	public ModelAndView ProjectWriteForm(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_write");

		return mav;
	}

	@RequestMapping(value = "/Project/Write.do", method = RequestMethod.POST)
	public ModelAndView ProjectWrite(CommandMap commandMap) throws Exception {

		ModelAndView mav = new ModelAndView("redirect:/project/project_board_list");

		projectService.insertProject(commandMap.getMap());
		return mav;
	}

	@RequestMapping(value = "/Project/Detail.do")
	public ModelAndView ProjectDetail(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_detail");

		Map<String, Object> map = projectService.selectProjectDetail(commandMap.getMap());
		mav.addObject("map", map);
		return mav;

	}

	@RequestMapping(value = "/Project/Modify.do", method = RequestMethod.GET)
	public ModelAndView ProjectModifyForm(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/project/project_board_modify");

		Map<String, Object> map = projectService.selectProjectDetail(commandMap.getMap());
		mav.addObject("map", map);
		return mav;
	}

	@RequestMapping(value = "/Project/Modify.do", method = RequestMethod.POST)
	public ModelAndView ProjectModify(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_detail");

		projectService.updateProject(commandMap.getMap());
		mav.addObject("EMAIL", commandMap.get("EMAIL"));
		return mav;
	}

	@RequestMapping(value = "/Project/Delete.do")
	public ModelAndView ProjectDelete(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_list");

		projectService.deleteProject(commandMap.getMap());
		return mav;

	}

	@RequestMapping(value = "/Project/Application.do")
	public ModelAndView ProjectApplication(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/project/project_board_detail");

		projectService.insertProjectApp(commandMap.getMap());
		return mav;

	}

}