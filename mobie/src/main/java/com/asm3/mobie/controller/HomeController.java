package com.asm3.mobie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.asm3.mobie.dao.ProductDAO;

@Controller
public class HomeController {
	@GetMapping(value = {"/home","/"})
	private String home(Model model, HttpSession session) {

		session.setAttribute("ListProduct", ProductDAO.listProduct());
		model.addAttribute("LOGIN", "Sign In");
		model.addAttribute("LIST_PRODUCT", session.getAttribute("ListProduct"));
		model.addAttribute("BODY", "body.jsp");//chọn body.jsp là phần thân của web
				
		return "home";
	}
	/*
	@GetMapping(value ="/")
		private String note() {
		return "note";
	}*/
}
