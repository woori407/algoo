package com.algoo.app.faq.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algoo.app.common.PaginationInfo;
import com.algoo.app.common.SearchVO;
import com.algoo.app.faq.model.FaqListVO;
import com.algoo.app.faq.model.FaqService;
import com.algoo.app.faq.model.FaqVO;
import com.algoo.app.faq.model.ListFaqVO;
import com.algoo.app.notice.model.NoticeListVO;
import com.algoo.app.notice.model.NoticeVO;

@Controller
@RequestMapping("/faq")
public class FaqController {
	private static final Logger logger
	=LoggerFactory.getLogger(FaqController.class);
	
	@Autowired
	private FaqService faqService;
		
	@RequestMapping(value="/faqWrite.ag", method=RequestMethod.GET)
	public String write_get(){
		logger.info("FAQ 쓰기 화면 보여주기");
				
		return "faq/faqWrite";
	}
	
	@RequestMapping(value="/faqWrite.ag", method=RequestMethod.POST)
	public String write_post(@ModelAttribute FaqVO faqVo){
		logger.info("FAQ 쓰기 처리, 파라미터 faqVo = {}", faqVo);
		
		int cnt = faqService.WriteFaq(faqVo);
		logger.info("글쓰기 결과 cnt = {}", cnt);
	
		return "redirect:/faq/faqList.ag";
	}
	
	@RequestMapping("/faqList.ag")
	public String listFaq(@ModelAttribute ListFaqVO searchVo,
			@RequestParam(required=false) String categoryName,
			Model model){
		logger.info("FAQ 목록 조회, 파라미터 searchVo = {}", searchVo);
		logger.info("카테고리 ={}",categoryName);
		
		PaginationInfo pagingInfo = new PaginationInfo();
		pagingInfo.setBlockSize(10);
		pagingInfo.setRecordCountPerPage(20);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		
		searchVo.setBlockSize(pagingInfo.getBlockSize());
		searchVo.setRecordCountPerPage(pagingInfo.getRecordCountPerPage());
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		
		PaginationInfo onePage = new PaginationInfo();
		onePage.setBlockSize(1);
		onePage.setRecordCountPerPage(20);
		onePage.setCurrentPage(searchVo.getCurrentPage());
		
		searchVo.setBlockSize(onePage.getBlockSize());
		searchVo.setRecordCountPerPage(onePage.getRecordCountPerPage());
		searchVo.setFirstRecordIndex(onePage.getFirstRecordIndex());
				
		//List<FaqVO> alist = faqService.selectAllFaq(searchVo);
		List<FaqVO> alist = new ArrayList<FaqVO>();
		
		searchVo.setCategory(categoryName); //카테고리 검색용
		
		if(categoryName!=null && !categoryName.isEmpty()){
			alist = faqService.searchCategory(searchVo);
			logger.info("FAQ 목록 조회 결과 alist.size()={}", alist.size());
		}else{
			alist = faqService.selectAllFaq(searchVo);
		}
		
		int totalRecord=faqService.selectTotalCount(searchVo);
		pagingInfo.setTotalRecord(totalRecord);
		onePage.setTotalRecord(totalRecord);
				
		model.addAttribute("alist", alist);
		model.addAttribute("pagingInfo", pagingInfo);
		model.addAttribute("onePage", onePage);
		
		return "faq/faqList";
	}
	
	@RequestMapping("/faqDetail.ag")
	public String detail(@RequestParam(defaultValue="0") int faqNo, Model model){
		logger.info("FAQ 답변보기, 파라미터 faqNo = {}", faqNo);
		
		if(faqNo==0){
			model.addAttribute("msg", "잘못된 url입니다");
			model.addAttribute("url", "/faq/faqList.ag");
			
			return "common/message";
		}
		
		FaqVO faqVo=faqService.selectByNo(faqNo);
		logger.info("FAQ 답변보기 결과, faqVo={}", faqVo);
		
		FaqVO faqPreVo=faqService.prevContent(faqNo);
		logger.info("이전글 보기 결과 faqVo = {}", faqVo);
		
		FaqVO faqNextVo=faqService.nextContent(faqNo);
		logger.info("다음글 보기 결과 faqVo = {}", faqVo);
		
		
		model.addAttribute("faqVo", faqVo);
		model.addAttribute("preFaqVo", faqPreVo);
		model.addAttribute("nextFaqVo", faqNextVo);
		
		return "faq/faqDetail";
	}
	
	@RequestMapping(value="/faqEdit.ag", method=RequestMethod.GET)
	public String edit_get(@RequestParam(defaultValue="0") int faqNo, Model model){
		logger.info("FAQ 수정화면 보여주기, 파라미터 faqNo = {}", faqNo);
	
		if(faqNo==0){
			model.addAttribute("msg", "잘못된 url입니다");
			model.addAttribute("url", "/faq/faqList.ag");
			
			return "common/message";
		}
				
		FaqVO faqVo = faqService.selectByNo(faqNo);
		logger.info("FAQ 조회 결과, faqVo = {}", faqVo);
		
		model.addAttribute("faqVo", faqVo);
		return "faq/faqEdit";
	}
	
	@RequestMapping(value="/faqEdit.ag", method=RequestMethod.POST)
	public String edit_post(@ModelAttribute FaqVO faqVo, Model model){
		logger.info("FAQ 수정, 파라미터 faqVo = {}", faqVo);
		
		String msg="", url="/faq/faqEdit.ag?faqNo="+faqVo.getFaqNo();
		int cnt=faqService.updateFaq(faqVo);

		if(cnt>0){
			msg="FAQ 수정 성공";
			logger.info("FAQ 수정 결과, cnt = {}", cnt);
				
			url="/faq/faqDetail.ag?faqNo="+faqVo.getFaqNo();
		}else{
			msg="글 수정 실패";
		}

		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "common/message";
	}
	
	@RequestMapping(value="/faqDelete.ag", method=RequestMethod.GET)
	public String delete_get(@RequestParam(defaultValue="0") int faqNo, Model model){
		logger.info("FAQ 삭제 화면 보여주기, 파라미터 faqNo = {}", faqNo);
		
		if(faqNo==0){
			model.addAttribute("msg", "잘못된 url입니다");
			model.addAttribute("url", "/faq/faqList.ag");
			
			return "common/message";
		}
		
		return "faq/faqDelete";
	}
	
	@RequestMapping(value="/faqDelete.ag", method=RequestMethod.POST)
	public String delete_post(@RequestParam(defaultValue="0") int faqNo, Model model){
		logger.info("FAQ 삭제 , 파라미터 faqNo = {}", faqNo);
		
		int cnt=faqService.deleteFaq(faqNo);
		logger.info("글삭제 결과, cnt = {}", cnt);
			
		return "redirect:/faq/faqList.ag";
	}
	
	@RequestMapping("/faqAdminDelete.ag")
	public String faqAdminDelete(@RequestParam(defaultValue="0") int faqNo,	Model model){
		logger.info("관리자 FAQ 삭제 파라미터 faqNo={}", faqNo);
		
		String msg="", url="";
		int cnt = faqService.deleteFaq(faqNo);
		if(cnt>0){
			msg="FAQ 삭제 성공";
			url="/admin/adminBoard.ag";
		}else{
			msg="FAQ 삭제 실패";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "common/message";
	}
	
	@RequestMapping("/faqUserList.ag")
	public String UserlistFaq(@ModelAttribute ListFaqVO searchVo,
			@RequestParam(required=false) String categoryName,
			Model model){
		logger.info("FAQ User 목록 조회, 파라미터 searchVo = {}", searchVo);
		logger.info("카테고리 ={}",categoryName);
		
		PaginationInfo pagingInfo = new PaginationInfo();
		pagingInfo.setBlockSize(10);
		pagingInfo.setRecordCountPerPage(12);
		pagingInfo.setCurrentPage(searchVo.getCurrentPage());
		
		searchVo.setBlockSize(pagingInfo.getBlockSize());
		searchVo.setRecordCountPerPage(pagingInfo.getRecordCountPerPage());
		searchVo.setFirstRecordIndex(pagingInfo.getFirstRecordIndex());
		
		PaginationInfo onePage = new PaginationInfo();
		onePage.setBlockSize(1);
		onePage.setRecordCountPerPage(12);
		onePage.setCurrentPage(searchVo.getCurrentPage());
		
		searchVo.setBlockSize(onePage.getBlockSize());
		searchVo.setRecordCountPerPage(onePage.getRecordCountPerPage());
		searchVo.setFirstRecordIndex(onePage.getFirstRecordIndex());
				
		List<FaqVO> ulist = new ArrayList<FaqVO>();
		
		searchVo.setCategory(categoryName); //카테고리 검색용
		
		if(categoryName!=null && !categoryName.isEmpty()){
			ulist = faqService.searchCategory(searchVo);
			logger.info("FAQ User 목록 조회 결과 ulist.size()={}", ulist.size());
		}else{
			ulist = faqService.selectAllFaq(searchVo);
		}
		
		int totalRecord=faqService.selectTotalCount(searchVo);
		pagingInfo.setTotalRecord(totalRecord);
		onePage.setTotalRecord(totalRecord);
				
		model.addAttribute("ulist", ulist);
		model.addAttribute("pagingInfo", pagingInfo);
		model.addAttribute("onePage", onePage);
		
		return "faq/faqUserList";
	}
	
	@RequestMapping("/selectDelete.ag")
	public String selectDelete(@ModelAttribute FaqListVO fListVo, Model model){
		//1.
		logger.info("관리자 선택한 FAQ 삭제, 파라미터 fListVo = {}", fListVo);
		List<FaqVO> fList = fListVo.getFaqList();
		
		logger.info("fList.size() = {}", fList.size());
		
		//2.
		int cnt=faqService.selectDelete(fList);
		logger.info("선택한 FAQ 삭제 처리 결과, cnt = {}", cnt);
		
		String msg="", url="/faq/faqList.ag";
		
		if(cnt>0){
			for(int i=0;i<fList.size();i++){
				FaqVO faqVo=fList.get(i);
				
				int faqNo=faqVo.getFaqNo();

				logger.info("i = {}, faqNo = {}", i, faqNo);
			}//for
			msg="선택한 FAQ 삭제 성공";
		}else{
			msg="선택한 FAQ 삭제 실패";
		}//if
		
		//3.
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		
		return "common/message";
	}
}