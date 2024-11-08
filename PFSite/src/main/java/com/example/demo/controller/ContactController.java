package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.EchoForm;
import com.example.demo.model.ContactModel;

@Controller
public class ContactController {
	
	@GetMapping("/contact/newContact")
	public String newContact(Model model) {
	    model.addAttribute("contactModel", new ContactModel()); // ContactModelのインスタンスを追加
	    return "contact/newContact"; // テンプレートを指定
	}
	@GetMapping("/contact/confirmContact")
	public ModelAndView confirmContact(@ModelAttribute ContactModel rb, ModelAndView mav) {
		mav.addObject("rb",rb);
		mav.setViewName("content/confirmContact");
		return mav;
	}
	
	@RequestMapping("echo")
	public class EchoController{
		
		@RequestMapping(method = RequestMethod.GET)
		public String viewInput(Model model) {
			EchoForm form = new EchoForm();
			model.addAttribute(form);
			return "echo/input";
		}
	}

}