package com.tumbl.client.project.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.login.vo.Login;
import com.tumbl.client.member.service.MemberService;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.project.service.ProjectService;
import com.tumbl.client.project.vo.ProjectVO;
import com.tumbl.common.file.FileUploadUtil;


@Controller
@RequestMapping(value = "/project")
public class ProjectController {
	Logger logger = Logger.getLogger(ProjectController.class);

	@Resource
	private ProjectService projectService;

	@Resource
	private MemberService memberService;

	/**********************
	 * 전체 조회
	 **********************/
	@RequestMapping(value = "/projectList.do", method = RequestMethod.GET)
	public String projectList(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectList ");
		
		/*LoginVO login = (LoginVO) session.getAttribute("login");*/
		List<ProjectVO> projectList = projectService.projectList(pvo);
		System.out.println("셀렉트쪽 값    === " + projectList);
		model.addAttribute("projectList", projectList);
		/*model.addAttribute("data", pvo);*/
		/*model.addAttribute("num", pvo.getP_no());*/
		/*model.addAttribute("login", login);*/
		

		return "project/galleryList";
	}
	
	/**********************
	 * 최신프로젝트 조회
	 **********************//*
	
	@RequestMapping(value = "/projectListNew.do", method = RequestMethod.GET)
	public String projectListNew(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectList ");
		LoginVO login = (LoginVO) session.getAttribute("login");
		List<ProjectVO> projectList_New = projectService.projectList_NewA(pvo);
		model.addAttribute("projectList_New", projectList_New);
		model.addAttribute("login", login);
		

		return "project/projectList_New";
	}
	
	*//**********************
	 * 인기프로젝트 조회
	 **********************//*
	
	@RequestMapping(value = "/projectListHot.do", method = RequestMethod.GET)
	public String projectListHot(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectList ");
		LoginVO login = (LoginVO) session.getAttribute("login");
		List<ProjectVO> projectList_Hot = projectService.projectList_HotA(pvo);
		model.addAttribute("projectList_Hot", projectList_Hot);
		model.addAttribute("login", login);
		

		return "project/projectList_Hot";
	}
	
	
	

	*//**********************
	 * 공예 카테고리 조회
	 **********************//*
	@RequestMapping(value = "/projectList_Crafts.do", method = RequestMethod.GET)
	public String projectList_Craft(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_Crafts ");

		List<ProjectVO> projectList_Crafts = projectService.projectList_Crafts();

		model.addAttribute("projectList_Crafts", projectList_Crafts);
		model.addAttribute("data", pvo);

		return "project/projectList_Crafts";

	}
	
	
	

	*//**********************
	 * 미술 카테고리 조회
	 **********************//*
	@RequestMapping(value = "/projectList_Art.do", method = RequestMethod.GET)
	public String projectList_Art(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_Art ");

		List<ProjectVO> projectList_Art = projectService.projectList_Art();
		
		model.addAttribute("projectList_Art", projectList_Art);
		model.addAttribute("data", pvo);

		return "project/projectList_Art";
	}

	*//**********************
	 * 문화 카테고리 조회
	 **********************//*
	@RequestMapping(value = "/projectList_Culture.do", method = RequestMethod.GET)
	public String projectList_Culture(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_Culture ");

		List<ProjectVO> projectList_Culture = projectService.projectList_Culture();

		model.addAttribute("projectList_Culture", projectList_Culture);
		model.addAttribute("data", pvo);

		return "project/projectList_Culture";
	}

	*//**********************
	 * 문화 카테고리 조회
	 **********************//*
	@RequestMapping(value = "/projectList_Book.do", method = RequestMethod.GET)
	public String projectList_Book(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_Culture ");

		List<ProjectVO> projectList_Book = projectService.projectList_Book();

		model.addAttribute("projectList_Book", projectList_Book);
		model.addAttribute("data", pvo);

		return "project/projectList_Book";
	}

	
	
	*//**********************
	 * 핫한 카테고리 조회
	 **********************//*
	@RequestMapping(value = "/projectList_Hot.do", method = RequestMethod.GET)
	public String projectList_Hot(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_Hot ");

		List<ProjectVO> projectList_Hot = projectService.projectList_Hot(pvo);

		model.addAttribute("projectList_Hot", projectList_Hot);
		model.addAttribute("data", pvo);

		return "template/client/mainlayout";
	}
	
	*//**********************
	 * 새로 만든 프로젝트  조회
	 **********************//*
	@RequestMapping(value = "/projectList_New.do", method = RequestMethod.GET)
	public String projectList_New(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("projectList_New ");

		List<ProjectVO> projectList_New = projectService.projectList_New(pvo);

		model.addAttribute("projectList_New", projectList_New);
		model.addAttribute("data", pvo);

		return "template/client/mainlayout";
	}

	
	
	
	/**************************************************************
	 * 프로젝트 생성 가이드
	 **************************************************************/
	@RequestMapping(value = "/projectGuide.do")
	public String guide() {
		logger.info("projectGuide");
		return "project/projectGuide";
	}
	
	/**************************************************************
	 * 라이너 실행
	 **************************************************************/
	@RequestMapping(value = "/liner.do")
	public String liner() {
		logger.info("Liner");
		return "project/liner";
	}

	/**************************************************************
	 * 프로젝트 수정 폼 불러오기
	 **************************************************************/
	/*@RequestMapping(value = "/updateProjectForm.do", method = RequestMethod.GET)
	public String updateProjectForm(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("updateForm ");
		logger.info("p_no = " + pvo.getP_no());

		ProjectVO updateData = new ProjectVO();
		updateData = projectService.projectDetail(pvo);

		model.addAttribute("updateData", updateData);

		return "project/updateProjectForm";
	}*/

	/**************************************************************
	 * 프로젝트 생성폼 불러오기
	 **************************************************************/
	@RequestMapping(value = "/projectCreate.do")
	public ModelAndView projectCreate(HttpSession session) {
		logger.info("projectCreate ");
		ModelAndView mav = new ModelAndView();
		Login login = (Login) session.getAttribute("login");
		if (login == null) {
			mav.setViewName("member/login");
			return mav;
		}
		Member vo = memberService.findByemail(login.getEmail());
		mav.addObject("member", vo);
		mav.setViewName("project/projectCreate");
		return mav;
	}

	/**************************************************************
	 * 프로젝트 등록
	 **************************************************************/
	@RequestMapping(value = "/projectInsert.do", method = RequestMethod.POST)
	public String projectInsert(@ModelAttribute("ProjectVO") ProjectVO pvo, Model model, HttpServletRequest request,
			HttpSession session) throws IllegalStateException, IOException {
		logger.info("projectCreate ");
		
		
		System.out.println(pvo);
		int result = 0;
		String url = "";
		
		
		
		
		

		if (pvo.getP_file() != null) {
			String p_image = FileUploadUtil.fileUpload(pvo.getP_file(), request, "projectvo");
			try {
				String T_image = FileUploadUtil.makeThumbnail(p_image, request);
				pvo.setP_image(T_image);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (pvo.getPm_file() != null) {
			String pm_image = FileUploadUtil.fileUpload(pvo.getPm_file(), request, "projectvo");
			pvo.setPm_image(pm_image);
		}
		if (pvo.getPs_file() != null) {
			String p_storyimage = FileUploadUtil.fileUpload(pvo.getPs_file(), request, "projectvo");
			pvo.setP_storyimage(p_storyimage);
		}
		
		System.out.println(pvo);
		projectService.join(pvo);
		
			

			url = "/project/projectList.do";
		
			
		
		return "redirect:" + url;
	}

	/**************************************************************
	 * 프로젝트 자세히 보기
	 **************************************************************/
	@RequestMapping(value = "/projectDetail.do", method = RequestMethod.GET)
	public String projectDetail(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectDetail ");
		logger.info("p_no = " + pvo.getPno());
		ProjectVO detail = new ProjectVO();
		/*SupportVO svo = new SupportVO();*/
		Login login = (Login) session.getAttribute("login");
		detail = projectService.projectDetail(pvo);
		model.addAttribute("detail", detail);
		model.addAttribute("login", login);
		return "project/projectDetail";
	}
	

	/**************************************************************
	 * 프로젝트 수정
	 **************************************************************/
/*	@RequestMapping(value = "/projectUpdate.do", method = RequestMethod.POST)
	public String projectUpdate(@ModelAttribute ProjectVO pvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("projectUpdate ");

		int result = 0;
		String url = "";

		String p_image = "";
		String pm_image = "";
		String p_storyimage = "";

		if (!pvo.getP_file().isEmpty()) {
			logger.info("======== P_file = " + pvo.getP_file().getOriginalFilename());
			if (!pvo.getP_image().isEmpty()) {
				FileUploadUtil.fileDelete(pvo.getP_image(), request);
			}
			p_image = FileUploadUtil.fileUpload(pvo.getP_file(), request, "project");
			pvo.setP_image(p_image);
		} else {
			logger.info("");
			pvo.setP_image("");
		}

		if (!pvo.getPm_file().isEmpty()) {
			logger.info("======== Pm_file = " + pvo.getPm_file().getOriginalFilename());
			if (!pvo.getPm_image().isEmpty()) {
				FileUploadUtil.fileDelete(pvo.getPm_image(), request);
			}
			pm_image = FileUploadUtil.fileUpload(pvo.getPm_file(), request, "project");
			pvo.setPm_image(pm_image);
		} else {
			logger.info("");
			pvo.setPm_image("");
		}

		if (!pvo.getPs_file().isEmpty()) {
			logger.info("======== Ps_file = " + pvo.getPs_file().getOriginalFilename());
			if (!pvo.getP_storyimage().isEmpty()) {
				FileUploadUtil.fileDelete(pvo.getP_storyimage(), request);
			}
			p_storyimage = FileUploadUtil.fileUpload(pvo.getPs_file(), request, "project");
			pvo.setP_storyimage(p_storyimage);
		} else {
			logger.info("");
			pvo.setP_storyimage("");
		}

		result = projectService.projectUpdate(pvo);

		if (result == 1) {

			url = "/project/projectList.do?p_no=" + pvo.getP_no();
		} else {
			url = "/project/updateProjectForm.do??p_no=" + pvo.getP_no();
		}
		return "redirect:" + url;
	}

	
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String main()
	 * { return "index"; }*/
	 

}
