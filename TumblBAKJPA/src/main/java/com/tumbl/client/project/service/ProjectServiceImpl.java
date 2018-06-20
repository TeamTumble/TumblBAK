/*package com.tumbl.client.project.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tumbl.client.project.dao.ProjectDAO;
import com.tumbl.client.project.vo.ProjectVO1;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
	Logger logger = Logger.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	public List<ProjectVO1> projectList(ProjectVO1 pvo) {
		List<ProjectVO1> myList = null;
		myList = projectDAO.projectList(pvo);
		return myList;
	}

	@Override
	public List<ProjectVO1> projectList_Art() {
		List<ProjectVO1> myList_Art = null;
		myList_Art = projectDAO.projectList_Art();
		return myList_Art;
	}

	@Override
	public List<ProjectVO1> projectList_Culture() {
		List<ProjectVO1> myList_Culture = null;
		myList_Culture = projectDAO.projectList_Culture();
		return myList_Culture;
	}

	@Override
	public List<ProjectVO1> projectList_Crafts() {
		List<ProjectVO1> myList_Crafts = null;
		myList_Crafts = projectDAO.projectList_Crafts();
		return myList_Crafts;
	}

	@Override
	public List<ProjectVO1> projectList_Book() {
		List<ProjectVO1> myList_Book = null;
		myList_Book = projectDAO.projectList_Book();
		return myList_Book;
	}

	@Override
	public List<ProjectVO1> projectList_Hot(ProjectVO1 pvo) {
		List<ProjectVO1> myList_Hot = null;
		myList_Hot = projectDAO.projectList_Hot(pvo);
		return myList_Hot;
	}
	
	@Override
	public List<ProjectVO1> projectList_New(ProjectVO1 pvo) {
		List<ProjectVO1> myList_New = null;
		myList_New = projectDAO.projectList_New(pvo);
		return myList_New;
	}

	@Override
	public ProjectVO1 projectDetail(ProjectVO1 pvo) {
		ProjectVO1 detail = null;
		detail = projectDAO.projectDetail(pvo);
		return detail;
	}

	@Override
	public int projectInsert(ProjectVO1 pvo) {
		int result = 0;
		try {
			result = projectDAO.projectInsert(pvo);

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public int projectUpdate(ProjectVO1 pvo) {
		int result = 0;
		try {
			result = projectDAO.projectUpdate(pvo);
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	@Override
	public List<ProjectVO1> projectList_HotA(ProjectVO1 pvo) {
		List<ProjectVO1> myList_Hot = null;
		myList_Hot = projectDAO.projectList_HotA(pvo);
		return myList_Hot;
	}

	@Override
	public List<ProjectVO1> projectList_NewA(ProjectVO1 pvo) {
		List<ProjectVO1> myList_New = null;
		myList_New = projectDAO.projectList_NewA(pvo);
		return myList_New;
	}

}
*/