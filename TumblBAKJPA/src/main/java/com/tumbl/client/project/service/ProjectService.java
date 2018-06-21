package com.tumbl.client.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;

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

	/*
	 * public ProjectVO projectDetail(ProjectVO pvo) { ProjectVO detail = null; int
	 * p_num = pvo.getP_no(); detail = projectRepository.findOne(p_num); return
	 * detail; }
	 */

	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		int p_num = pvo.getPno();
		detail = projectRepository.findOne(p_num);
		return detail;
	}

	public Page<ProjectVO> projectList_Hot( Pageable pageable) {
		/*Page<ProjectVO> pvo = null;

		pvo = */

		return projectRepository.findAll(pageable);
		/*return projectRepository.findTop3ByPsupporter(psupporter, pageable);*/

	}

	public Page<ProjectVO> projectList_New(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

}
