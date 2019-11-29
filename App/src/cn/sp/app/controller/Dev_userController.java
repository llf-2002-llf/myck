package cn.sp.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sp.app.entity.Dev_user;
import cn.sp.app.service.Dev_userService;

@Controller
@RequestMapping("/dev")
public class Dev_userController {
	
	@Resource
	private Dev_userService ds;
	
	@RequestMapping("/login")
	public String login(String devCode,String devPassword,HttpSession session){
		Dev_user du = ds.login(devCode, devPassword);
		if(du != null){
			session.removeAttribute("error");
			session.setAttribute("devCode", du.getDevCode());
			session.setAttribute("devName", du.getDevName());
			return "developer/main";
		}else {
			session.setAttribute("error", "用户名或密码错误！");
			return "devlogin";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping("/cho")
	public String choice(){
		return "devlogin";
	}
	
	@RequestMapping("/vindicate")
	public String vindicate(){
		return "developer/appinfolist";
	}
}
