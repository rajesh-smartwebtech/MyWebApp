package com.swt.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	
	
	@RequestMapping("home")
	public String home() {
				
		return "home.jsp";
	}
	
	
	@RequestMapping("demo1") 
	@ResponseBody
	public String demo1() {
		
		return "<h1>This is sample response without jsp </h1>";
	}
	
	
	@RequestMapping("demo2") 
	public String demo2( HttpServletRequest req ) {
		
		HttpSession ses = req.getSession();
		
		String name = req.getParameter("name");
		
		ses.setAttribute("name", name);

		return "home";
	}
	
	//simple use of demo 2
	@RequestMapping("demo3") 
	public String demo3( String name, HttpSession ses ) {

		ses.setAttribute("name", name);
		return "home";
	}

	@RequestMapping("demo4") 
	public String demo4(@RequestParam("name") String myname, HttpSession ses ) {

		ses.setAttribute("name", myname);
		return "home";
	}


	//ModevAndView example 
	@RequestMapping("mvc1")
	public ModelAndView mvc1(@RequestParam("name") String name  ) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name );
		mv.setViewName("home");

		return mv;
	}
	
	
	@RequestMapping("mvc2")
	public ModelAndView mvc2( Alien obj ) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", obj );
		mv.setViewName("home");

		return mv;
	}


	
}
