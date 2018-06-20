/*package com.tumbl.client.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.client.project.vo.ProjectVO1;

@Repository
public class ProjcetDAOImpl implements ProjectDAO {

	@Autowired
	private SqlSession session;

	@Override
	public List<ProjectVO1> projectList(ProjectVO1 pvo) {
		return session.selectList("projectList");
	}

	@Override
	public List<ProjectVO1> projectList_Art() {
		return session.selectList("projectList_Art");
	}

	@Override
	public List<ProjectVO1> projectList_Crafts() {
		return session.selectList("projectList_Crafts");
	}

	@Override
	public List<ProjectVO1> projectList_Culture() {
		return session.selectList("projectList_Culture");
	}
	
	@Override
	public List<ProjectVO1> projectList_Book() {
		return session.selectList("projectList_Book");
	}
	
	@Override
	public List<ProjectVO1> projectList_Hot(ProjectVO1 pvo) {
		return session.selectList("projectList_Hot");
	}
	
	@Override
	public List<ProjectVO1> projectList_New(ProjectVO1 pvo) {
		return session.selectList("projectList_New");
	}
	
	
	@Override
	public ProjectVO1 projectDetail(ProjectVO1 pvo) {
		return (ProjectVO1) session.selectOne("projectDetail", pvo);
	}

	@Override
	public int projectInsert(ProjectVO1 pvo) {
		return session.insert("projectInsert", pvo);
	}

	@Override
	public int projectUpdate(ProjectVO1 pvo) {
		return session.update("projectUpdate", pvo);
	}

	@Override
	public List<ProjectVO1> projectList_NewA(ProjectVO1 pvo) {
		return session.selectList("projectList_NewA");
	}

	@Override
	public List<ProjectVO1> projectList_HotA(ProjectVO1 pvo) {
		return session.selectList("projectList_HotA");
	}

}
*/