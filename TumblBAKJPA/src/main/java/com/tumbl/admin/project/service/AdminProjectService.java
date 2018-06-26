package com.tumbl.admin.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;

@Service
public class AdminProjectService {

	@Resource
	ProjectRepository projectRepository;

	// ������Ʈ ���
	public List<ProjectVO> projectList(ProjectVO pvo) {
		List<ProjectVO> myList = null;

		myList = projectRepository.findAll();
		return myList;
	}

	// ��ü ���ڵ� �� ����
	public int projectListCnt(ProjectVO pvo) {
		return projectRepository.countByPno(pvo);
	}

	public long countAdminProject(ProjectVO pvo) {
		long palc = projectRepository.count();
		return palc;
	}

	public Page<ProjectVO> findAll(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	// �ۻ� ����
	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		detail = projectRepository.findOne(pvo.getPno());
		System.out.println("������ ���� -=-=-=-=-=-=-=-=" + detail);

		return detail;

	}

	public Page<ProjectVO> findByPmnameContaining(String pmname, PageRequest pageRequest) {

		return projectRepository.findByPmnameContaining(pmname, pageRequest);
	}

	public Page<ProjectVO> findByPtitleContaining(String ptitle, PageRequest pageRequest) {

		return projectRepository.findByPtitleContaining(ptitle, pageRequest);

	}

	// �ۼ��� ����

	public ProjectVO projectUpdate(ProjectVO pvo) {
		System.out.println("������Ʈ ���� ���� ===================== " + pvo);
		projectRepository.save(pvo);
		return pvo;
	}

	/*
	 * 
	 * // ���Ͼ��� ���� public ProjectVO MailService(ProjectVO pvo); // ���Ͼ��� ����
	 * publicProjectVO projectLink(ProjectVO pvo);
	 */
}