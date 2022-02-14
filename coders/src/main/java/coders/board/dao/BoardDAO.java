package coders.board.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import coders.common.dao.AbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectBoardList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>)selectList("board.selectBoardList", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> selectBoardDetail(Map<String, Object> map) throws Exception {
		return (Map<String, Object>)selectOne("board.selectBoardDetail", map);
	}

	public void updateHitCnt(Map<String, Object> map) {
		update("board.updateHitCnt", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFileList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectFileList", map);
	}

	public void insertBoard(Map<String, Object> map) throws Exception{
		insert("board.insertBoard", map);
		
	}

	public void insertFile(Map<String, Object> map) throws Exception {
		insert("board.insertFile", map);
		
	}

	public void update(Map<String, Object> map) throws Exception{
		update("board.updateBoard", map);
		
	}

	public void delete(Map<String, Object> map) throws Exception{
		update("board.deleteBoard", map);
		
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectNoticeList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectNoticeList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectQnaBestList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectQnaBestList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectFreeBestList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectFreeBestList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectDeleteList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectDeleteList", map);
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectReportList(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("board.selectReportList", map);
	}

}
