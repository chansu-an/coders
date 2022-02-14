package coders.project.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import coders.project.dao.ProjectDAO;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Resource(name = "projectDAO")
	private ProjectDAO projectDAO;

	@Override
	public List<Map<String, Object>> selectProjectList(Map<String, Object> map) throws Exception {

		return projectDAO.selectProjectList(map);
	}

	@Override
	public List<Map<String, Object>> selectProjectSList(Map<String, Object> map) throws Exception {

		return projectDAO.selectProjectSList(map);
	}

	@Override
	public List<Map<String, Object>> selectProjectEList(Map<String, Object> map) throws Exception {

		return projectDAO.selectProjectEList(map);
	}

	public void insertProject(Map<String, Object> map) throws Exception {
		projectDAO.insertProject(map);
	}

	@Override
	public Map<String, Object> selectProjectDetail(Map<String, Object> map) throws Exception {

		Map<String, Object> resultMap = projectDAO.selectProjectDetail(map);
		return resultMap;
	}

	@Override
	public void updateProject(Map<String, Object> map) throws Exception {
		projectDAO.updateProject(map);

	}

	@Override
	public void deleteProject(Map<String, Object> map) throws Exception {
		projectDAO.deleteProject(map);
	}

	@Override
	public void insertProjectApp(Map<String, Object> map) throws Exception {
		projectDAO.insertProjectApp(map);
	}

}
