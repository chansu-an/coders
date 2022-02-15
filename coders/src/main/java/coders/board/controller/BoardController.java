package coders.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import coders.board.service.BoardService;
import coders.common.common.CommandMap;



@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	//글목록 보기
	@RequestMapping(value="/board/openBoardList.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView openBoardList(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_list");
		
		//commandMap.put("BOARD_NO", Integer.parseInt(request.getParameter("BOARD_NO")));
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap.getMap());
<<<<<<< HEAD
=======

>>>>>>> dedf593654f69bd76506b7acf1a5d0ab2636a73a
		mav.addObject("list", list);
		/*
		 * Map<String, Object> count =
		 * boardService.selectCommentCount(commandMap.getMap()); mav.addObject("count",
		 * count);
		 */

		
		mav.addObject("list", list);
		
		return mav;
	}
	
	//메인에 올라갈 최근 공지, qna 인기글, 자유게시판 인기글
	@RequestMapping(value="/board/mainList.do")
	public ModelAndView noticeList(CommandMap commandMap, HttpSession session) throws Exception {
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
	public ModelAndView insertBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/openBoardList.do");
		
		commandMap.put("TITLE", request.getParameter("TITLE"));
		commandMap.put("CONTEXT", request.getParameter("CONTEXT"));
		
		boardService.insertBoard(commandMap.getMap(), request);
		
		return mav;
	}
	
	//글 상세보기
	@RequestMapping(value="/board/detail.do")
	public ModelAndView selectBoardDetail(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_detail");
		
		commandMap.put("BOARD_NO", Integer.parseInt(request.getParameter("BOARD_NO")));
		
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		Map<String, Object> count = boardService.selectCommentCount(commandMap.getMap());//댓글수
		Map<String, Object> bestcomment = boardService.selectBestComment(commandMap.getMap());//댓글수
		
		List<Map<String, Object>> list = boardService.selectCommentList(commandMap.getMap());//댓글 리스트
		
		mav.addObject("map", map);
		mav.addObject("list", list);
		mav.addObject("count", count);
		mav.addObject("bestcomment", bestcomment);
		/* mav.addObject("list", map.get("list")); */
		
		return mav;
	}
	
	//글 수정하기폼
	@RequestMapping(value="/board/modify.do", method = RequestMethod.GET)
	public ModelAndView openBoardUpdate(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("/board/board_modify");
		
		commandMap.put("BOARD_NO", Integer.parseInt(request.getParameter("BOARD_NO")));
		
		Map<String, Object> map = boardService.selectBoardDetail(commandMap.getMap());
		
		mav.addObject("map", map);
		/* mav.addObject("list", map.get("list")); */
		
		return mav;
	}
	
	@RequestMapping(value="/board/modify.do", method = RequestMethod.POST)
	public ModelAndView updateBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/detail.do?BOARD_NO=" + request.getParameter("BOARD_NO"));
		
		commandMap.put("TITLE", request.getParameter("TITLE"));
		commandMap.put("CONTEXT", request.getParameter("CONTEXT"));
		commandMap.put("IDENTI_TYPE", '1');
		commandMap.put("BOARD_NO", Integer.parseInt(request.getParameter("BOARD_NO")));
		
		boardService.updateBoard(commandMap.getMap());
		
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
	
	//글 신고하기
	@RequestMapping(value="/board/report.do" )
	public ModelAndView reportBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/detail.do?BOARD_NO=" + request.getParameter("BOARD_NO"));
		
		boardService.reportBoard(commandMap.getMap());
		
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
	
<<<<<<< HEAD
=======

>>>>>>> dedf593654f69bd76506b7acf1a5d0ab2636a73a
	//글 추천하기
	@RequestMapping(value="/board/recommend.do" )
	public ModelAndView recommendBoard(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/detail.do?BOARD_NO=" + request.getParameter("BOARD_NO"));
			
		boardService.recommendBoard(commandMap.getMap());
			
		return mav;
	}
	
	//댓글 작성하기

	//게시글 댓글 작성
<<<<<<< HEAD
=======

>>>>>>> dedf593654f69bd76506b7acf1a5d0ab2636a73a
	@RequestMapping(value="/board/commentInsert.do", method = RequestMethod.POST)
	public ModelAndView InsertComment(CommandMap commandMap, HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/detail.do?BOARD_NO=" + request.getParameter("BOARD_NO"));
		
		commandMap.put("BOARD_NO", Integer.parseInt(request.getParameter("BOARD_NO")));
		commandMap.put("USER_NO", Integer.parseInt(request.getParameter("USER_NO")));
		commandMap.put("CONTEXT", request.getParameter("CONTEXT"));
		boardService.insertComment(commandMap.getMap());
		
		return mav;
	}
	
	@RequestMapping(value="/board/commentDelete.do")
	public ModelAndView deleteComment(CommandMap commandMap, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/board/detail.do?BOARD_NO=" + request.getParameter("BOARD_NO"));
		
		commandMap.put("RE_NO", Integer.parseInt((request.getParameter("RE_NO"))));
		
		boardService.deleteComment(commandMap.getMap());
		
		return mav;
	}
}
