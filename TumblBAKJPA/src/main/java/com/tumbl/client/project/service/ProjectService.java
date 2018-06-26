package com.tumbl.client.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.qna.vo.QnaVO;

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

	public Page<ProjectVO> projectList_Hot(Pageable pageable) {
		/*
		 * Page<ProjectVO> pvo = null;
		 * 
		 * pvo =
		 */

		return projectRepository.findAll(pageable);
		/* return projectRepository.findTop3ByPsupporter(psupporter, pageable); */

	}

	public Page<ProjectVO> projectList_New(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	public long countProject(ProjectVO pvo) {
		long palc = projectRepository.count();
		return palc;
	}

	public Page<ProjectVO> findA(Pageable pageable) {
		return projectRepository.findAll(pageable);
	}

	public Page<ProjectVO> findByPtitleContaining(String ptitle, Pageable pageable) {
		System.out.println("서비스 검색 이메일 =============  " + ptitle);
		return projectRepository.findByPtitleContaining(ptitle, pageable);
	}

	public void projectUpdate(ProjectVO pvo) {
		ProjectVO detail = null;
		System.out.println( "업데이트 서비스 ==================  " + pvo.getEmail());

		detail = projectRepository.findOne(pvo.getPno());
		detail = pvo;
		projectRepository.save(detail);

	}
	
	public Page<ProjectVO> findByPcaseLike(String pcase, Pageable pageable){
		return projectRepository.findByPcaseLike(pcase, pageable);
	}

}
