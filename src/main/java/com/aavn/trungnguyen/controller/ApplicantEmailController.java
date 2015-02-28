package com.aavn.trungnguyen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.aavn.trungnguyen.domain.ApplicantEmail;
import com.aavn.trungnguyen.service.IApplicantEmailService;

@Controller
public class ApplicantEmailController {
	@Autowired
	private IApplicantEmailService applicantEmailService;
	
	@RequestMapping(value="/applicantEmail", method=RequestMethod.GET)
	public String showAddPage(Model model) {
		return applicantEmailService.showAddPage(model);
	}
	
	@RequestMapping(value="/applicantEmail", method=RequestMethod.POST)
	public String showSuccessPage(@ModelAttribute("applicantEmail") ApplicantEmail applicantEmail) {
		applicantEmailService.add(applicantEmail);
		return "redirect:/applicantEmail/" + applicantEmail.getId();
	}
	
	@RequestMapping(value="/applicantEmail/{id}", method=RequestMethod.GET)
	public String showUpdatePage(Model model, @PathVariable("id") int applicantEmailId) {
		return applicantEmailService.showUpdatePage(model, applicantEmailId);
	}
	
	@RequestMapping(value="/applicantEmail/{id}", method=RequestMethod.POST)
	public @ResponseBody boolean update(Model model, @ModelAttribute("applicantEmail") ApplicantEmail applicantEmail) {
		return applicantEmailService.update(model, applicantEmail);
	}
	
	@RequestMapping("/applicantEmails")
	public String showListPage(Model model, @ModelAttribute("pageAction") String pageAction, WebRequest request, HttpServletRequest servletRequest) {
		if ("delete".equals(pageAction) && request.getParameterValues("applicantEmailIds") != null) {
			String[] applicantEmailIds = request.getParameterValues("applicantEmailIds");
			applicantEmailService.delete(applicantEmailIds);
		}
		applicantEmailService.showListPage(model);
		return "applicantEmail/list";
	}

}
