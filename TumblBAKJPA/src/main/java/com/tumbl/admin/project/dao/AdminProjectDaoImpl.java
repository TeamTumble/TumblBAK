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

	// ������Ʈ ���
	@Override
	public List<ProjectVO> projectList(ProjectVO pvo) {
		return session.selectList("projectList");
	}

	// ��ü ���ڵ� �Ǽ� ����
	@Override
	public int projectListCnt(ProjectVO pvo) {
		return (Integer) session.selectOne("projectListCnt");
	}

	// �� �� ����
	@Override
	public ProjectVO projectDetail(ProjectVO pvo) {
		return (ProjectVO) session.selectOne("projectDetail", pvo);
	}

	// ���Ͼ��� ����
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