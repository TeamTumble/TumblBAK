package com.tumbl.client.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.project.repository.ProjectRepository;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.client.project.vo.ProjectVO1;

@Service

public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public void join(ProjectVO pvo) {
		 projectRepository.save(pvo);

		
	}
	
	public List<ProjectVO> projectList(ProjectVO pvo) {
		return projectRepository.findAll();
	}
	
	
	/*public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		int p_num = pvo.getP_no();
		detail = projectRepository.findOne(p_num);
		return detail;
	}*/

	public ProjectVO projectDetail(ProjectVO pvo) {
		ProjectVO detail = null;
		int p_num = pvo.getPno();
		detail = projectRepository.findOne(p_num);
		return detail;
	}
	
	public List<ProjectVO> projectList_Hot(ProjectVO pvo) {
		List<ProjectVO> myList_Hot = null;
		myList_Hot = projectRepository.findAll();
		return myList_Hot;
	}
	
	public List<ProjectVO> projectList_New(ProjectVO pvo) {
		List<ProjectVO> myList_New = null;
		myList_New = projectRepository.findAll();
		return myList_New;
	}
}
