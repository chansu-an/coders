package coders.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import coders.board.dao.BoardDAO;
/*import coders.common.util.FileUtils;*/

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	/*
	 * @Resource(name="fileUtils") private FileUtils fileUtils;
	 */

	@Resource(name = "boardDAO")
	private BoardDAO boardDAO;

	@Override
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return boardDAO.selectBoardList(map);
	}

	@Override
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		boardDAO.updateHitCnt(map);
		
		return boardDAO.selectBoardDetail(map);
	}

	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest req) throws Exception {
		boardDAO.insertBoard(map);

		/*
		 * List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(map, req);
		 * for(int i=0, size=list.size(); i<size; i++) {
		 * boardDAO.insertFile(list.get(i)); }
		 */
	}

	@Override
	public void updateBoard(Map<String, Object> map) throws Exception {
		boardDAO.update(map);
	}

	// 게시글 삭제하기
	@Override
	public void deleteBoard(Map<String, Object> map) throws Exception {
		boardDAO.delete(map);
	}

	// 메인에 보여질 최근 공지글
	@Override
	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) throws Exception {
		return boardDAO.selectNoticeList(map);
	}

	// 메인에 보여질 인기글
	@Override
	public List<Map<String, Object>> selectQnaBestList(Map<String, Object> map) throws Exception {
		return boardDAO.selectQnaBestList(map);
	}

	@Override
	public List<Map<String, Object>> selectFreeBestList(Map<String, Object> map) throws Exception {
		return boardDAO.selectFreeBestList(map);
	}

	//삭제글 리스트
	@Override
	public List<Map<String, Object>> selectDeleteList(Map<String, Object> map) throws Exception {
		return boardDAO.selectDeleteList(map);
	}
	
	//신고글 리스트
	@Override
	public List<Map<String, Object>> selectReportList(Map<String, Object> map) throws Exception {
		return boardDAO.selectReportList(map);
	}

	//게시글의 댓글 리스트
	@Override
	public List<Map<String, Object>> selectCommentList(Map<String, Object> map) throws Exception {
		return boardDAO.selectCommentList(map);
	}

	//게시글 댓글수
	@Override
	public Map<String, Object> selectCommentCount(Map<String, Object> map) throws Exception {
		return boardDAO.selectCommentCount(map);
	}


	//게시글 신고하기
	@Override
	public void reportBoard(Map<String, Object> map) throws Exception {
		boardDAO.reportBoard(map);
	}

	//게시글 추천하기
	@Override
	public void recommendBoard(Map<String, Object> map) throws Exception {
		boardDAO.recommendBoard(map);
		

	//게시글 댓글 삽입
	@Override
	public void insertComment(Map<String, Object> map) throws Exception {
		boardDAO.insertComment(map);		
	}

	//게시글 댓글 삭제
	@Override
	public void deleteComment(Map<String, Object> map) throws Exception {
		boardDAO.deleteComment(map);

	}
	
	
	
}
