package cn.sp.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sp.app.entity.Backend_user;
import cn.sp.app.entity.Data_dictionary;
import cn.sp.app.service.Backend_userService;

@Controller
@RequestMapping("/backend")
public class Backend_userController {
	
	@Resource
	private Backend_userService bs;
	
	@RequestMapping("/login")
	public String login(String userCode,String userPassword,Data_dictionary dd,HttpSession session){
		Backend_user bu = bs.login(userCode, userPassword, dd);
		if(bu != null){
			session.setAttribute("userCode", userCode);
			session.setAttribute("userName", bu.getUserName());
			session.setAttribute("valueName", dd.getValueName());
			System.out.println(dd);
			return "backend/main";
		}else {
			session.setAttribute("error", "用户名或密码错误！");
			return "backendlogin";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "backendlogin";
	}
	
	@RequestMapping("/cho")
	public String choice(){
		return "backendlogin";
	}
}
