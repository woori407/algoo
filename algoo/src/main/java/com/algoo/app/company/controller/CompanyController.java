package com.algoo.app.company.controller;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.algoo.app.commem.model.CommemService;
import com.algoo.app.commem.model.CommemVO;
import com.algoo.app.common.FileUploadWebUtil;
import com.algoo.app.company.model.CompanyService;
import com.algoo.app.company.model.CompanyVO;
import com.algoo.app.member.model.MemberService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	private static final Logger logger
	= LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CommemService commemService;
	
	@Autowired
	private FileUploadWebUtil fileUtil;
	
	@RequestMapping(value="/compRegister.ag", method=RequestMethod.GET)
	public String companyRegister_get(HttpSession session,Model model){
		
		
		if((String)session.getAttribute("userid")==null
				||(String)session.getAttribute("userid")==""){
			return "index.ag";
		}
		String userid=(String)session.getAttribute("userid");
		
		CompanyVO companyVo = companyService.selectCompanyByUserid(userid);
		
		model.addAttribute("companyVo", companyVo);
		
		return "company/compRegister";
	}
	
	@RequestMapping(value="/compRegister.ag", method=RequestMethod.POST)
	public String companyRegister_post(@ModelAttribute CompanyVO companyVo,
			@RequestParam(required=false) String email3,
			HttpServletRequest request,
			HttpSession session){
		
		logger.info("회사등록 파라미터 companyVo={}", companyVo);
		
		List<Map<String, Object>> fileList 
			= fileUtil.FileUpload(request, FileUploadWebUtil.IMAGE_UPLOAD);
		logger.info("업로드 파일 fileList.size() = {}"
				, fileList.size());
		
		if(companyVo.getImageUrl1() != null
					&& !companyVo.getImageUrl1().isEmpty()){
			//기존 파일이 존재하면, 기존 파일 삭제
			String upPath = fileUtil.getUploadPath(request, FileUploadWebUtil.IMAGE_UPLOAD);
			String oldFileName = companyVo.getImageUrl1();
			File oldFile = new File(upPath, oldFileName);
			if(oldFile.exists()){
				boolean bool = oldFile.delete();
				logger.info("기존 파일 삭제 여부 = {}", bool);
			}
		}
		if(companyVo.getImageUrl2() != null
				&& !companyVo.getImageUrl2().isEmpty()){
			//기존 파일이 존재하면, 기존 파일 삭제
			String upPath = fileUtil.getUploadPath(request, FileUploadWebUtil.IMAGE_UPLOAD);
			String oldFileName = companyVo.getImageUrl2();
			File oldFile = new File(upPath, oldFileName);
			if(oldFile.exists()){
				boolean bool = oldFile.delete();
				logger.info("기존 파일 삭제 여부 = {}", bool);
			}
		}
		if(companyVo.getImageUrl3() != null
				&& !companyVo.getImageUrl3().isEmpty()){
			//기존 파일이 존재하면, 기존 파일 삭제
			String upPath = fileUtil.getUploadPath(request, FileUploadWebUtil.IMAGE_UPLOAD);
			String oldFileName = companyVo.getImageUrl3();
			File oldFile = new File(upPath, oldFileName);
			if(oldFile.exists()){
				boolean bool = oldFile.delete();
				logger.info("기존 파일 삭제 여부 = {}", bool);
			}
		}
		if(companyVo.getImageUrl4() != null
				&& !companyVo.getImageUrl4().isEmpty()){
			//기존 파일이 존재하면, 기존 파일 삭제
			String upPath = fileUtil.getUploadPath(request, FileUploadWebUtil.IMAGE_UPLOAD);
			String oldFileName = companyVo.getImageUrl4();
			File oldFile = new File(upPath, oldFileName);
			if(oldFile.exists()){
				boolean bool = oldFile.delete();
				logger.info("기존 파일 삭제 여부 = {}", bool);
			}
		}
		
		//업로드된 파일명 구해오기
		String fileName = "";
		long fileSize = 0;
		int i = 1;
		for(Map<String, Object> mymap : fileList){
			fileName = (String)mymap.get("fileName");
			fileSize = (Long)mymap.get("fileSize");
			if(i == 1){
				companyVo.setImageUrl1(fileName);
			}else if(i == 2){
				companyVo.setImageUrl2(fileName);
			}else if(i == 3){
				companyVo.setImageUrl3(fileName);
			}else if(i == 4){
				companyVo.setImageUrl4(fileName);
			}
			i++;
		}
		
		
		
		String hp2=companyVo.getHp2();
		String hp3=companyVo.getHp3();
		if(hp2==null || hp2.isEmpty() ||hp3==null ||hp3.isEmpty()){
			companyVo.setFax1("");
			companyVo.setFax2("");
			companyVo.setFax3("");
		}
		
		String fax2=companyVo.getFax2();
		String fax3=companyVo.getFax3();
		if(fax2==null || fax2.isEmpty() ||fax3==null ||fax3.isEmpty()){
			companyVo.setFax1("");
			companyVo.setFax2("");
			companyVo.setFax3("");
		}
		
		String phone2=companyVo.getPhone2();
		String phone3=companyVo.getPhone3();
		
		if(phone2==null || phone2.isEmpty() ||phone3==null ||phone3.isEmpty()){
			companyVo.setPhone1("");
			companyVo.setPhone2("");
			companyVo.setPhone3("");
		}
		
		String email1 = companyVo.getEmail1();
		String email2 = companyVo.getEmail2();
		
		if(email1==null || email1.isEmpty()){
			companyVo.setEmail1("");
			companyVo.setEmail2("");
		}else{
			if(email2.equals("etc")){
				if(email3!=null && !email3.isEmpty()){
					companyVo.setEmail2(email3);
				}else{
					companyVo.setEmail1("");
					companyVo.setEmail2("");
				}
			}
		}
		int result = companyService.insertCompany(companyVo);
		logger.info("회사등록 처리결과, companyVo={}, result={}", companyVo , result);
		
		String userid=(String)session.getAttribute("userid");
		CommemVO commemVo 
			= commemService.selectMemberByUserid(userid);
		
		commemVo.setCompCode(companyVo.getCompCode());
		logger.info("업데이트할 CompCode={},",companyVo.getCompCode());
		
		result=commemService.updateCompCode(commemVo);
		logger.info("기업회원 코드업데이트 처리 result={}", result);
		
		return "redirect:/company/compRegister.ag";
	}
	@RequestMapping("/compEdit.ag")
	public String companyEdit(@ModelAttribute CompanyVO companyVo,
			@RequestParam(required=false) String email3, HttpSession session){
		
		logger.info("회사수정 파라미터 companyVo={}", companyVo);
		
		String hp2=companyVo.getHp2();
		String hp3=companyVo.getHp3();
		if(hp2==null || hp2.isEmpty() ||hp3==null ||hp3.isEmpty()){
			companyVo.setFax1("");
			companyVo.setFax2("");
			companyVo.setFax3("");
		}
		
		String fax2=companyVo.getFax2();
		String fax3=companyVo.getFax3();
		if(fax2==null || fax2.isEmpty() ||fax3==null ||fax3.isEmpty()){
			companyVo.setFax1("");
			companyVo.setFax2("");
			companyVo.setFax3("");
		}
		
		String phone2=companyVo.getPhone2();
		String phone3=companyVo.getPhone3();
		
		if(phone2==null || phone2.isEmpty() ||phone3==null ||phone3.isEmpty()){
			companyVo.setPhone1("");
			companyVo.setPhone2("");
			companyVo.setPhone3("");
		}
		
		String email1 = companyVo.getEmail1();
		String email2 = companyVo.getEmail2();
		
		if(email1==null || email1.isEmpty()){
			companyVo.setEmail1("");
			companyVo.setEmail2("");
		}else{
			if(email2.equals("etc")){
				if(email3!=null && !email3.isEmpty()){
					companyVo.setEmail2(email3);
				}else{
					companyVo.setEmail1("");
					companyVo.setEmail2("");
				}
			}
		}
		String userid=(String)session.getAttribute("userid");
		CommemVO commemVo
			= commemService.selectMemberByUserid(userid);
		
		companyVo.setCompCode(commemVo.getCompCode());
		logger.info("수정 처리전 companyVo={}",companyVo);
		
		int result=companyService.updateCompany(companyVo);
		
		return "redirect:/company/compRegister.ag";
	}
	
	@RequestMapping("/compDetail.ag")
	public String companyDetail(@ModelAttribute CompanyVO companyVo, 
			HttpSession session, Model model){
		
		String userid=(String)session.getAttribute("userid");
		CommemVO commemVo
			= commemService.selectMemberByUserid(userid);
		
		companyVo.setCompCode(commemVo.getCompCode());
		
		companyVo =companyService.selectCompanyByCode(companyVo.getCompCode());
		logger.info("기업 정보 화면 보여주기 companyVo={}", companyVo);
		
		model.addAttribute("companyVo", companyVo);
		
		return "company/compDetail";
	}
}
