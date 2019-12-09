package cn.sp.app.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.sp.app.entity.DevUser;
import cn.sp.app.service.developer.DevUserService;
import cn.sp.app.tools.Constants;

@Controller
@RequestMapping("/dev")
public class DevLoginController {
	
	@Resource
	private DevUserService devUserService;
	
	//前台选择
	@RequestMapping("/login")
	public String login(){
		return "devlogin";
	}
	
	//前台登陆方法
	@RequestMapping("/dologin")
	public String doLogin(@RequestParam String devCode,@RequestParam String devPassword,HttpServletRequest request,HttpSession session){
		DevUser user = null;
		try {
			user = devUserService.login(devCode,devPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(null != user){
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			return "redirect:/dev/flatform/main";
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			return "devlogin";
		}
	}
	
	//前台登陆跳转
	@RequestMapping(value="/flatform/main")
	public String main(HttpSession session){
		if(session.getAttribute(Constants.DEV_USER_SESSION) == null){
			return "redirect:/dev/login";
		}
		return "developer/main";
	}
	
	//注销
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.DEV_USER_SESSION);
		return "redirect:/index.jsp";
	}
}

