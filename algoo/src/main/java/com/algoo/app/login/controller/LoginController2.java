package com.algoo.app.login.controller;

import javax.servlet.http.HttpSession;
import javax.tools.DocumentationTool.Location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.algoo.app.commem.model.CommemService;
import com.algoo.app.commem.model.CommemVO;
import com.algoo.app.member.model.MemberService;
import com.algoo.app.member.model.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController2 {
	private static final Logger logger
	 = LoggerFactory.getLogger(LoginController2.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CommemService commemService;
	
	@RequestMapping(value="/login.ag" , method=RequestMethod.GET)
	public String Login_get(@RequestParam(required=false) String type){
		logger.info("로그인 종류 파라미터 type={}", type);
		
		return "login/login";
	}
	
	@RequestMapping(value="/ajax/login.ag")
	@ResponseBody
	public int Login_post(
			@RequestParam(required=false) String userid,
			@RequestParam(required=false) String pwd,
			@RequestParam(required=false) String type,
			HttpSession session,
			Model model){
		logger.info("ajax 로그인 파라미터 userid={}, pwd={}",userid,pwd);
		logger.info("ajax type={}",type);
		
		
		int result=0;
		if(type.equals("personal")){
			//개인회원
			MemberVO memberVo = memberService.selectMemberByUserid(userid);
			
			if(memberVo != null){
				memberVo.setUserid(userid);
				memberVo.setPassword(pwd);
				
				result = memberService.loginCheck(memberVo);
				
				logger.info("ajax result={}",result);
				
				if(result==memberService.LOGIN_OK){
					session.setAttribute("userid", userid);
					session.setAttribute("userName", memberVo.getUserName());
					session.setAttribute("nickName", memberVo.getNickName());
					session.setAttribute("authCode", "1"); //1이면 개인회원
				}
			}else{
				return memberService.ID_NONE;
			}
		}else if(type.equals("company")){
			//기업회원
			CommemVO commemVo = commemService.selectMemberByUserid(userid);
			
			if(commemVo != null){
				commemVo.setUserid(userid);
				commemVo.setPassword(pwd);
				
				result = commemService.loginCheck(commemVo);
				
				if(result==memberService.LOGIN_OK){
					session.setAttribute("userid", userid);
					session.setAttribute("userName", commemVo.getUserName());
					session.setAttribute("nickName", commemVo.getNickName());
					session.setAttribute("authCode", "2"); //2이면 기업회원
				}
			}else{
				return commemService.ID_NONE;
			}
		}
		return result;
	}
	@RequestMapping("/checkLogin.ag")
	public void checkLogin(){
	}
	
	@RequestMapping("/mypageType.ag")
	public String myPageType(HttpSession session){
		String userid = (String)session.getAttribute("userid");
		String authCode = (String)session.getAttribute("authCode");
		
		String resultPage="";
		if(userid==null || userid.isEmpty()){
			return "login/checkLogin";
		}
		
		if(authCode.equals("1")){
			resultPage= "redirect:/member/memInfo.ag";
		}else if(authCode.equals("2")){
			resultPage= "redirect:/member_comp/commemInfo.ag";
		}
		return resultPage;
	}
	@RequestMapping("/mypageTypeEdit.ag")
	public String myPageTypeEdit(HttpSession session){
		String userid = (String)session.getAttribute("userid");
		String authCode = (String)session.getAttribute("authCode");
		
		String resultPage="";
		if(userid==null || userid.isEmpty()){
			return "login/checkLogin";
		}
		if(authCode.equals("1")){
			resultPage= "redirect:/member/memInfoEdit.ag";
		}else if(authCode.equals("2")){
			resultPage= "redirect:/member_comp/commemInfoEdit.ag";
		}
		return resultPage;
	}

}
