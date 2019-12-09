package cn.sp.app.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sp.app.entity.BackendUser;
import cn.sp.app.service.backend.BackendUserService;
import cn.sp.app.tools.Constants;

@Controller
@RequestMapping("/manager")
public class UserLoginController {
	
	@Resource
	private BackendUserService backendUserService;
	
	//选择后台登陆
	@RequestMapping("/login")
	public String login(){
		return "backendlogin";
	}
	
	//后台登陆方法
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,HttpServletRequest request,HttpSession session){
		BackendUser user = null;
		try {
			user = backendUserService.login(userCode,userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null != user){
			session.setAttribute(Constants.USER_SESSION, user);
			return "redirect:/manager/backend/main";
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			return "backendlogin";
		}
	}
	
	//跳转至后台主页面
	@RequestMapping("/backend/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION) == null){
			return "redirect:/manager/login";
		}
		return "backend/main";
	}
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "redirect:/index.jsp";
	}
}
