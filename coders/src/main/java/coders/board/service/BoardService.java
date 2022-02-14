package coders.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public interface BoardService {

	List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception;

	Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception;

	void insertBoard(Map<String, Object> map, HttpServletRequest req) throws Exception;

	void updateBoard(Map<String, Object> map, HttpServletRequest req) throws Exception;

	void deleteBoard(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception;
	
	List<Map<String, Object>> selectQnaBestList(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectFreeBestList(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectDeleteList(Map<String, Object> map) throws Exception;

	List<Map<String, Object>> selectReportList(Map<String, Object> map) throws Exception;

	
}
