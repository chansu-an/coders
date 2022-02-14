package coders.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coders.board.service.BoardService;
import coders.common.common.CommandMap;



@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	//글목록 보기
	@RequestMapping(value="/board/openBoardList.do")
	public ModelAndView openBoardList(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_list");
		
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap.getMap());
		mav.addObject("list", list);
		
		return mav;
	}
	
	//메인에 올라갈 최근 공지, qna 인기글, 자유게시판 인기글
	@RequestMapping(value="/board/mainList.do")
	public ModelAndView noticeList(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/main_list");
				
		List<Map<String, Object>> list1 = boardService.selectNoticeList(commandMap.getMap());
		List<Map<String, Object>> list2 = boardService.selectQnaBestList(commandMap.getMap());
		List<Map<String, Object>> list3 = boardService.selectFreeBestList(commandMap.getMap());
		mav.addObject("list1", list1);
		mav.addObject("list2", list2);
		mav.addObject("list3", list3);
		
		return mav;
	}
	
	//글쓰기
	@RequestMapping(value="/board/write.do")
	public ModelAndView openBoardWrite(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_write");
		
		return mav;
	}
	
	@RequestMapping(value="/board/insertBoard.do")
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/openBoardList.do");
		
		commandMap.put("TITLE", req.getParameter("TITLE"));
		commandMap.put("CONTEXT", req.getParameter("CONTEXT"));
		
		boardService.insertBoard(commandMap.getMap(), req);
		
		return mav;
	}
	
	//글 상세보기
	@RequestMapping(value="/board/detail.do")
	public ModelAndView selectBoardDetail(CommandMap commandMap,HttpServletRequest request) throws Exception {
		
		ModelAndView mav = new ModelAndView("/board/board_detail");
		String no = request.getParameter("BOARD_NO");
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("BOARD_NO", no);
		Map<String, Object> map = boardService.selectBoardDetail(map1);
		mav.addObject("map", map.get("map"));
		mav.addObject("list", map.get("list"));
		
		return mav;
	}
	
	//글 수정하기
	@RequestMapping(value="/board/modify.do")
	public ModelAndView openBoardUpdate(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_modify");
		
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		mav.addObject("map", map.get("map"));
		mav.addObject("list", map.get("list"));
		
		return mav;
	}
	
	@RequestMapping(value="/board/modifyBoard.do")
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest req) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/openBoardDetail.do");
		
		boardService.updateBoard(commandMap.getMap(), req);
		mav.addObject("BOARD_NO", commandMap.get("BOARD_NO"));
		return mav;
	}
	
	//글 삭제하기
	@RequestMapping(value="/board/delete.do")
	public ModelAndView deleteBoard(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/openBoardList.do");
		
		boardService.deleteBoard(commandMap.getMap());
		return mav;
	}
	
	//삭제글 리스트
	@RequestMapping(value="/board/deleteList.do")
	public ModelAndView deleteList(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_list");
		List<Map<String, Object>> list = boardService.selectDeleteList(commandMap.getMap());
		mav.addObject("list", list);
		
		return mav;
	}
	
	//신고글 리스트
	@RequestMapping(value="/board/reportList.do")
	public ModelAndView reportList(CommandMap commandMap) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_list");
		List<Map<String, Object>> list = boardService.selectReportList(commandMap.getMap());
		mav.addObject("list", list);
		
		return mav;
	}
}
