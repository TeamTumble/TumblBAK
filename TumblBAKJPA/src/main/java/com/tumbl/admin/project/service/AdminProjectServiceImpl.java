/*package com.tumbl.admin.project.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.admin.project.dao.AdminProjectDao;
import com.tumbl.client.project.vo.ProjectVO;

@Service
@Transactional
public class AdminProjectServiceImpl implements AdminProjectService {
	Logger logger = Logger.getLogger(AdminProjectServiceImpl.class);
	@Autowired
	private AdminProjectDao adminProjectDao;

	// �۸�� ����
	@Override
	public List<ProjectVO> projectList(ProjectVO pvo) {
		List<ProjectVO> myList = null;

		// ���Ŀ� ���� �⺻�� ����
		if (pvo.getOrder_by() == null) {
			pvo.setOrder_by("p_no");
		}
		if (pvo.getOrder_sc() == null) {
			pvo.setOrder_sc("DESC");
		}

		myList = adminProjectDao.projectList(pvo);
		return myList;
	}

	// ��ü ���ڵ� �� ����
	@Override
	public int projectListCnt(ProjectVO pvo) {
		return adminProjectDao.projectListCnt(pvo);
	}

	// �ۻ� ����
	@Override
	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		detail = adminProjectDao.projectDetail(pvo);
		return detail;
	}

	// ���Ͼ��� ����
	@Override
	public ProjectVO MailService(ProjectVO pvo) {
		ProjectVO mail = null;
		mail = adminProjectDao.mailService(pvo);
		return mail;
	}

	@Override
	public ProjectVO projectLink(ProjectVO pvo) {
		ProjectVO link = null;
		link = adminProjectDao.projectLink(pvo);
		return link;
	}

	@Override
	public int projectUpdate(ProjectVO pvo) {
		int result = 0;
		try {
			result = adminProjectDao.projectUpdate(pvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
}
*/