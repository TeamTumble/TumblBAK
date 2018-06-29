package com.tumbl.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.user.repository.ProjectRepository;
import com.tumbl.user.vo.ProjectVO;

@Service

public class ProjectService {
	@Resource
	ProjectRepository projectRepository;

	public void join(ProjectVO pvo) {
		projectRepository.save(pvo);

	}

	public List<ProjectVO> projectList(ProjectVO pvo) {
		return projectRepository.findAll();
	}


	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		detail = projectRepository.findOne(pvo.getPno());
		return detail;
	}

	public Page<ProjectVO> projectList_Hot(String pcase, Pageable pageable) {
		return projectRepository.findByPcaseLike(pcase, pageable);

	}

	public Page<ProjectVO> projectList_New(String pcase, Pageable pageable) {
		return projectRepository.findByPcaseLike(pcase, pageable);
	}

	public long countProject(ProjectVO pvo) {
		long palc = projectRepository.count();
		return palc;
	}

	public Page<ProjectVO> findA(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	public Page<ProjectVO> findByPtitleContaining(String ptitle, Pageable pageable) {
		return projectRepository.findByPtitleContaining(ptitle, pageable);
	}

	public void projectUpdate(ProjectVO pvo) {
		ProjectVO detail = null;
		detail = projectRepository.findOne(pvo.getPno());
		detail = pvo;
		projectRepository.save(detail);

	}

	public Page<ProjectVO> findByPcaseLike(String pcase, Pageable pageable) {
		return projectRepository.findByPcaseLike(pcase, pageable);
	}

}
