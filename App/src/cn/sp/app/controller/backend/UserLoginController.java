package cn.sp.app.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sp.app.entity.BackendUser;
import cn.sp.app.service.backend.BackendUserService;
import cn.sp.app.tools.Constants;

@Controller
@RequestMapping(value="/manager")
public class UserLoginController {
	
	@Resource
	private BackendUserService backendUserService;
	
	@RequestMapping(value="/login")
	public String login(){
		return "backendlogin";
	}
	
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
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
	
	@RequestMapping(value="/backend/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.USER_SESSION) == null){
			return "redirect:/manager/login";
		}
		return "backend/main";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "backendlogin";
	}
}
