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

	// 프로젝트 목록
	public List<ProjectVO> projectList(ProjectVO pvo) {
		List<ProjectVO> myList = null;

		myList = projectRepository.findAll();
		return myList;
	}

	// 전체 레코드 수 구현
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

	// 글상세 구현
	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		detail = projectRepository.findOne(pvo.getPno());
		System.out.println("디테일 서비스 -=-=-=-=-=-=-=-=" + detail);

		return detail;

	}

	public Page<ProjectVO> findByPmnameContaining(String pmname, PageRequest pageRequest) {

		return projectRepository.findByPmnameContaining(pmname, pageRequest);
	}

	public Page<ProjectVO> findByPtitleContaining(String ptitle, PageRequest pageRequest) {

		return projectRepository.findByPtitleContaining(ptitle, pageRequest);

	}

	// 글수정 구현

	public ProjectVO projectUpdate(ProjectVO pvo) {
		System.out.println("프로젝트 승인 서비스 ===================== " + pvo);
		projectRepository.save(pvo);
		return pvo;
	}

	/*
	 * 
	 * // 메일쓰기 구현 public ProjectVO MailService(ProjectVO pvo); // 메일쓰기 구현
	 * publicProjectVO projectLink(ProjectVO pvo);
	 */
}