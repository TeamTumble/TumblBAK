package com.tumbl.admin.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.tumbl.admin.member.service.AdminMemberService;
import com.tumbl.client.common.page.Paging;
import com.tumbl.client.member.vo.Member;
import com.tumbl.client.qna.vo.QnaVO;
import com.tumbl.common.util.Util;

@Controller
@RequestMapping(value = "/admin")
public class AdminMemberController {
	Logger logger = Logger.getLogger(AdminMemberController.class);

	@Autowired
	private AdminMemberService adminMemberService;

	/**************************************************************
	 * ȸ�� ����Ʈ �����ϱ�
	 **************************************************************/
	@RequestMapping(value = "/member/memberList.do", method = RequestMethod.GET)
	public String memberList(@ModelAttribute Member mvo, Model model, HttpSession session) {
		logger.info("memberList ȣ�� ����");

		// ������ ����
		Paging.setPage(mvo);

		// �۹�ȣ �缳��

		if (mvo.getKeyword().equals("")) {
			long total = adminMemberService.countadminMember(mvo);
			System.out.println(mvo.getPage() + "       " + mvo.getPageSize());
			long count = total - (Util.nvl(mvo.getPage()) - 1) * Util.nvl(mvo.getPageSize());
			PageRequest pageRequest = new PageRequest(Util.nvl(mvo.getPage()) - 1, Util.nvl(mvo.getPageSize()),
					new Sort(Direction.DESC, "idx"));
			Page<Member> page = adminMemberService.findAll(pageRequest);
			List<Member> mQvo = page.getContent();
			model.addAttribute("memberList", mQvo);
			model.addAttribute("count", count);
			model.addAttribute("total", total);
			model.addAttribute("data", mvo);
			return "admin/member/memberList";
		} else {
			if (mvo.getSearch().equals("email")) {
				long total = adminMemberService.countadminMember(mvo);
				long count = total - (Util.nvl(mvo.getPage()) - 1) * Util.nvl(mvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(mvo.getPage()) - 1, Util.nvl(mvo.getPageSize()),
						new Sort(Direction.DESC, "email"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + mvo.getKeyword());
				System.out.println("�̸��� �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<Member> page = adminMemberService.findByEmailContaining(mvo.getKeyword(), pageRequest);
				List<Member> mQvo = page.getContent();
				model.addAttribute("memberList", mQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", mvo);
				return "admin/member/memberList";
			} else if (mvo.getSearch().equals("mname")) {
				long total = adminMemberService.countadminMember(mvo);
				long count = total - (Util.nvl(mvo.getPage()) - 1) * Util.nvl(mvo.getPageSize());
				PageRequest pageRequest = new PageRequest(Util.nvl(mvo.getPage()) - 1, Util.nvl(mvo.getPageSize()),
						new Sort(Direction.DESC, "mname"));
				System.out.println("�˻� ��Ʈ�ѷ�      ==============  " + mvo.getKeyword());
				System.out.println("���� �˻� ��Ʈ�ѷ�      ==============  ž�� Ȯ��");
				Page<Member> page = adminMemberService.findByMnameContaining(mvo.getKeyword(), pageRequest);
				List<Member> cQvo = page.getContent();
				System.out.println("���� �˻� ��Ʈ�ѷ�      ============== " + cQvo);
				model.addAttribute("boardList", cQvo);
				model.addAttribute("count", count);
				model.addAttribute("total", total);
				model.addAttribute("data", mvo);
				return "admin/member/memberList";
			}
			return "admin/member/memberList";
		}
	}
}
