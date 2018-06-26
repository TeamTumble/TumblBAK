package com.tumbl.client;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.client.project.service.ProjectService;
import com.tumbl.client.project.vo.ProjectVO;

@Controller
public class MainController {
	Logger logger = Logger.getLogger(MainController.class);

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		
		session.removeAttribute("adminLogin");
		PageRequest newProject = new PageRequest(0, 3, new Sort(Direction.DESC, "pno"));
		Page<ProjectVO> projectList_New = projectService.projectList_New(newProject);
		List<ProjectVO> newpro = projectList_New.getContent();
		model.addAttribute("projectList_New", newpro);
		
		PageRequest hotproject = new PageRequest(0, 3, new Sort(Direction.DESC, "psupporter"));
		Page<ProjectVO> projectList_Hot = projectService.projectList_Hot(hotproject);
		List<ProjectVO> hotPro = projectList_Hot.getContent();
		model.addAttribute("projectList_Hot", hotPro);

		return "index";
	}

}
