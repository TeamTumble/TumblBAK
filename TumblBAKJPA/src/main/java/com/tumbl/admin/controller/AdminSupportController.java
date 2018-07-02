package com.tumbl.admin.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tumbl.admin.common.util.Util;
import com.tumbl.admin.service.AdminSupportService;
import com.tumbl.client.common.page.Paging;
import com.tumbl.user.vo.SupportVO;

@Controller
@RequestMapping(value = "/admin")
public class AdminSupportController {
	Logger logger = Logger.getLogger(AdminSupportController.class);

	@Autowired
	private AdminSupportService adminSupportService;

	/**************************************************************
	 * �۸�� �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/support/supportList.do", method = RequestMethod.GET)
	public String supportList(@ModelAttribute SupportVO svo, Model model) {
		logger.info("/support/supportList ȣ�� ����");

		// ������ ����
		Paging.setPage(svo);
		
		// ��ü ���ڵ�� ����
		if (svo.getKeyword().equals("")) {
			long total = adminSupportService.countAdminSupport(svo);
			System.out.println(svo.getPage() + "       " + svo.getPageSize());
			long count = total - (Util.nvl(svo.getPage()) - 1) * Util.nvl(svo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(svo.getPage()) - 1, Util.nvl(svo.getPageSize()),
					new Sort(Direction.DESC, "sno"));
			Page<SupportVO> page = adminSupportService.findAll(pageRequest);
			List<SupportVO> sQvo = page.getContent();
			model.addAttribute("supportList", sQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", svo);
			return "admin/support/supportList";
		} else {
			if (svo.getSearch().equals("sname")) {
				long total = adminSupportService.countAdminSupport(svo);
				long count = total - (Util.nvl(svo.getPage()) - 1) * Util.nvl(svo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(svo.getPage()) - 1, Util.nvl(svo.getPageSize()),
						new Sort(Direction.DESC, "sname"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + svo.getKeyword());
				System.out.println("sname �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<SupportVO> page = adminSupportService.findBySnameContaining(svo.getKeyword(), pageRequest);
				List<SupportVO> sQvo = page.getContent();
				model.addAttribute("supportList", sQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", svo);
				return "admin/support/supportList";
			}
			return "admin/support/supportList";
		}
		
		
	}

	/**************************************************************
	 * �۾��� �� ����ϱ�
	 **************************************************************/
	/*@RequestMapping(value = "/support/writeForm.do")
	public String writeForm() {
		logger.info("writeForm ȣ�� ����");
		return "admin/support/writeForm";	
	}*/

	/**************************************************************
	 * �۾��� �����ϱ�
	 **************************************************************/
/*	@RequestMapping(value = "/support/supportInsert.do", method = RequestMethod.POST)
	public String supportInsert(@ModelAttribute SupportVO svo, Model model, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("supportInsert ȣ�� ����");
		int result = 0;
		String url = "";

		result = adminSupportService.supportInsert(svo);
		if (result == 1) {
			url = "/admin/support/supportList.do";
		} else {
			model.addAttribute("code", 1);
			url = "/admin/support/writeForm.do";
		}
		return "redirect:" + url;
	}
*/
	/**************************************************************
	 * �� �󼼺��� ����
	 **************************************************************/
/*	@RequestMapping(value = "/support/supportDetail.do", method = RequestMethod.GET)
	public String supportDetail(@ModelAttribute SupportVO svo, Model model) {
		logger.info("supportDetail ȣ�� ����");
		logger.info("s_no = " + svo.getS_no());
		SupportVO detail = new SupportVO();
		detail = adminSupportService.supportDetail(svo);
		if (detail != null && (!detail.equals(""))) {
			detail.setS_giftname(detail.getS_giftname().toString().replaceAll("\n", "<br>"));
		}
		model.addAttribute("detail", detail);
		return "admin/support/supportDetail";
	}*/

	/**************************************************************
	 * ��й�ȣ Ȯ��
	 * 
	 * @param s_no
	 * @param s_pwd
	 * @return int�� result�� 0 �Ǵ� 1�� ������ ���� �ְ�, String�� result ���� "���� or ����"�� ������ ����
	 *         �ִ�.(���� ���ڿ� ����) ���� : @ResponseBody�� ���޵� �並 ���ؼ� ����ϴ� ���� �ƴ϶� HTTP
	 *         Response Body�� ���� ����ϴ� ���. produces �Ӽ��� ������ �̵�� Ÿ�԰� ���õ� ������ �����ϴµ� �����
	 *         ���� ����Ʈ Ÿ���� ����.
	 **************************************************************/

	/**************************************************************
	 * �ۼ��� �� ����ϱ�
	 * 
	 * @param :
	 *            s_no
	 * @return : SupportVO
	 **************************************************************/
/*	@RequestMapping(value = "/support/updateForm.do", method = RequestMethod.GET)
	public String updateForm(@ModelAttribute SupportVO svo, Model model) {
		logger.info("updateForm ȣ�� ����");
		logger.info("s_no = " + svo.getS_no());
		SupportVO updateData = new SupportVO();

		updateData = adminSupportService.supportDetail(svo);
		model.addAttribute("updateData", updateData);
		model.addAttribute("data", svo);
		return "admin/support/updateForm";
	}*/

	/**************************************************************
	 * �ۼ��� �����ϱ�
	 * 
	 * @param :
	 *            SupportVO
	 **************************************************************/
/*	@RequestMapping(value = "/support/supportUpdate.do", method = RequestMethod.POST)
	public String supportUpdate(@ModelAttribute SupportVO svo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("supportUpdate ȣ�� ����");
		int result = 0;
		String url = "";

		result = adminSupportService.supportUpdate(svo);
		if (result == 1) {
			// url="/support/supportList.do"; // ���� �� ������� �̵�
			// �Ʒ� url�� ���� �� �� �������� �̵�
			url = "/admin/support/supportDetail.do?s_no=" + svo.getS_no();
		} else {
			url = "/admin/support/updateForm.do??s_no=" + svo.getS_no();
		}
		return "redirect:" + url;
	}*/

	/**************************************************************
	 * �ۻ��� �����ϱ�
	 * 
	 * @throws IOException
	 **************************************************************/
/*	@RequestMapping(value = "/support/supportDelete.do")
	public String supportDelete(@ModelAttribute SupportVO svo, HttpServletRequest request) throws IOException {
		logger.info("supportDelete ȣ�� ����");
		// �Ʒ� �������� �Է� ������ ���� ���°� ����ϴ�.(1 or 0)
		int result = 0;

		result = adminSupportService.supportDelete(svo.getS_no());
		
		return "redirect:" + "/admin/support/supportList.do";
	}*/
}