/*package com.tumbl.admin.project.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tumbl.admin.notice.vo.NoticeVO;
import com.tumbl.client.project.vo.ProjectVO;

@Repository
public class AdminProjectDaoImpl implements AdminProjectDao {
	@Autowired
	private SqlSession session;

	// 프로젝트 목록
	@Override
	public List<ProjectVO> projectList(ProjectVO pvo) {
		return session.selectList("projectList");
	}

	// 전체 레코드 건수 구현
	@Override
	public int projectListCnt(ProjectVO pvo) {
		return (Integer) session.selectOne("projectListCnt");
	}

	// 글 상세 구현
	@Override
	public ProjectVO projectDetail(ProjectVO pvo) {
		return (ProjectVO) session.selectOne("projectDetail", pvo);
	}

	// 메일쓰기 구현
	@Override
	public ProjectVO mailService(ProjectVO pvo) {
		return (ProjectVO) session.selectOne("mailService", pvo);
	}

	@Override
	public ProjectVO projectLink(ProjectVO pvo) {
		return (ProjectVO) session.selectOne("projectLink", pvo);
	}

	@Override
	public int projectUpdate(ProjectVO pvo) {
		return session.update("projectUpdate", pvo);
	}

}
*/