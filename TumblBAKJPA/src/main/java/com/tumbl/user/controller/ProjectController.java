package com.tumbl.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tumbl.client.common.page.Paging;
import com.tumbl.common.file.FileUploadUtil;
import com.tumbl.common.util.Util;
import com.tumbl.user.service.MemberService;
import com.tumbl.user.service.ProjectService;
import com.tumbl.user.vo.Login;
import com.tumbl.user.vo.Member;
import com.tumbl.user.vo.ProjectVO;

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
		Paging.setPage(pvo);
		try {

			if (pvo.getKeyword().equals("")) {				
				long total = projectService.countProject(pvo);
				long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
						new Sort(Direction.DESC, "pno"));
				Page<ProjectVO> page = projectService.findByPcaseLike("승인", pageRequest);
				List<ProjectVO> cQvo = page.getContent();
				model.addAttribute("projectList", cQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", pvo);
				return "project/galleryList";
			} else if (pvo.getSearch().equals("ptitle")) {
				long total = projectService.countProject(pvo);
				long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
						new Sort(Direction.DESC, "pno"));
				Page<ProjectVO> page = projectService.findByPtitleContaining(pvo.getKeyword(), pageRequest);
				List<ProjectVO> cQvo = page.getContent();
				model.addAttribute("projectList", cQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", pvo);
				return "project/galleryList";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "project/galleryList";

	}

	/**********************
	 * 최신프로젝트 조회
	 **********************/

	@RequestMapping(value = "/projectListNew.do", method = RequestMethod.GET)
	public String projectListNew(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectList ");
		Login login = (Login) session.getAttribute("login");
		Paging.setPage(pvo);
		if (pvo.getKeyword().equals("")) {			
			long total = projectService.countProject(pvo);
			long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
					new Sort(Direction.DESC, "pno"));
			Page<ProjectVO> page = projectService.findA(pageRequest);
			List<ProjectVO> cQvo = page.getContent();
			model.addAttribute("projectList_New", cQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", pvo);
			model.addAttribute("login", login);
			return "project/projectList_New";
		} else if (pvo.getSearch().equals("ptitle")) {
			long total = projectService.countProject(pvo);
			long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
					new Sort(Direction.DESC, "pno"));
			Page<ProjectVO> page = projectService.findByPtitleContaining(pvo.getKeyword(), pageRequest);
			List<ProjectVO> cQvo = page.getContent();			
			model.addAttribute("projectList_New", cQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", pvo);
			model.addAttribute("login", login);
			return "project/projectList_New";
		}
		return "project/projectList_New";

	}

	/**********************
	 * 인기프로젝트 조회
	 **********************/

	@RequestMapping(value = "/projectListHot.do", method = RequestMethod.GET)
	public String projectListHot(@ModelAttribute ProjectVO pvo, Model model, HttpSession session) {
		logger.info("projectList ");
		Login login = (Login) session.getAttribute("login");
		Paging.setPage(pvo);
		if (pvo.getKeyword().equals("")) {
			long total = projectService.countProject(pvo);
			long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
					new Sort(Direction.DESC, "psupporter"));
			Page<ProjectVO> page = projectService.findA(pageRequest);
			List<ProjectVO> cQvo = page.getContent();
			model.addAttribute("projectList_Hot", cQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", pvo);
			model.addAttribute("login", login);
			return "project/projectList_Hot";
		} else if (pvo.getSearch().equals("ptitle")) {
			long total = projectService.countProject(pvo);
			long count = total - (Util.nvl(pvo.getPage()) - 1) * Util.nvl(pvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(pvo.getPage()) - 1, Util.nvl(pvo.getPageSize()),
					new Sort(Direction.DESC, "ptitle"));
			Page<ProjectVO> page = projectService.findByPtitleContaining(pvo.getKeyword(), pageRequest);
			List<ProjectVO> cQvo = page.getContent();
			model.addAttribute("projectList_Hot", cQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", pvo);
			model.addAttribute("login", login);
			return "project/projectList_Hot";
		}
		return "project/projectList_Hot";

	}

	
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

	@RequestMapping(value = "/updateProjectForm.do", method = RequestMethod.GET)
	public String updateProjectForm(@ModelAttribute ProjectVO pvo, Model model) {
		logger.info("updateForm ");
		logger.info("p_no = " + pvo.getPno());

		ProjectVO updateData = new ProjectVO();
		updateData = projectService.projectDetail(pvo);

		model.addAttribute("updateData", updateData);

		return "project/updateProjectForm";
	}

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

		String url = "";
		Date todate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
		String dTime = formatter.format(todate);
		pvo.setStart_date(dTime);

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
			try {
				String T_pmimage = FileUploadUtil.makeThumbnail(pm_image, request);
				pvo.setPm_image(T_pmimage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pvo.getPs_file() != null) {
			String p_storyimage = FileUploadUtil.fileUpload(pvo.getPs_file(), request, "projectvo");
			try {
				String T_psimage = FileUploadUtil.makeThumbnail(p_storyimage, request);
				pvo.setP_storyimage(T_psimage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

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
		Login login = (Login) session.getAttribute("login");
		detail = projectService.projectDetail(pvo);
		model.addAttribute("detail", detail);
		model.addAttribute("login", login);
		return "project/projectDetail";
	}

	/**************************************************************
	 * 프로젝트 수정
	 **************************************************************/

	@RequestMapping(value = "/projectUpdate.do", method = RequestMethod.POST)
	public String projectUpdate(@ModelAttribute ProjectVO pvo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("projectUpdate ");

	
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
			try {
				String T_pmimage = FileUploadUtil.makeThumbnail(pm_image, request);
				pvo.setPm_image(T_pmimage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pvo.getPs_file() != null) {
			String p_storyimage = FileUploadUtil.fileUpload(pvo.getPs_file(), request, "projectvo");
			try {
				String T_psimage = FileUploadUtil.makeThumbnail(p_storyimage, request);
				pvo.setP_storyimage(T_psimage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		projectService.projectUpdate(pvo);

		url = "/project/projectList.do?pno=" + pvo.getPno();

		return "redirect:" + url;
	}


}
